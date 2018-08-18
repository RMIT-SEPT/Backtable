package teammates.ui.pagedata;

import teammates.common.util.Const;

import java.util.ArrayList;
import java.util.List;

import teammates.common.datatransfer.CourseDetailsBundle;
import teammates.common.datatransfer.TeamDetailsBundle;
import teammates.common.datatransfer.TopicDetailsBundle;
import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.InstructorAttributes;
import teammates.common.datatransfer.attributes.StudentAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;

public class StudentDiscussionBoardPageData extends PageData {
  public List<TopicDetailsBundle> topics;
  public StudentDiscussionBoardPageData(AccountAttributes account, String sessionToken) {
    super(account, sessionToken);
  }
  public String theSentence;
  
  public void init(List<TopicDetailsBundle> topics, StudentAttributes student) {
      this.student = student;
      this.topics = topics;
      this.theSentence = "this is a fucking sentence";
      //studentCourseDetailsPanel = createStudentCourseDetailsPanel(
      //               courseDetails, instructors, student, team);
}
  public void createFalseData() {
    this.topics = new ArrayList<TopicDetailsBundle>();
    this.topics.add(new TopicDetailsBundle(new TopicAttributes("this is the id", "this is a test topic desc", "Luke Sewart")));
    this.topics.add(new TopicDetailsBundle(new TopicAttributes("this is the id2", "this is a test topic desc2", "Luke Sewart2")));
    System.out.println("This is printing");
  }
  
  public List<TopicDetailsBundle> getTopics(){
    return this.topics;
  }
  
  public String getTheSentence() {
    return theSentence;
  }
  

}
