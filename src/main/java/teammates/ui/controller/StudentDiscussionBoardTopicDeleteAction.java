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
    //Request Topic name from Front-end and use it as an ID to search that instance in the database
        String nameOfTopictoDelete = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, nameOfTopictoDelete);
        //Logic will help us to delete the TopicAttribute instance in the datase
        logic.deleteTopic(nameOfTopictoDelete);
        String statusMessage = String.format(Const.StatusMessages.TOPIC_DELETED, nameOfTopictoDelete);
        statusToUser.add(new StatusMessage(statusMessage, StatusMessageColor.SUCCESS));
        statusToAdmin = "Topic deleted: " + nameOfTopictoDelete;
        //Redirect to STUDENT_DISCUSSION_BOARD_PAGE
        return createRedirectResult(Const.ActionURIs.STUDENT_DISCUSSION_BOARD_PAGE);
    }

}