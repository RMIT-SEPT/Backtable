package teammates.logic.core;

import java.util.ArrayList;
import java.util.List;

import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.InstructorAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.StudentAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityAlreadyExistsException;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Logger;
import teammates.storage.api.TopicsDb;
import teammates.storage.entity.Reply;

public class TopicsLogic {
  private static final Logger log = Logger.getLogger();

  private static TopicsLogic instance = new TopicsLogic();

  /** Explanation: This class depends on TopicsDb class but no other *Db classes.
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


    /**
     * This function is used to validate the parameters before initiate it to avoid errors.
     * @param name the topic name
     * @param desc the description of the topic
     * @return TopicAttribute instances
     *
     */

  public TopicAttributes validateAndCreateTopicAttributes(String topicID, String name, String desc, ArrayList<Reply> replies) throws InvalidParametersException{
      Assumption.assertNotNull("Non-null value expected", name);
      return TopicAttributes.builder(topicID, name,desc, replies).build();
  }

    /**
     * After valid the parameters by validateAndCreateTopicAttributes()
     * which will return an instance of TopicAttribute, it will store that object into the database
     * via createEntity() function.
     *
     */
  public void createTopic(String topicID, String name, String desc, ArrayList<Reply> replies)
      throws InvalidParametersException, EntityAlreadyExistsException {

        System.out.println(name);
        TopicAttributes topicToAdd = validateAndCreateTopicAttributes(topicID, name,desc, replies); 
        
        
        topicToAdd.addReply(new RepliesAttributes("This is the description of test reply", "Luke Sewart"));
        topicToAdd.addReply(new RepliesAttributes("This is the description of test reply2", "Luke Sewart2"));
        
        
        List<RepliesAttributes> test = topicToAdd.getReplies();
        topicsDb.createEntity(topicToAdd);
        TopicAttributes topicTest = topicsDb.getTopic(topicToAdd.getId());
        List<RepliesAttributes> test2 = topicTest.getReplies();
        for(RepliesAttributes reply1 : test2)
        {
          System.out.println("post storage:");
          System.out.print(reply1.getDesc());
        }
        topicTest.addReply(new RepliesAttributes("New description of reply 3", "Luke Sewart"));
        topicsDb.saveEntity(topicTest.toEntity());
        
        
    System.out.println("Topic entity has been created...");
  }

    /**
     * Return a list of all Topic stored in the database
     *
     */
    public List<TopicAttributes> getAllTopic() {
        List<TopicAttributes> alltopics = topicsDb.getAllTopics();
        return alltopics;
    }

    /**
     * Remove the topic with this method to make sure there is no conflict in future
     * All objects related to this topic will be cleaned.
     *
     */

    public void deleteTopicCascade(String topicName) {
        topicsDb.deleteTopic(topicName);
    }

    // Get topic for testing
    public TopicAttributes getTopic(String topicName) {
        return topicsDb.getTopic(topicName);
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
              topicIdList.remove(ca.getName());
          }
          log.severe("Topic(s) was deleted but the instructor still exists: " + System.lineSeparator()
                  + topicIdList.toString());
        }

        return topicList;
    }

  
  
  
    public static TopicsLogic inst() {
      return instance;
  }
  
  
  
  
    public void createTopicForDiscussionBoard(String topicID, String topicName, String topicDesc, ArrayList<Reply> replies)
          throws InvalidParametersException, EntityAlreadyExistsException {


    createTopic(topicID, topicName, topicDesc, replies);

    /* Create the initial instructor for the course */

    //AccountAttributes account = AccountAttributes.builder().build();

    }


}
