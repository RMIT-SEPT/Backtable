package teammates.ui.controller;

import java.util.ArrayList;
import java.util.List;

import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.ui.pagedata.InstructorDiscussionBoardPageData;
import teammates.logic.core.TopicsLogic;

/**
 * Action to save the edited topic
 */
public class InstructorDiscussionBoardTopicEditSaveAction extends Action {

    @Override
    public ActionResult execute() {

        //request parameters from URL required for topic saving
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        String editedTopicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, editedTopicName);
        String editedTopicDesc = getRequestParamValue(Const.ParamsNames.TOPIC_DESC);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_DESC, editedTopicDesc);
        ArrayList<RepliesAttributes> replies = logic.getTopic(topicId).getReplies();

        //edited topic initialised with new values
        TopicAttributes editedTopic = new TopicAttributes(topicId, account.getName(), editedTopicName, editedTopicDesc, replies, logic.getTopic(topicId).getCount(),logic.getTopic(topicId).getViewCounter());

        //save edited topic into database
        TopicsLogic.getTopicsDb().saveEntity(editedTopic.toEntity());

        //initialize data for the page
        InstructorDiscussionBoardPageData data = new InstructorDiscussionBoardPageData(account, sessionToken);

        //retrieve all topics from database
        List<TopicAttributes> allTopics = logic.getAllTopics();

        //set topics into the page data
        data.init(allTopics);

        return createShowPageResult(Const.ViewURIs.INSTRUCTOR_DISCUSSION_BOARD_PAGE, data);
    }

}
