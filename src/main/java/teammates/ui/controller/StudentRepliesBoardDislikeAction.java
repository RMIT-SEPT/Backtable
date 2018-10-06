package teammates.ui.controller;

import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.StudentRepliesBoardEditPageData;
import teammates.ui.pagedata.StudentRepliesBoardPageData;

import java.util.ArrayList;

/**
 * Action: showing the replies board after dislike.
 */
public class StudentRepliesBoardDislikeAction extends Action {

    /*
     * Variable declarations
     */
    
    StudentRepliesBoardPageData data;
    TopicAttributes topic;

    @Override
    protected ActionResult execute() {
        //get url request parameters and assert not null
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        String replyId = getRequestParamValue(Const.ParamsNames.REPLY_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.REPLY_ID, replyId);

        //set student profile as current suer
        account.studentProfile = logic.getStudentProfile(account.googleId);
        //set data object
        data = new StudentRepliesBoardPageData(account, sessionToken);
        //retrieve relevant topic from database
        topic = logic.getTopic(topicId);
        //retrieve replies from topic
        ArrayList<RepliesAttributes> replies = topic.getReplies();
        //retrieve relevant reply from topic replies
        RepliesAttributes tmpReply = getReplyWithId(replies, Integer.parseInt(replyId));
        //increment dislikes in reply
        tmpReply.setDislike(tmpReply.getDislike()+1);
        //set replies as update replies
        topic.setReplies(replies);
        //try update topic and catch exceptions
        try {
            logic.updateTopic((topic));
        } catch (InvalidParametersException e) {
            e.printStackTrace();
        } catch (EntityDoesNotExistException e) {
            e.printStackTrace();
        }
        //set data with topic
        data.init(topic);
        return createShowPageResult(Const.ViewURIs.STUDENT_REPLIES_BOARD_PAGE, data);
    }

}
