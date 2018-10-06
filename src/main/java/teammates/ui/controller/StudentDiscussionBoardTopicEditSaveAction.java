package teammates.ui.controller;

import java.util.ArrayList;
import java.util.List;

import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.StatusMessage;
import teammates.common.util.StatusMessageColor;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.ui.pagedata.StudentDiscussionBoardPageData;
import teammates.logic.core.TopicsLogic;


public class StudentDiscussionBoardTopicEditSaveAction extends Action {

    /**
     * Action for saving edited topic when student is active user
     */
    @Override
    public ActionResult execute() {

        //request parameters from url and assert not null
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        String editedTopicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, editedTopicName);
        String editedTopicDesc = getRequestParamValue(Const.ParamsNames.TOPIC_DESC);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_DESC, editedTopicDesc);
        
        //retreive replies from database
        ArrayList<RepliesAttributes> replies = logic.getTopic(topicId).getReplies();

        //initialise edited topic with new values
        TopicAttributes editedTopic = new TopicAttributes(topicId, account.getName(), editedTopicName, editedTopicDesc, replies, logic.getTopic(topicId).getCount(),logic.getTopic(topicId).getViewCounter());

        //save edited topic over topic to be updated
        TopicsLogic.getTopicsDb().saveEntity(editedTopic.toEntity());

        //initialise data for page data
        StudentDiscussionBoardPageData data = new StudentDiscussionBoardPageData(account, sessionToken);

        //retrieve all topics from the database
        List<TopicAttributes> allTopics = logic.getAllTopics();

        //set topics as part of the data for page result
        data.init(allTopics);

        return createShowPageResult(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_PAGE, data);
    }

}
