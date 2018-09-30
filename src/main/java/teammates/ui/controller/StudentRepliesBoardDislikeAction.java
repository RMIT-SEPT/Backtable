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
 * Action: showing the profile page for a student in a course.
 */
public class StudentRepliesBoardDislikeAction extends Action {

    StudentRepliesBoardPageData data;
    TopicAttributes topic;
    private static final Logger log = Logger.getLogger();

    @Override
    protected ActionResult execute() {
        //getting topic name at the moment, whereas would be better to use topic id
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);


        //receive the id of the reply to be edited and assert not null
        String replyId = getRequestParamValue(Const.ParamsNames.REPLY_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.REPLY_ID, replyId);

        account.studentProfile = logic.getStudentProfile(account.googleId);
        data = new StudentRepliesBoardPageData(account, sessionToken);
        topic = logic.getTopic(topicId);
        ArrayList<RepliesAttributes> replies = topic.getReplies();
        RepliesAttributes tmpReply = getReplyWithId(replies, Integer.parseInt(replyId));
        tmpReply.setDislike(tmpReply.getDislike()+1);
        topic.setReplies(replies);
        try {
            logic.updateTopic((topic));
        } catch (InvalidParametersException e) {
            e.printStackTrace();
        } catch (EntityDoesNotExistException e) {
            e.printStackTrace();
        }

        data.init(topic);


        return createShowPageResult(Const.ViewURIs.STUDENT_REPLIES_BOARD_PAGE, data);
    }

}
