package teammates.ui.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityAlreadyExistsException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.common.util.StatusMessage;
import teammates.common.util.StatusMessageColor;
import teammates.storage.entity.Reply;
import teammates.ui.pagedata.StudentDiscussionBoardPageData;

/**
 * Action: Student create a topic.
 */
public class StudentDiscussionBoardTopicAddAction extends Action { 
    StudentDiscussionBoardPageData data;
    
    @Override
    public ActionResult execute() {

        String uniqueID = UUID.randomUUID().toString();
        account.studentProfile = logic.getStudentProfile(account.googleId);
        
       //Request the value from front-end for TopicAttribute initiation
        String newTopicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, newTopicName);
        String newTopicDesc = getRequestParamValue(Const.ParamsNames.TOPIC_DESC);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_DESC, newTopicDesc);


        System.out.println(newTopicName + "    " + newTopicDesc);
        
        data = new StudentDiscussionBoardPageData(account, sessionToken);

        //Initiate a TopicAttribute - the following behaviours of this function will help to store the data into database
        createTopic(uniqueID, account.getName(), newTopicName, newTopicDesc, new ArrayList<Reply>());

        List<TopicAttributes> allTopics = logic.getAllTopics();

        data.init(allTopics);
        //Redirect the page to Discussion board page.
        return createRedirectResult(Const.ActionURIs.STUDENT_DISCUSSION_BOARD_PAGE);
        
    }

    /**
     * Create a topic and check if it already exists or not if yes, throw exception
     * @param newTopicName name should be unique
     * @param newTopicDesc
     *
     */
    
    private void createTopic(String uniqueID, String creator, String newTopicName, String newTopicDesc, ArrayList<Reply> replies) {
        try {
            logic.createDiscussionBoardTopic(uniqueID, creator, newTopicName, newTopicDesc, replies);
            statusToUser.add(new StatusMessage("successufully added", StatusMessageColor.SUCCESS));
            isError = false;
        } catch (EntityAlreadyExistsException e) {
            setStatusForException(e, Const.StatusMessages.COURSE_EXISTS);
        } catch (InvalidParametersException e) {
            setStatusForException(e);
        }
    }


    
    
}
