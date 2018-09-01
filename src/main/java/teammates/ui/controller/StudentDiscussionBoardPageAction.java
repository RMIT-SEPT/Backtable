package teammates.ui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import teammates.common.exception.EntityAlreadyExistsException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.common.util.SanitizationHelper;
import teammates.common.util.StatusMessage;
import teammates.common.util.StatusMessageColor;
import teammates.common.util.StringHelper;

import teammates.ui.pagedata.StudentDiscussionBoardPageData;

/**
 * Action: adding a course for an instructor.
 */
public class StudentDiscussionBoardPageAction extends Action { 
    private static final Logger log = Logger.getLogger();
    StudentDiscussionBoardPageData data;
    
    @Override
    public ActionResult execute() {
        
        account.studentProfile = logic.getStudentProfile(account.googleId);
        
        /*System.out.println("made it to new topic name");
        String newTopicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, newTopicName);
        String newTopicDesc = getRequestParamValue(Const.ParamsNames.TOPIC_DESC);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_DESC, newTopicDesc);*/
        

        /* Check if user has the right to execute the action */
      //  gateKeeper.verifyInstructorPrivileges(account);

        /* Create a new course in the database */
        data = new StudentDiscussionBoardPageData(account, sessionToken);
        data.createFalseData();

        System.out.println("made it to create topic");
        //createTopic(newTopicName, newTopicDesc);
        
        //Map<String, StudentAttributes> studentTopics = new HashMap<>();
           // List<TopicAttributes> activeTopics = new ArrayList<>();
        //List<TopicAttributes> archivedTopics = new ArrayList<>();
        
        /*String topicIdToShowParam = "";
        String topicNameToShowParam = "";*/
        
        //data.init(activeTopics, topicIdToShowParam, topicNameToShowParam);
        
        System.out.println("made it to view discussion board uri");
        
        return createShowPageResult(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_PAGE, data);
        
        
        
    }

    
    private void createTopic(String newTopicName, String newTopicDesc) {
        try {
            logic.createDiscussionBoardTopic(data.account.googleId, newTopicName, newTopicDesc);
            statusToUser.add(new StatusMessage("successufully added", StatusMessageColor.SUCCESS));
            isError = false;
        } catch (EntityAlreadyExistsException e) {
            setStatusForException(e, Const.StatusMessages.COURSE_EXISTS);
        } catch (InvalidParametersException e) {
            setStatusForException(e);
        }
    }


    
    
}
