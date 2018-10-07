package teammates.ui.controller;

import java.util.List;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.StudentDiscussionBoardPageData;

/**
 * Action: Retrieve data from the database to display all the topics.
 */
public class StudentDiscussionBoardPageAction extends Action { 
    private static final Logger log = Logger.getLogger();
    StudentDiscussionBoardPageData data;
    
    @Override
    public ActionResult execute() {
        //get profile of logged in student
        account.studentProfile = logic.getStudentProfile(account.googleId);

        data = new StudentDiscussionBoardPageData(account, sessionToken);
        
        // use Logic to retrieve all topics data for front-end using
        List<TopicAttributes> allTopics = logic.getAllTopics();

        //set topics in page data
        data.init(allTopics);
        
        return createShowPageResult(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_PAGE, data);
  
    }
}
