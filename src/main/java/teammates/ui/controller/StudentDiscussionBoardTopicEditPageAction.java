package teammates.ui.controller;

import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.ui.pagedata.StudentDiscussionBoardTopicEditPageData;
import teammates.common.datatransfer.attributes.TopicAttributes;
 
/**
 *  Action page to edit topic when student is active 
 *
 */
public class StudentDiscussionBoardTopicEditPageAction extends Action {
     @Override
    public ActionResult execute() {
         //get parameter from url request and assert not null
         String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
         Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        
         //retrieve relevant topic from database
         TopicAttributes topic = logic.getTopic(topicId);
         
         //initialize data for page
         StudentDiscussionBoardTopicEditPageData data =
                new StudentDiscussionBoardTopicEditPageData(account, sessionToken, topic, topic.getCount());
         
         return createShowPageResult(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_TOPIC_EDIT, data);
     }
 }
