/**
 * 
 */
package teammates.ui.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityAlreadyExistsException;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.common.util.StatusMessage;
import teammates.common.util.StatusMessageColor;
import teammates.storage.entity.Reply;
import teammates.ui.pagedata.InstructorDiscussionBoardPageData;

/**
 * @author Christina
 *
 */
public class InstructorDiscussionBoardTopicAddAction extends Action{

    //declare data object
    InstructorDiscussionBoardPageData data;
   
    
    @Override
    protected ActionResult execute() throws EntityDoesNotExistException {
        //generate unique String for topicId
        String uniqueID = UUID.randomUUID().toString();
        
       //Request the value from front-end for TopicAttribute initiation
        String newTopicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, newTopicName);
        String newTopicDesc = getRequestParamValue(Const.ParamsNames.TOPIC_DESC);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_DESC, newTopicDesc);
        
        data = new InstructorDiscussionBoardPageData(account, sessionToken);

        //Initiate a TopicAttribute - the following behaviours of this function will help to store the data into database
        createTopic(uniqueID, account.getName(), newTopicName, newTopicDesc);

        List<TopicAttributes> allTopics = logic.getAllTopics();
        
        //initiate data with topics
        data.init(allTopics);
        
        //Redirect the page to Discussion board page.
        return createRedirectResult(Const.ActionURIs.INSTRUCTOR_DISCUSSION_BOARD_PAGE);
    }
    
    //creates topic in the database
    //fails if parameters are invalid or entity already exists
    private void createTopic(String uniqueID, String creator, String newTopicName, String newTopicDesc) {
        try {
            logic.createDiscussionBoardTopic(uniqueID, creator, newTopicName, newTopicDesc, new ArrayList<Reply>());
            statusToUser.add(new StatusMessage("successufully added", StatusMessageColor.SUCCESS));
            isError = false;
        } catch (EntityAlreadyExistsException e) {
            setStatusForException(e, Const.StatusMessages.COURSE_EXISTS);
        } catch (InvalidParametersException e) {
            setStatusForException(e);
        }
    }

}
