package teammates.ui.controller;
 import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.StatusMessage;
import teammates.common.util.StatusMessageColor;
import teammates.ui.pagedata.StudentDiscussionBoardTopicEditPageData;
import teammates.common.datatransfer.attributes.TopicAttributes;
 public class StudentDiscussionBoardTopicEditPageAction extends Action {
     @Override
    public ActionResult execute() {
         String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        //
        // String topicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        // Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, topicName);
         TopicAttributes topic = logic.getTopic(topicId);
         System.out.println("Editing Topic: " + topic.getName() + ", " + topic.getDesc());
         StudentDiscussionBoardTopicEditPageData data =
                new StudentDiscussionBoardTopicEditPageData(account, sessionToken, topic);
         return createShowPageResult(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_TOPIC_EDIT, data);
     }
 }
