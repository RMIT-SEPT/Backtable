package teammates.ui.controller;

import java.util.List;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityAlreadyExistsException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.common.util.StatusMessage;
import teammates.common.util.StatusMessageColor;

import teammates.ui.pagedata.StudentDiscussionBoardPageData;

/**
 * Action: Student create a topic.
 */
public class StudentDiscussionBoardTopicAddAction extends Action { 
    private static final Logger log = Logger.getLogger();
    StudentDiscussionBoardPageData data;
    
    @Override
    public ActionResult execute() {

        account.studentProfile = logic.getStudentProfile(account.googleId);
        
       //Request the value from front-end for TopicAttribute initiation
        String newTopicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, newTopicName);
        String newTopicDesc = getRequestParamValue(Const.ParamsNames.TOPIC_DESC);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_DESC, newTopicDesc);


        System.out.println(newTopicName + "    " + newTopicDesc);

        data = new StudentDiscussionBoardPageData(account, sessionToken);

        //Initiate a TopicAttribute - the following behaviours of this function will help to store the data into database
        createTopic(newTopicName, newTopicDesc);

        List<TopicAttributes> allTopics = logic.getAllTopics();

        data.init(allTopics);
        //Redirect the page to Discussion board page.
        return createShowPageResult(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_PAGE, data);
        
        
        
    }


    /**
     * Create a topic and check if it already exists or not if yes, throw exception
     * @param newTopicName name should be unique
     * @param newTopicDesc
     *
     */
    
    private void createTopic(String newTopicName, String newTopicDesc) {
        try {
            logic.createDiscussionBoardTopic( newTopicName, newTopicDesc);
            statusToUser.add(new StatusMessage("successufully added", StatusMessageColor.SUCCESS));
            isError = false;
        } catch (EntityAlreadyExistsException e) {
            setStatusForException(e, Const.StatusMessages.COURSE_EXISTS);
        } catch (InvalidParametersException e) {
            setStatusForException(e);
        }
    }


    
    
}
