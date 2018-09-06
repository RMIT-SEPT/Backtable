package teammates.ui.controller;

import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.StatusMessage;
import teammates.common.util.StatusMessageColor;

/**
 * Action: Delete a topic for a student.
 */

public class StudentDiscussionBoardTopicDeleteAction extends Action {

    @Override
    public ActionResult execute() {

        String nameOfTopictoDelete = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, nameOfTopictoDelete);


        /* Delete the course and setup status to be shown to user and admin */
        logic.deleteTopic(nameOfTopictoDelete);
        String statusMessage = String.format(Const.StatusMessages.TOPIC_DELETED, nameOfTopictoDelete);
        statusToUser.add(new StatusMessage(statusMessage, StatusMessageColor.SUCCESS));
        statusToAdmin = "Topic deleted: " + nameOfTopictoDelete;


        return createRedirectResult(Const.ActionURIs.STUDENT_DISCUSSION_BOARD_PAGE);
    }

    /**
     * Checks if the action is executed in homepage or 'Courses' pages based on its redirection.
     */
    private boolean isRedirectedToHomePage() {
        String nextUrl = getRequestParamValue(Const.ParamsNames.NEXT_URL);
        return nextUrl != null && nextUrl.equals(Const.ActionURIs.INSTRUCTOR_HOME_PAGE);
    }
}