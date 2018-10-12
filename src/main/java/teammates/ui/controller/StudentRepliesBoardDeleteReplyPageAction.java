
package teammates.ui.controller;

import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.logic.core.TopicsLogic;
import teammates.ui.pagedata.StudentRepliesBoardPageData;

/**
 * Action: showing the replies page for student
 */

public class StudentRepliesBoardDeleteReplyPageAction extends Action {

    /*
     * Variable declarations
     */
    StudentRepliesBoardPageData data;
    TopicAttributes topic;
    RepliesAttributes replyToDelete;
    String dateTime;

    @Override
    protected ActionResult execute() {
        //get url request parameters and assert not null
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        String replyId = getRequestParamValue(Const.ParamsNames.REPLY_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.REPLY_ID, replyId);
        
        //retrieve relevant topic from the database
        topic = logic.getTopic(topicId);
        
        //for each reply in topic, if the id is equal to the id of topic to be deleted set it as replyToDelete
        for(RepliesAttributes reply : topic.getReplies())
        {
            if(reply.getId() == Integer.valueOf(replyId))
            {
               replyToDelete = reply;
            }
        }
        //remove reply from topic
        topic.removeReply(replyToDelete);
        
        //save topic over the old topic
        TopicsLogic.getTopicsDb().saveEntity(topic.toEntity());
        
        //set data object
        data = new StudentRepliesBoardPageData(account, sessionToken);
        
        //set topic values into data
        data.init(topic);
        
        return createShowPageResult(Const.ViewURIs.STUDENT_REPLIES_BOARD_PAGE, data);
    }

}

