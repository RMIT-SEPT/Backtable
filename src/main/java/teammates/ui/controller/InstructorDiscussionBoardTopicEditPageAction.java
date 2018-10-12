package teammates.ui.controller;

import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.ui.pagedata.InstructorDiscussionBoardTopicEditPageData;
import teammates.common.datatransfer.attributes.TopicAttributes;

/**
 * Action to edit a topic from discussion board when instructor is active
 */
 public class InstructorDiscussionBoardTopicEditPageAction extends Action {
     @Override
    public ActionResult execute() {
        //request topic id from url parameter
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        
        //use id to return topic for editing
        TopicAttributes topic = logic.getTopic(topicId);
        
        //initialize data for pushing to the page
        InstructorDiscussionBoardTopicEditPageData data =
                new InstructorDiscussionBoardTopicEditPageData(account, sessionToken, topic, topic.getCount());
         return createShowPageResult(Const.ViewURIs.INSTRUCTOR_DISCUSSION_BOARD_TOPIC_EDIT, data);
     }
 }
