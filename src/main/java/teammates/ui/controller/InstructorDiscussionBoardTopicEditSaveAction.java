package teammates.ui.controller;

import java.util.ArrayList;
import java.util.List;

import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.ui.pagedata.InstructorDiscussionBoardPageData;
import teammates.logic.core.TopicsLogic;


public class InstructorDiscussionBoardTopicEditSaveAction extends Action {

    @Override
    public ActionResult execute() {

        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        String editedTopicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, editedTopicName);
        String editedTopicDesc = getRequestParamValue(Const.ParamsNames.TOPIC_DESC);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_DESC, editedTopicDesc);
        ArrayList<RepliesAttributes> replies = logic.getTopic(topicId).getReplies();

        System.out.println(topicId + ", " + editedTopicName + ", " + editedTopicDesc);

        TopicAttributes editedTopic = new TopicAttributes(topicId, editedTopicName, editedTopicDesc, replies, logic.getTopic(topicId).getCount(),logic.getTopic(topicId).getViewCounter());

        TopicsLogic.getTopicsDb().saveEntity(editedTopic.toEntity());

        InstructorDiscussionBoardPageData data = new InstructorDiscussionBoardPageData(account, sessionToken);

        List<TopicAttributes> allTopics = logic.getAllTopics();

        data.init(allTopics);

        return createShowPageResult(Const.ViewURIs.INSTRUCTOR_DISCUSSION_BOARD_PAGE, data);
    }

}
