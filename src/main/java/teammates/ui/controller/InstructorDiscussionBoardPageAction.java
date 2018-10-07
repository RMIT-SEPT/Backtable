package teammates.ui.controller;

import java.util.List;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.InstructorDiscussionBoardPageData;
import teammates.ui.pagedata.StudentDiscussionBoardPageData;

/**
 * Action: Showing the discussion board for a logged in instructor.
 */
public class InstructorDiscussionBoardPageAction extends Action {

    //Declare data object
    InstructorDiscussionBoardPageData data;
    
    //called when accessing the page, accesses and pushes data to the instructor discussion board page data
    @Override
    public ActionResult execute() {
        
        //instantiate data as an InstructorDiscussionBoardPageData object
        data = new InstructorDiscussionBoardPageData(account, sessionToken);
        
        //access all topics in database
        List<TopicAttributes> allTopics = logic.getAllTopics();

        //update the data with the topics retrieved from database
        data.init(allTopics);
        
        //return the page with data
        return createShowPageResult(Const.ViewURIs.INSTRUCTOR_DISCUSSION_BOARD_PAGE, data);
        
        
        
    }

}
