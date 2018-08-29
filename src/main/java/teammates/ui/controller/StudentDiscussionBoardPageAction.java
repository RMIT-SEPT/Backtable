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
    private StudentDiscussionBoardPageData data;
    private static final Logger log = Logger.getLogger();
    
    @Override
    public ActionResult execute() {
        
        account.studentProfile = logic.getStudentProfile(account.googleId);
        
        
        
        
        String newTopicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, newTopicId);
        String newTopicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, newTopicName);
        String newTopicTimeZone = getRequestParamValue(Const.ParamsNames.TOPIC_TIME_ZONE);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_TIME_ZONE, newTopicTimeZone);

        /* Check if user has the right to execute the action */
      //  gateKeeper.verifyInstructorPrivileges(account);

        /* Create a new course in the database */
        data = new StudentDiscussionBoardPageData(account, sessionToken);
        data.createFalseData();

        createTopic(newTopicId, newTopicName, newTopicTimeZone);

        /* Prepare data for the refreshed page after executing the adding action */
        Map<String, StudentAttributes> studentTopics = new HashMap<>();
        List<TopicAttributes> activeTopics = new ArrayList<>();
        List<TopicAttributes> archivedTopics = new ArrayList<>();
        
        return createShowPageResult(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_PAGE, data);
        
        
        
        
        
    }

        // Get list of InstructorAttributes that belong to the user.
      /* List<StudentAttributes> studentList = logic.getStudentsForGoogleId(data.account.googleId);
        for (StudentAttributes student : studentList) {
            studentTopics.put(student.topicId, student);
        }*/

        // Get corresponding courses of the instructors.
       // List<TopicAttributes> alltopics = logic.getCoursesForInstructor(instructorList);

        
        
       // List<String> archivedCourseIds = logic.getArchivedCourseIds(allCourses, instructorsForCourses);
       /* for (CourseAttributes course : allCourses) {
            if (archivedCourseIds.contains(course.getId())) {
                archivedCourses.add(course);
            } else {
                activeCourses.add(course);
            }
        }

        // Sort CourseDetailsBundle lists by course id
        CourseAttributes.sortById(activeCourses);
        CourseAttributes.sortById(archivedCourses);

        String courseIdToShowParam = "";
        String courseNameToShowParam = "";*/

      /*  if (isError) { // there is error in adding the course
            courseIdToShowParam = SanitizationHelper.sanitizeForHtml(newCourseId);
            courseNameToShowParam = SanitizationHelper.sanitizeForHtml(newCourseName);

            List<String> statusMessageTexts = new ArrayList<>();

            for (StatusMessage msg : statusToUser) {
                statusMessageTexts.add(msg.getText());
            }

            statusToAdmin = StringHelper.toString(statusMessageTexts, "<br>");
        } else {
            statusToAdmin = "Course added : " + newCourseId;
            statusToAdmin += "<br>Total courses: " + allCourses.size();
        }

        data.init(activeCourses, archivedCourses, instructorsForCourses, courseIdToShowParam, courseNameToShowParam);

        return isError ? createShowPageResult(Const.ViewURIs.INSTRUCTOR_COURSES, data)
                : createRedirectResult(Const.ActionURIs.INSTRUCTOR_COURSES_PAGE);
    }*/

    private void createTopic(String newTopicId, String newTopicName, String newCourseTimeZone) {
        try {
            logic.createCourseAndInstructor(data.account.googleId, newTopicId, newTopicName, newCourseTimeZone);
            String statusMessage = Const.StatusMessages.COURSE_ADDED.replace("${courseEnrollLink}",
                    data.getInstructorCourseEnrollLink(newTopicId)).replace("${courseEditLink}",
                    data.getInstructorCourseEditLink(newTopicId));
            statusToUser.add(new StatusMessage(statusMessage, StatusMessageColor.SUCCESS));
            isError = false;

        } catch (EntityAlreadyExistsException e) {
            setStatusForException(e, Const.StatusMessages.COURSE_EXISTS);
        } catch (InvalidParametersException e) {
            setStatusForException(e);
        }
    }


    
    
}
