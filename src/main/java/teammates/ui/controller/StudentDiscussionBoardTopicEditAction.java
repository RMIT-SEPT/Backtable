
package teammates.ui.controller;

import java.util.ArrayList;
import java.util.List;

import teammates.common.datatransfer.attributes.CourseAttributes;
import teammates.common.datatransfer.attributes.FeedbackSessionAttributes;
import teammates.common.datatransfer.attributes.InstructorAttributes;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.ui.pagedata.InstructorCourseEditPageData;
import teammates.ui.pagedata.StudentDiscussionBoardEditPageData;

public class StudentDiscussionBoardTopicEditAction extends Action{


    @Override
    public ActionResult execute() throws EntityDoesNotExistException {

        String topicName = getRequestParamValue(Const.ParamsNames.TOPIC_NAME);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_NAME, topicName);
        String instructorEmail = getRequestParamValue(Const.ParamsNames.INSTRUCTOR_EMAIL);
        String index = getRequestParamValue(Const.ParamsNames.COURSE_EDIT_MAIN_INDEX);

        InstructorAttributes instructor = logic.getInstructorForGoogleId(topicName, account.googleId);
        //TopicAttributes topicToEdit = logic.getTopic(topicName);

        //gateKeeper.verifyAccessible(instructor, topicToEdit);

        /* Setup page data for 'Edit' page of a course for an instructor */
       /* List<InstructorAttributes> instructorList = new ArrayList<>();

        int instructorToShowIndex = -1; // -1 means showing all instructors

        if (instructorEmail == null) {
            instructorList = logic.getInstructorsForCourse(courseId);
        } else {
            instructorList.add(logic.getInstructorForEmail(courseId, instructorEmail));
            instructorToShowIndex = Integer.parseInt(index);
        }

        List<String> sectionNames = logic.getSectionNamesForCourse(courseId);
        List<String> feedbackNames = new ArrayList<>();

        List<FeedbackSessionAttributes> feedbacks = logic.getFeedbackSessionsForCourse(courseId);
        for (FeedbackSessionAttributes feedback : feedbacks) {
            feedbackNames.add(feedback.getFeedbackSessionName());
        }*/

       StudentDiscussionBoardEditPageData data = new   StudentDiscussionBoardEditPageData(account, sessionToken);


        return createShowPageResult(Const.ViewURIs.STUDENT_REPLIES_BOARD_PAGE, data);
    }
}
