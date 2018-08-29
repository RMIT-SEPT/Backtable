package teammates.ui.pagedata;

import teammates.common.util.Const;

import java.util.ArrayList;
import java.util.List;
import teammates.common.datatransfer.TopicDetailsBundle;
import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.StudentAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.CourseAttributes;
import teammates.common.datatransfer.attributes.InstructorAttributes;
import teammates.common.util.Const;
import teammates.common.util.SanitizationHelper;
import teammates.ui.template.ActiveCoursesTable;
import teammates.ui.template.ActiveCoursesTableRow;
import teammates.ui.template.ActiveTopicsTable;
import teammates.ui.template.ActiveTopicsTableRow;
import teammates.ui.template.ArchivedCoursesTable;
import teammates.ui.template.ArchivedCoursesTableRow;
import teammates.ui.template.ElementTag;


/**
 * This is the PageData object for the 'Discussion Board Topics' page.
 */  


public class StudentDiscussionBoardPageData extends PageData {
  
  //***********************ATTRIBUTES*************************************//  
    
  public List<TopicDetailsBundle> topics;
  private boolean isUsingAjax;
  private ActiveTopicsTable activeTopics;
  private String topicIdToShow;
  private String topicNameToShow;
  
  
  
  //***********************CONSTRUCTOR*************************************//  

  
  public StudentDiscussionBoardPageData(AccountAttributes account, String sessionToken) {
    super(account, sessionToken);
  }
  
  
  public void init(List<TopicDetailsBundle> topics, StudentAttributes student) {
      this.student = student;
      this.topics = topics;
      
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
  
      public void init(List<TopicAttributes> activeTopicsParam) {
          init(activeTopicsParam, "", "");
      }

      public void init(List<TopicAttributes> activeTopicsParam, String topicIdToShowParam, String topicNameToShowParam) {
          this.activeTopics = convertToActiveTopicsTable(activeTopicsParam);
          this.topicIdToShow = topicIdToShowParam;
          this.topicNameToShow = topicNameToShowParam;
      }

      public void setUsingAjax(boolean isUsingAjax) {
          this.isUsingAjax = isUsingAjax;
      }

      public boolean isUsingAjax() {
          return this.isUsingAjax;
      }

      public String getTopicIdToShow() {
          return topicIdToShow;
      }

      public String getTopicNameToShow() {
          return topicNameToShow;
      }

      public ActiveTopicsTable getActiveTopics() {
          return activeTopics;
      }


      private ActiveTopicsTable convertToActiveTopicsTable(List<TopicAttributes> topics) {
          ActiveTopicsTable activeTopics = new ActiveTopicsTable();

          int idx = -1;

          for (TopicAttributes topic : topics) {
              idx++;

              List<ElementTag> actionsParam = new ArrayList<>();

              /*Boolean hasModifyPermission = instructorsForCourses.get(course.getId()).isAllowedForPrivilege(
                                                     Const.ParamsNames.INSTRUCTOR_PERMISSION_MODIFY_STUDENT);*/
              /*ElementTag addButton = createButton("Enroll", "btn btn-default btn-xs t_course_enroll" + idx, "",
                                                     getInstructorCourseEnrollLink(topic.getId()),
                                                     Const.Tooltips.COURSE_ENROLL, !hasModifyPermission);
*/
              ElementTag viewButton = createButton("View", "btn btn-default btn-xs t_course_view" + idx, "",
                                                   getDiscussionBoardDetailsLink(topic.getId()),
                                                   Const.Tooltips.TOPIC_DETAILS, false);

              /*ElementTag editButton = createButton("Edit", "btn btn-default btn-xs t_course_edit" + idx, "",
                                                   getInstructorCourseEditLink(topic.getId()),
                                                   Const.Tooltips.COURSE_EDIT, false);

              ElementTag archiveButton = createButton("Archive", "btn btn-default btn-xs t_course_archive" + idx, "",
                                                      getInstructorCourseArchiveLink(topic.getId(), true, false),
                                                      Const.Tooltips.COURSE_ARCHIVE, false);

              String deleteLink = getInstructorCourseDeleteLink(topic.getId(), false);
              Boolean hasDeletePermission = instructorsForCourses.get(topic.getId()).isAllowedForPrivilege(
                                                     Const.ParamsNames.INSTRUCTOR_PERMISSION_MODIFY_COURSE);
              ElementTag deleteButton = createButton("Delete", "btn btn-default btn-xs course-delete-link "
                                                     + "t_course_delete" + idx, "", deleteLink, Const.Tooltips.COURSE_DELETE,
                                                     !hasDeletePermission);
              deleteButton.setAttribute("data-course-id", course.getId());*/

              //actionsParam.add(enrollButton);
              actionsParam.add(viewButton);
              //actionsParam.add(editButton);
              //actionsParam.add(archiveButton);
              //actionsParam.add(deleteButton);

              ActiveTopicsTableRow row = new ActiveTopicsTableRow(SanitizationHelper.sanitizeForHtml(topic.getId()),
                                                                    SanitizationHelper.sanitizeForHtml(topic.getName()),
                                                                    topic.getCreatedAtDateString(),
                                                                    topic.getCreatedAtDateStamp(),
                                                                    topic.getCreatedAtFullDateTimeString(),
                                                                    this.getDiscussionBoardDetailsLink(topic.getId()),
                                                                    actionsParam);
              activeTopics.getRows().add(row);
          }

          return activeTopics;
      }

      private ElementTag createButton(String content, String buttonClass, String id, String href, String title,
                                      boolean isDisabled) {
          ElementTag button = new ElementTag(content);

          button.setAttribute("class", buttonClass);

          if (id != null && !id.isEmpty()) {
              button.setAttribute("id", id);
          }

          if (href != null && !href.isEmpty()) {
              button.setAttribute("href", href);
          }

          if (title != null && !title.isEmpty()) {
              button.setAttribute("title", title);
              button.setAttribute("data-toggle", "tooltip");
              button.setAttribute("data-placement", "top");
          }

          if (isDisabled) {
              button.setAttribute("disabled", null);
          }
          return button;
      }
  }

  
  
  
  
  
  
  
  
  
  
  
  
  

