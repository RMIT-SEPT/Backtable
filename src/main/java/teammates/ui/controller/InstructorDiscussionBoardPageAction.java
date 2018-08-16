package teammates.ui.controller;

import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.InstructorDiscussionBoardPageData;

/**
 * Action: showing the profile page for a student in a course.
 */
public class InstructorDiscussionBoardPageAction extends Action {

    private static final Logger log = Logger.getLogger();

    @Override
    protected ActionResult execute() {
        InstructorDiscussionBoardPageData data = new InstructorDiscussionBoardPageData(account, sessionToken);

        return createShowPageResult(Const.ViewURIs.INSTRUCTOR_DISCUSSION_BOARD_PAGE, data);
    }

}
