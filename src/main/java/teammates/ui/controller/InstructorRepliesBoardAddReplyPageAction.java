
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
import teammates.ui.pagedata.InstructorRepliesBoardPageData;

/**
 * Action: adding a reply to a topic when instructor is active user.
 */

public class InstructorRepliesBoardAddReplyPageAction extends Action {

    InstructorRepliesBoardPageData data;
    TopicAttributes topic;
    String dateTime;


    @Override
    protected ActionResult execute() {
        //get parameters from url and assert not null
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        String replyDesc = getRequestParamValue(Const.ParamsNames.REPLY_DESC);
        Assumption.assertPostParamNotNull(Const.ParamsNames.REPLY_DESC, replyDesc);
        
        //retrieve relevant topic from database
        topic = logic.getTopic(topicId);
        
        //create a string with date and time for displaying with reply
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy EEE MMM dd hh:mm");
        dateTime = formatter.format(today);

        //instantiate a reply with relevant parameters
        RepliesAttributes newReply = new RepliesAttributes(replyDesc, account.getName(), topic.getCount(), dateTime,0,0);
        
        //add reply object to the topic
        topic.addReply(newReply);
        
        //try to update the topic and catch exceptions
        try {
            logic.updateTopic(topic);
        } catch (InvalidParametersException e) {
            e.printStackTrace();
        } catch (EntityDoesNotExistException e) {
            e.printStackTrace();
        }
        
        //initialise data object for replies board
        data = new InstructorRepliesBoardPageData(account, sessionToken);
        
        //set data for page result
        data.init(topic);
        
        return createShowPageResult(Const.ViewURIs.INSTRUCTOR_REPLIES_BOARD_PAGE, data); 
    }

}

