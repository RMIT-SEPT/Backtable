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
        System.out.println("made it here");
        String idOfTopicToDelete = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, idOfTopicToDelete);
        System.out.println(idOfTopicToDelete);
        //Logic will help us to delete the TopicAttribute instance in the datase
        logic.deleteTopic(idOfTopicToDelete);
        String statusMessage = String.format(Const.StatusMessages.TOPIC_DELETED, idOfTopicToDelete);
        statusToUser.add(new StatusMessage(statusMessage, StatusMessageColor.SUCCESS));
        statusToAdmin = "Topic deleted: " + idOfTopicToDelete;
        //Redirect to STUDENT_DISCUSSION_BOARD_PAGE
        return createRedirectResult(Const.ActionURIs.STUDENT_DISCUSSION_BOARD_PAGE);
    }

}