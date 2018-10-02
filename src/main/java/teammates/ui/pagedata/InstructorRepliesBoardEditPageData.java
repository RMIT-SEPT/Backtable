package teammates.ui.pagedata;

import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;

public class InstructorRepliesBoardEditPageData extends PageData {
    private TopicAttributes topic;
    private RepliesAttributes reply;

    public InstructorRepliesBoardEditPageData(AccountAttributes account, String sessionToken) {
      super(account, sessionToken);
      
    }
    
    public void init(TopicAttributes topic, RepliesAttributes reply)
    {
        this.topic = topic;
        this.reply = reply;
    }

    public TopicAttributes getTopic()
    {
        return topic;
    }
    public RepliesAttributes getReply()
    {
        return reply;
    }
    public String getDiscussionBoardDetailsLink()
    {
        return getInstructorDiscussionBoardDetailsLink(topic.getName(), topic.getId());
    }
}
