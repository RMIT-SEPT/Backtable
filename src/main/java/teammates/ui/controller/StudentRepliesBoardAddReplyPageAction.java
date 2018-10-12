
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
import teammates.ui.pagedata.StudentRepliesBoardAddReplyPage;
import teammates.ui.pagedata.StudentRepliesBoardPageData;

import java.util.UUID;

/**
 * Action: showing the add reply page for student.
 */
public class StudentRepliesBoardAddReplyPageAction extends Action {

    /*
     * Variable declarations
     */
    StudentRepliesBoardPageData data;
    TopicAttributes topic;
    String dateTime;


    @Override
    protected ActionResult execute() {
        //get url request parameters and assert not null
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        String replyDesc = getRequestParamValue(Const.ParamsNames.REPLY_DESC);
        Assumption.assertPostParamNotNull(Const.ParamsNames.REPLY_DESC, replyDesc);
        
        //retreive relevant topic from database
        topic = logic.getTopic(topicId);
        
        //get string with date and time for displaying on reply
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy EEE MMM dd hh:mm");
        dateTime = formatter.format(today);
        
        //instantiate new reply with values
        RepliesAttributes newReply = new RepliesAttributes(replyDesc, account.getName(), topic.getCount(), dateTime,0,0);
        
        //add reply to the topic
        topic.addReply(newReply);
        
        //update topic in the database
        try {
            logic.updateTopic(topic);
        } catch (InvalidParametersException e) {
            e.printStackTrace();
        } catch (EntityDoesNotExistException e) {
            e.printStackTrace();
        }
        
        //instantiate new data object for replies board
        data = new StudentRepliesBoardPageData(account, sessionToken);
        
        //set data with topic values
        data.init(topic);
        return createShowPageResult(Const.ViewURIs.STUDENT_REPLIES_BOARD_PAGE, data);
    }

}

