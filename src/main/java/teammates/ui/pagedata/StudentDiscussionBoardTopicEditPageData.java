package teammates.ui.pagedata;

import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;

public class StudentDiscussionBoardTopicEditPageData extends PageData {
    private TopicAttributes topic;

    public StudentDiscussionBoardTopicEditPageData(AccountAttributes account, String sessionToken, TopicAttributes topic) {
      super(account, sessionToken);
      this.topic = topic;
    }

    public TopicAttributes getTopic() {
      return topic;
    }
}
