package teammates.ui.controller;

import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.StudentRepliesBoardPageData;

/**
 * Action: showing the profile page for a student in a course.
 */
public class StudentRepliesBoardPageAction extends Action {

    private static final Logger log = Logger.getLogger();

    @Override
    protected ActionResult execute() {
        
        account.studentProfile = logic.getStudentProfile(account.googleId);
        
            
        StudentRepliesBoardPageData data = new StudentRepliesBoardPageData(account, sessionToken);
        data.createFalseData();
        return createShowPageResult(Const.ViewURIs.STUDENT_REPLIES_BOARD_PAGE, data);
    }

}
