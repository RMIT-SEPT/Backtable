package teammates.ui.controller;

import java.util.ArrayList;
import java.util.List;

import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.StatusMessage;
import teammates.common.util.StatusMessageColor;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.ui.pagedata.InstructorRepliesBoardPageData;
import teammates.ui.pagedata.StudentDiscussionBoardPageData;
import teammates.ui.pagedata.StudentRepliesBoardPageData;
import teammates.logic.core.TopicsLogic;


public class InstructorRepliesBoardEditSaveAction extends Action {

    @Override
    public ActionResult execute() {

        //receive topic id and assert that it is not null
        
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        
        //receive edited reply description and assert that it is not null
        String editedReplyDesc = getRequestParamValue(Const.ParamsNames.REPLY_DESC);
        Assumption.assertPostParamNotNull(Const.ParamsNames.REPLY_DESC, editedReplyDesc);
        
        //receive the id of the reply to be edited and assert not null
        String replyId = getRequestParamValue(Const.ParamsNames.REPLY_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.REPLY_ID, replyId);
        
        //return topic object
        TopicAttributes topic = logic.getTopic(topicId);
        
        //return the replies array of the associated topic
        ArrayList<RepliesAttributes> replies = topic.getReplies();

        //print the value of new reply description
        System.out.println(topicId + ", " + editedReplyDesc);
        
        //return the reply to being edited and change description to edited
        getReplyWithId(replies, Integer.parseInt(replyId)).setDesc(editedReplyDesc);
        
        //set replies of topic object to new replies
        topic.setReplies(replies);
        
      
        TopicsLogic.getTopicsDb().saveEntity(topic.toEntity());

        InstructorRepliesBoardPageData data = new InstructorRepliesBoardPageData(account, sessionToken);

        data.init(topic);

        return createShowPageResult(Const.ViewURIs.INSTRUCTOR_REPLIES_BOARD_PAGE, data);
    }

    
}
