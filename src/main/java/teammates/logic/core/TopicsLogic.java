package teammates.logic.core;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityAlreadyExistsException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Logger;
import teammates.storage.api.CoursesDb;
import teammates.storage.api.TopicsDb;

public class TopicsLogic {
  private static final Logger log = Logger.getLogger();

  private static TopicsLogic instance = new TopicsLogic();

  /* Explanation: This class depends on CoursesDb class but no other *Db classes.
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

  public void createTopic(String id, String desc, String studentName) 
      throws InvalidParametersException, EntityAlreadyExistsException
  {
    TopicAttributes topicToAdd = new TopicAttributes(id, desc, studentName);
    topicsDb.createEntity(topicToAdd);
    System.out.println("Topic entity has been created...");
  }
  
  public static TopicsLogic inst() {
      return instance;
  }

}
