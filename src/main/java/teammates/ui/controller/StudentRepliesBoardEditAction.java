package teammates.ui.controller;

import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.StudentRepliesBoardEditPageData;
import teammates.ui.pagedata.StudentRepliesBoardPageData;

/**
 * Action: showing the reply edit for student.
 */
public class StudentRepliesBoardEditAction extends Action {

    /*
     * Variable declarations
     */
    private StudentRepliesBoardEditPageData data;
    private TopicAttributes topic;
    private RepliesAttributes reply;

    @Override
    protected ActionResult execute() {
        //get url request parameters and assert not null
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        String replyId = getRequestParamValue(Const.ParamsNames.REPLY_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.REPLY_ID,  replyId);

        //set student profile and set as current user
        account.studentProfile = logic.getStudentProfile(account.googleId);

        //retrieve relevant topic from database
        topic = logic.getTopic(topicId);
        //retrieve relevant reply from topic
        reply = getReplyWithId(topic.getReplies(), Integer.parseInt(replyId));
        //set data with values
        data = new StudentRepliesBoardEditPageData(account, sessionToken, topic, reply);

        return createShowPageResult(Const.ViewURIs.STUDENT_REPLIES_EDIT_PAGE, data);
    }

}
