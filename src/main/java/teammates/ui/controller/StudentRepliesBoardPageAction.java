package teammates.ui.controller;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.StudentRepliesBoardPageData;

/**
 * Action: showing the profile page for a student in a course.
 */
public class StudentRepliesBoardPageAction extends Action {

    StudentRepliesBoardPageData data;
    TopicAttributes topic;
    private static final Logger log = Logger.getLogger();

    @Override
    protected ActionResult execute() {
        //getting topic name at the moment, whereas would be better to use topic id
        String topicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, topicName);
        account.studentProfile = logic.getStudentProfile(account.googleId);
        data = new StudentRepliesBoardPageData(account, sessionToken);
        topic = logic.getTopic(topicName);
        data.init(topic);
        
        return createShowPageResult(Const.ViewURIs.STUDENT_REPLIES_BOARD_PAGE, data);
    }

}
