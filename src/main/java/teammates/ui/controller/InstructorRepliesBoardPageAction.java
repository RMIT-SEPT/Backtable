package teammates.ui.controller;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.InstructorRepliesBoardPageData;

/**
 * Action: Instructor replies board
 *
 */
public class InstructorRepliesBoardPageAction extends Action {

    /*
     * Variable declarations
     */
    InstructorRepliesBoardPageData data;
    TopicAttributes topic;

    @Override
    protected ActionResult execute() {
        //getting topic name at the moment, whereas would be better to use topic id
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        
        //set student profile as current user
        account.studentProfile = logic.getStudentProfile(account.googleId);
        
        //set data object
        data = new InstructorRepliesBoardPageData(account, sessionToken);
        
        //retrieve relevant topic from database
        topic = logic.getTopic(topicId);

        //set views of the topic and iterate
        topic.setViewCounter(topic.getViewCounter() + 1);
        
        //initialise data with topic
        data.init(topic);
        
        //try to update topic and catch exceptions
        try {
            logic.updateTopic((topic));
        } catch (InvalidParametersException e) {
            e.printStackTrace();
        } catch (EntityDoesNotExistException e) {
            e.printStackTrace();
        }

        return createShowPageResult(Const.ViewURIs.INSTRUCTOR_REPLIES_BOARD_PAGE, data);
    }


}
