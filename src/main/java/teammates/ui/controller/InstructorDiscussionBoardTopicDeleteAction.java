/**
 * 
 */
package teammates.ui.controller;

import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.StatusMessage;
import teammates.common.util.StatusMessageColor;

/**
 * @author Christina
 *
 */
public class InstructorDiscussionBoardTopicDeleteAction extends Action {

    /* (non-Javadoc)
     * @see teammates.ui.controller.Action#execute()
     */
    @Override
    protected ActionResult execute() throws EntityDoesNotExistException {        
        String idOfTopicToDelete = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, idOfTopicToDelete);
        System.out.println(idOfTopicToDelete);
        //Logic will help us to delete the TopicAttribute instance in the datase
        logic.deleteTopic(idOfTopicToDelete);
        String statusMessage = String.format(Const.StatusMessages.TOPIC_DELETED, idOfTopicToDelete);
        statusToUser.add(new StatusMessage(statusMessage, StatusMessageColor.SUCCESS));
        statusToAdmin = "Topic deleted: " + idOfTopicToDelete;
        //Redirect to STUDENT_DISCUSSION_BOARD_PAGE
        return createRedirectResult(Const.ActionURIs.INSTRUCTOR_DISCUSSION_BOARD_PAGE);
    }
    
}


