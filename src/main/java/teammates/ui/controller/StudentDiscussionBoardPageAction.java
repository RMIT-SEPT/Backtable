package teammates.ui.controller;

import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.StudentDiscussionBoardPageData;

/**
 * Action: showing the profile page for a student in a course.
 */
public class StudentDiscussionBoardPageAction extends Action {

    private static final Logger log = Logger.getLogger();

    @Override
    protected ActionResult execute() {
        StudentDiscussionBoardPageData data = new StudentDiscussionBoardPageData(account, sessionToken);

        return createShowPageResult(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_PAGE, data);
    }

}
