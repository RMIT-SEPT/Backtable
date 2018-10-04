package teammates.ui.controller;

import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.StudentRepliesBoardEditPageData;
import teammates.ui.pagedata.StudentRepliesBoardPageData;

/**
 * Action: showing the profile page for a student in a course.
 */
public class StudentRepliesBoardEditAction extends Action {

    private StudentRepliesBoardEditPageData data;
    private TopicAttributes topic;
    private RepliesAttributes reply;
    private static final Logger log = Logger.getLogger();

    @Override
    protected ActionResult execute() {
        //getting topic name at the moment, whereas would be better to use topic id
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);

        String replyId = getRequestParamValue(Const.ParamsNames.REPLY_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.REPLY_ID,  replyId);

        account.studentProfile = logic.getStudentProfile(account.googleId);

        topic = logic.getTopic(topicId);
        reply = getReplyWithId(topic.getReplies(), Integer.parseInt(replyId));
        data = new StudentRepliesBoardEditPageData(account, sessionToken, topic, reply);

        return createShowPageResult(Const.ViewURIs.STUDENT_REPLIES_EDIT_PAGE, data);
    }

}
