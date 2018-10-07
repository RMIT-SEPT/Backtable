
package teammates.ui.pagedata;

import java.util.List;
import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
/**
 * Page data for student replies board
 *
 */
public class StudentRepliesBoardAddReplyPage extends PageData {

    public TopicAttributes topic;

    public StudentRepliesBoardAddReplyPage(AccountAttributes account, String sessionToken) {
        super(account, sessionToken);
    }

    public void init(TopicAttributes topic) {
        this.topic = topic;
    }

    public List<RepliesAttributes> getReplies() {
        return topic.replies;
    }

    public String getDesc() {
        return topic.getDesc();
    }

    public String getName() {
        return topic.getName();
    }


}
