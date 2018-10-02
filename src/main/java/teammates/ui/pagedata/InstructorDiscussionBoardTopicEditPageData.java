package teammates.ui.pagedata;

import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;

public class InstructorDiscussionBoardTopicEditPageData extends PageData {
    private TopicAttributes topic;
    private Integer count;

    public InstructorDiscussionBoardTopicEditPageData(AccountAttributes account, String sessionToken, TopicAttributes topic, Integer count) {
      super(account, sessionToken);
      this.topic = topic;
      this.count = count;
    }

    public TopicAttributes getTopic() {
      return topic;
    }
}
