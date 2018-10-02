package teammates.ui.controller;

import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.ui.pagedata.InstructorDiscussionBoardTopicEditPageData;
import teammates.ui.pagedata.StudentDiscussionBoardTopicEditPageData;
import teammates.common.datatransfer.attributes.TopicAttributes;

 public class InstructorDiscussionBoardTopicEditPageAction extends Action {
     @Override
    public ActionResult execute() {
         String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        //
        // String topicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        // Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, topicName);
         TopicAttributes topic = logic.getTopic(topicId);
         System.out.println("Editing Topic: " + topic.getName() + ", " + topic.getDesc());
        InstructorDiscussionBoardTopicEditPageData data =
                new InstructorDiscussionBoardTopicEditPageData(account, sessionToken, topic, topic.getCount());
         return createShowPageResult(Const.ViewURIs.INSTRUCTOR_DISCUSSION_BOARD_TOPIC_EDIT, data);
     }
 }
