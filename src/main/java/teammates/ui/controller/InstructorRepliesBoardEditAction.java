package teammates.ui.controller;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.InstructorRepliesBoardEditPageData;


public class InstructorRepliesBoardEditAction extends Action {

    InstructorRepliesBoardEditPageData data;
    TopicAttributes topic;
    private static final Logger log = Logger.getLogger();

    @Override
    protected ActionResult execute() {
        //getting topic name at the moment, whereas would be better to use topic id
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        
        String replyId = getRequestParamValue(Const.ParamsNames.REPLY_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.REPLY_ID,  replyId);
        
        account.studentProfile = logic.getStudentProfile(account.googleId);
        
        
        data = new InstructorRepliesBoardEditPageData(account, sessionToken);
        
        topic = logic.getTopic(topicId);
        
        data.init(topic, getReplyWithId(topic.getReplies(), Integer.parseInt(replyId)));
        
        return createShowPageResult(Const.ViewURIs.INSTRUCTOR_REPLIES_EDIT_PAGE, data); 
    }

}
