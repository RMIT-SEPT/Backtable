package teammates.ui.controller;

import java.util.List;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.InstructorDiscussionBoardPageData;
import teammates.ui.pagedata.StudentDiscussionBoardPageData;

/**
 * Action: showing the profile page for a student in a course.
 */
public class InstructorDiscussionBoardPageAction extends Action {

    private static final Logger log = Logger.getLogger();
    InstructorDiscussionBoardPageData data;
    
    @Override
    public ActionResult execute() {
        
        data = new InstructorDiscussionBoardPageData(account, sessionToken);
        // use Logic to retrieve all topics data for front-end using
        List<TopicAttributes> allTopics = logic.getAllTopics();

        data.init(allTopics);
        return createShowPageResult(Const.ViewURIs.INSTRUCTOR_DISCUSSION_BOARD_PAGE, data);
        
        
        
    }

}
