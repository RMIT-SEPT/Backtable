package teammates.ui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import teammates.common.datatransfer.attributes.CourseAttributes;
import teammates.common.datatransfer.attributes.InstructorAttributes;
import teammates.common.datatransfer.attributes.StudentAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
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
    
    @Override
    public ActionResult execute() {
        
        account.studentProfile = logic.getStudentProfile(account.googleId);
        
       /*String newTopicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, newTopicId);
        String newTopicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, newTopicName);
        String newTopicTimeZone = getRequestParamValue(Const.ParamsNames.TOPIC_TIME_ZONE);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_TIME_ZONE, newTopicTimeZone);*/

        /* Check if user has the right to execute the action */
      //  gateKeeper.verifyInstructorPrivileges(account);

        /* Create a new course in the database */
        StudentDiscussionBoardPageData data = new StudentDiscussionBoardPageData(account, sessionToken);
        data.createFalseData();

        
       // createTopic(newTopicId, newTopicName, newTopicTimeZone);
        
        //Map<String, StudentAttributes> studentTopics = new HashMap<>();
        //List<TopicAttributes> activeTopics = new ArrayList<>();
        //List<TopicAttributes> archivedTopics = new ArrayList<>();
        
        String topicIdToShowParam = "";
        String topicNameToShowParam = "";
        
        //data.init(activeTopics, topicIdToShowParam, topicNameToShowParam);
        
        System.out.println("made it this far");
        
        return createShowPageResult(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_PAGE, data);
        
        
    }

      


       
    
    private void createTopic(String newTopicId, String newTopicName, String newCourseTimeZone) {
        try {
            logic.createCourseAndInstructor(account.googleId, newTopicId, newTopicName, newCourseTimeZone);
        } catch (EntityAlreadyExistsException e) {
            setStatusForException(e, Const.StatusMessages.COURSE_EXISTS);
        } catch (InvalidParametersException e) {
            setStatusForException(e);
        }
    }


    
    
}
