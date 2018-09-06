package teammates.ui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import teammates.common.datatransfer.TopicDetailsBundle;
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
        List<TopicAttributes> allTopics = logic.getAllTopics();

        List<TopicAttributes> activeTopics = new ArrayList<>();
        List<TopicAttributes> archivedTopics = new ArrayList<>();

        data.init(allTopics);

        //createTopic(newTopicName, newTopicDesc);
        
        //Map<String, StudentAttributes> studentTopics = new HashMap<>();
           // List<TopicAttributes> activeTopics = new ArrayList<>();
        //List<TopicAttributes> archivedTopics = new ArrayList<>();
        
        /*String topicIdToShowParam = "";
        String topicNameToShowParam = "";*/
        
        //data.init(activeTopics, topicIdToShowParam, topicNameToShowParam);

        
        return createShowPageResult(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_PAGE, data);
        
        
        
    }


}
