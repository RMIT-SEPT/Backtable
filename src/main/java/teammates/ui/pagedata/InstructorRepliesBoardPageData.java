/**
 * 
 */
package teammates.ui.pagedata;

import java.util.List;

import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;


public class InstructorRepliesBoardPageData extends PageData {
    
    public TopicAttributes topic;
    
    public InstructorRepliesBoardPageData(AccountAttributes account, String sessionToken) {
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
