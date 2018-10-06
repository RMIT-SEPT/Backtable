package teammates.ui.controller;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.StudentRepliesBoardPageData;

/**
 * Action: showing the reply board for student.
 */
public class StudentRepliesBoardPageAction extends Action {

    /*
     * Variable declarations
     */
    StudentRepliesBoardPageData data;
    TopicAttributes topic;

    @Override
    protected ActionResult execute() {
        //get url request parameters and assert not null
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        
        //set studentProfile as current user
        account.studentProfile = logic.getStudentProfile(account.googleId);
        //set data object
        data = new StudentRepliesBoardPageData(account, sessionToken);
        //retrieve relevant topic from database
        topic = logic.getTopic(topicId);
        //set view counter and iterate
        topic.setViewCounter(topic.getViewCounter() + 1);
        //set data with values of topic
        data.init(topic);
        //try update topic and catch exceptions
        try {
            logic.updateTopic((topic));
        } catch (InvalidParametersException e) {
            e.printStackTrace();
        } catch (EntityDoesNotExistException e) {
            e.printStackTrace();
        }
        return createShowPageResult(Const.ViewURIs.STUDENT_REPLIES_BOARD_PAGE, data);
    }

}
