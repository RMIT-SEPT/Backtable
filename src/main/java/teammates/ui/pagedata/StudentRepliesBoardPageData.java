package teammates.ui.pagedata;

import teammates.common.util.Const;
import teammates.logic.api.Logic;

import java.util.ArrayList;
import java.util.List;

import teammates.common.datatransfer.CourseDetailsBundle;
import teammates.common.datatransfer.TeamDetailsBundle;
import teammates.common.datatransfer.TopicDetailsBundle;
import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.InstructorAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.StudentAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;

public class StudentRepliesBoardPageData extends PageData {
   
  public TopicAttributes topic;
  
  public StudentRepliesBoardPageData(AccountAttributes account, String sessionToken) {
    super(account, sessionToken);
  }
  
  public void init(TopicAttributes topic) {
      this.topic = topic;
}
  
  public List<RepliesAttributes> getReplies() {
      return topic.replies;
  }
  
  public String getDesc() {
      return topic.desc;
  }
  
  public String getName() {
      return topic.name;
  }
  /*
  public void createFalseData() {
    this.replies = new ArrayList<RepliesAttributes>();
    this.replies.add(new RepliesAttributes("this is the desc1 for reply", "Luke Sewart1"));
    this.replies.add(new RepliesAttributes("this is the desc2 for reply", "Luke Sewart2"));
    System.out.println("This is printing");
  }
  
  public TopicDetailsBundle getTopicDetails(){
    return this.topic;
  }
  
  public List<RepliesAttributes> getReplies(){
    return this.replies;
  }
 
  */

}
