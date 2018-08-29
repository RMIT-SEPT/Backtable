package teammates.logic.core;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import teammates.common.datatransfer.attributes.InstructorAttributes;
import teammates.common.datatransfer.attributes.StudentAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityAlreadyExistsException;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Logger;
import teammates.storage.api.TopicsDb;

public class TopicsLogic {
  private static final Logger log = Logger.getLogger();

  private static TopicsLogic instance = new TopicsLogic();

  /* Explanation: This class depends on TopicsDb class but no other *Db classes.
   * That is because reading/writing entities from/to the datastore is the
   * responsibility of the matching *Logic class.
   * However, this class can talk to other *Logic classes. That is because
   * the logic related to one entity type can involve the logic related to
   * other entity types.
   */

  private static final TopicsDb topicsDb = new TopicsDb();
  private static final AccountsLogic accountsLogic = AccountsLogic.inst();
  private static final FeedbackSessionsLogic feedbackSessionsLogic = FeedbackSessionsLogic.inst();
  private static final InstructorsLogic instructorsLogic = InstructorsLogic.inst();
  private static final StudentsLogic studentsLogic = StudentsLogic.inst();

  private TopicsLogic() {
      // prevent initialization
  }

  public void createTopic(String id, String desc, ZoneId zone) 
      throws InvalidParametersException, EntityAlreadyExistsException
  {
    TopicAttributes topicToAdd = new TopicAttributes(id, desc, zone);
    topicsDb.createEntity(topicToAdd);
    System.out.println("Topic entity has been created...");
  }
  
  
  /**
   * Returns a list of {@link TopicAttributes} for all topics a given student is enrolled in.
   *
   * @param googleId The Google ID of the student
   */
  public List<TopicAttributes> getTopicsForStudentAccount(String googleId) throws EntityDoesNotExistException {
      List<StudentAttributes> studentDataList = studentsLogic.getStudentsForGoogleId(googleId);

      if (studentDataList.isEmpty()) {
          throw new EntityDoesNotExistException("Student with Google ID " + googleId + " does not exist");
      }

      List<String> topicIds = new ArrayList<>();
      for (StudentAttributes s : studentDataList) {
          topicIds.add(s.topic);
      }
      return topicsDb.getTopics(topicIds);
  }

  
  
  
  
  public List<TopicAttributes> getTopicsForInstructor(String googleId) {
      return getTopicsForInstructor(googleId, false);
  }

  
  
  
  public List<TopicAttributes> getTopicsForInstructor(String googleId, boolean omitArchived) {
      List<InstructorAttributes> instructorList = instructorsLogic.getInstructorsForGoogleId(googleId, omitArchived);
      return getTopicsForInstructor(instructorList);
  }

 
  
  
  
  
  public List<TopicAttributes> getTopicsForInstructor(List<InstructorAttributes> instructorList) {
      Assumption.assertNotNull("Supplied parameter was null", instructorList);
      List<String> topicIdList = new ArrayList<>();

      for (InstructorAttributes instructor : instructorList) {
          topicIdList.add(instructor.topicId);
      }

      List<TopicAttributes> topicList = topicsDb.getTopics(topicIdList);

      // Check that all topicIds queried returned a topic.
      if (topicIdList.size() > topicList.size()) {
          for (TopicAttributes ca : topicList) {
              topicIdList.remove(ca.getId());
          }
          log.severe("Topic(s) was deleted but the instructor still exists: " + System.lineSeparator()
                  + topicIdList.toString());
      }

      return topicList;
  }

  
  
  
  public static TopicsLogic inst() {
      return instance;
  }

}
