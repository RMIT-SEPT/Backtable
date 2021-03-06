package teammates.logic.core;

import java.util.ArrayList;
import java.util.List;

import teammates.common.datatransfer.attributes.StudentAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityAlreadyExistsException;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.storage.api.TopicsDb;
import teammates.storage.entity.Reply;

public class TopicsLogic {

  private static TopicsLogic instance = new TopicsLogic();

  /** Explanation: This class depends on TopicsDb class but no other *Db classes.
   * That is because reading/writing entities from/to the datastore is the
   * responsibility of the matching *Logic class.
   * However, this class can talk to other *Logic classes. That is because
   * the logic related to one entity type can involve the logic related to
   * other entity types.
   */

  private static final TopicsDb topicsDb = new TopicsDb();
  private static final StudentsLogic studentsLogic = StudentsLogic.inst();

  private TopicsLogic() {
      // prevent initialization
  }

  /**
   * Returns instance of topics database
   * @return
   */
  public static TopicsDb getTopicsDb() {
    return topicsDb;
  }


    /**
     * This function is used to validate the parameters before initiate it to avoid errors.
     * @param name the topic name
     * @param desc the description of the topic
     * @return TopicAttribute instances
     *
     */

  public TopicAttributes validateAndCreateTopicAttributes(String topicID, String creator, String name, String desc, ArrayList<Reply> replies, Integer count,Integer viewcounter) throws InvalidParametersException{
      Assumption.assertNotNull("Non-null value expected", name);
      return TopicAttributes.builder(topicID, creator, name, desc, replies, count,viewcounter).build();
  }

    /**
     * After valid the parameters by validateAndCreateTopicAttributes()
     * which will return an instance of TopicAttribute, it will store that object into the database
     * via createEntity() function.
     *
     */
  public void createTopic(String topicID, String creator, String name, String desc, ArrayList<Reply> replies, Integer count,Integer viewcounter)
      throws InvalidParametersException, EntityAlreadyExistsException {

        System.out.println(name);
        TopicAttributes topicToAdd = validateAndCreateTopicAttributes(topicID, creator, name,desc, replies, count,viewcounter);
        topicsDb.createEntity(topicToAdd);       
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

    /**
     * Get Topic from database
     * @param topicId
     * @return
     */
    public TopicAttributes getTopic(String topicId) {
        return topicsDb.getTopic(topicId);
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
    
    /**
     * returns instance of TopicsLogic
     * @return
     */
    public static TopicsLogic inst() {
      return instance;
    }
    
    /**
     * Creates topic object in database
     * @param topicID
     * @param creator
     * @param topicName
     * @param topicDesc
     * @param replies
     * @throws InvalidParametersException
     * @throws EntityAlreadyExistsException
     */
    public void createTopicForDiscussionBoard(String topicID, String creator, String topicName, String topicDesc, ArrayList<Reply> replies)
    throws InvalidParametersException, EntityAlreadyExistsException {
        
        createTopic(topicID, creator, topicName, topicDesc, replies, 0,0);
    }

    /**
     * 
     * @param topic
     * @throws InvalidParametersException
     * @throws EntityDoesNotExistException
     */
    public void updateTopic(TopicAttributes topic) throws InvalidParametersException, EntityDoesNotExistException {
        topicsDb.saveEntity(topic.toEntity());
    }
}
