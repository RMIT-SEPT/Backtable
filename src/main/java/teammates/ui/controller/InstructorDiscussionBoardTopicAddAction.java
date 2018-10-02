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

    private static final Logger log = Logger.getLogger();
    InstructorDiscussionBoardPageData data;
   
    
    @Override
    protected ActionResult execute() throws EntityDoesNotExistException {
        String uniqueID = UUID.randomUUID().toString();
        
       //Request the value from front-end for TopicAttribute initiation
        String newTopicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, newTopicName);
        String newTopicDesc = getRequestParamValue(Const.ParamsNames.TOPIC_DESC);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_DESC, newTopicDesc);


        System.out.println(newTopicName + "    " + newTopicDesc);

        data = new InstructorDiscussionBoardPageData(account, sessionToken);

        //Initiate a TopicAttribute - the following behaviours of this function will help to store the data into database
        createTopic(uniqueID, newTopicName, newTopicDesc);

        List<TopicAttributes> allTopics = logic.getAllTopics();

        data.init(allTopics);
        
        //Redirect the page to Discussion board page.
        return createRedirectResult(Const.ActionURIs.STUDENT_DISCUSSION_BOARD_PAGE);

       
    }
    
    private void createTopic(String uniqueID, String newTopicName, String newTopicDesc) {
        try {
            logic.createDiscussionBoardTopic(uniqueID, newTopicName, newTopicDesc, new ArrayList<Reply>());
            statusToUser.add(new StatusMessage("successufully added", StatusMessageColor.SUCCESS));
            isError = false;
        } catch (EntityAlreadyExistsException e) {
            setStatusForException(e, Const.StatusMessages.COURSE_EXISTS);
        } catch (InvalidParametersException e) {
            setStatusForException(e);
        }
    }

}
