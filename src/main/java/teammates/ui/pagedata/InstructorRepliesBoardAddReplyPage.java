
package teammates.ui.pagedata;
/**
 * Page data for add reply page
 */
import java.util.List;
import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;

public class InstructorRepliesBoardAddReplyPage extends PageData {

    /*
     * Variable declarations
     */
    public TopicAttributes topic;

    //Constructor
    public InstructorRepliesBoardAddReplyPage(AccountAttributes account, String sessionToken) {
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
