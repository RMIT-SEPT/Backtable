
package teammates.ui.controller;

import teammates.common.datatransfer.attributes.RepliesAttributes;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.logic.core.TopicsLogic;
import teammates.ui.pagedata.StudentRepliesBoardAddReplyPage;
import teammates.ui.pagedata.StudentRepliesBoardPageData;

import java.util.UUID;

/**
 * Action: showing the profile page for a student in a course.
 */
public class StudentRepliesBoardDeleteReplyPageAction extends Action {

    StudentRepliesBoardPageData data;
    TopicAttributes topic;
    RepliesAttributes replyToDelete;
    private static final Logger log = Logger.getLogger();
    String dateTime;


    @Override
    protected ActionResult execute() {
        //getting topic name at the moment, whereas would be better to use topic id
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        
        String replyId = getRequestParamValue(Const.ParamsNames.REPLY_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.REPLY_ID, replyId);
        
        topic = logic.getTopic(topicId);
        
        for(RepliesAttributes reply : topic.getReplies())
        {
            if(reply.getId() == Integer.valueOf(replyId))
            {
               replyToDelete = reply;
            }
        }
        topic.removeReply(replyToDelete);
        TopicsLogic.getTopicsDb().saveEntity(topic.toEntity());
        data = new StudentRepliesBoardPageData(account, sessionToken);
        data.init(topic);
        return createShowPageResult(Const.ViewURIs.STUDENT_REPLIES_BOARD_PAGE, data);
    }

}

