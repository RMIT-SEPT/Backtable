/**
 * 
 */
package teammates.ui.pagedata;

import java.util.List;

import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.CourseAttributes;
import teammates.common.datatransfer.attributes.InstructorAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.SanitizationHelper;

/**
 * @author Christina
 *
 */
public class StudentDiscussionBoardEditPageData extends PageData {
public TopicAttributes topic;
    
    
    public StudentDiscussionBoardEditPageData(AccountAttributes account, String sessionToken) {

        super(account, sessionToken);
      //  this.topic = topic;
        this.topic = TopicAttributes
                .builder(topic.getId(), topic.getName(), topic.getDesc()).build();
    
}
    
}
