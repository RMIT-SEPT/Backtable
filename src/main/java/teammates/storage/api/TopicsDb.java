package teammates.storage.api;

import static com.googlecode.objectify.ObjectifyService.ofy;
import java.time.DateTimeException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.LoadType;
import com.googlecode.objectify.cmd.QueryKeys;

import teammates.common.datatransfer.attributes.CourseAttributes;
import teammates.common.datatransfer.attributes.FeedbackQuestionAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.storage.entity.Course;
import teammates.storage.entity.FeedbackQuestion;
import teammates.storage.entity.Topic;

public class TopicsDb extends EntitiesDb<Topic, TopicAttributes> {

    /**
     * This function will help to access to the database which only take the instance of "Topic" class
     *
     */
  @Override
    protected LoadType<Topic> load() {
    return ofy().load().type(Topic.class);
    }

    public static final String ERROR_UPDATE_NON_EXISTENT_TOPIC = "Trying to update a Topic that doesn't exist: ";




    /**
    * Preconditions: <br>
    * * All parameters are non-null.
    * @return Null if not found.
    */
    
    //below method depreciated, based on idea of returning replies with partial keys of {topicId, replyId}
    //replyId could enumerate based on how many replies exist to remain easily trackable and mainly rely on topicId in order to retrieve
    //desired topic...
    
    /*
    public RepliesAttributes getReply(String topicId, String replyId) {
      Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, topicId);
      Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, replyId);
      return makeAttributesOrNull(getReplyEntity(topicId, replyId));
    }
*/
    /**
     * Return a topic based of the topicId
     * @param topicId Name of the topic
     */
    public TopicAttributes getTopic(String topicId) {
      Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, topicId);
      return makeAttributesOrNull(getTopicEntity(topicId));
    }

    /**
     * Return list of topics based of the list of topicIds
     * @param topicIds List of topics' name
     */

    public List<TopicAttributes> getTopics(List<String> topicIds) {
      Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, topicIds);

      return makeAttributes(getTopicEntities(topicIds));
    }
    /**
     * Unused method for now.
     */
      
    public void updateTopic(TopicAttributes topicToUpdate) throws InvalidParametersException,
                                                                   EntityDoesNotExistException {
      Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, topicToUpdate);

      topicToUpdate.sanitizeForSaving();

      if (!topicToUpdate.isValid()) {
          throw new InvalidParametersException(topicToUpdate.getInvalidityInfo());
      }
      Topic topicEntityToUpdate = getTopicEntity(topicToUpdate.getName());

      if (topicEntityToUpdate == null) {
          throw new EntityDoesNotExistException(ERROR_UPDATE_NON_EXISTENT_TOPIC);
      }
      saveEntity(topicEntityToUpdate, topicToUpdate);
    }

    /**
     * Return a Topic which retrieved from database
     * @param attributes a topic attribute  will be converted to Topic
     */
    @Override
    protected Topic getEntity(TopicAttributes attributes) {
      return getTopicEntity(attributes.getName());
    }


    /**
     * Return a Topic which retrieved from database
     * @param topicId name of the Topic
     */
    public Topic getTopicEntity(String topicId) {
      return load().id(topicId).now();
    }

    private List<Topic> getTopicEntities(List<String> topicIds) {
      if (topicIds.isEmpty()) {
          return new ArrayList<>();
      }

      return new ArrayList<>(
              load().ids(topicIds).values());
    }

    /**
     *
     * Convert the object from Topic into TopicAttribute
     * @param entity name of the Topic
     * @return TopicAttributes
     */
    @Override
    protected TopicAttributes makeAttributes(Topic entity) {
      Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, entity);

      return TopicAttributes.builder(entity.getId(), entity.getName(), entity.getDesc(), entity.getReplies())
              .build();
    }

    @Override
    protected QueryKeys<Topic> getEntityQueryKeys(TopicAttributes attributes) {
      Key<Topic> keyToFind = Key.create(Topic.class, attributes.getId());
      return load().filterKey(keyToFind).keys();
    }


    /**
     * Retrieve all topics stored in the database
     * @return List<TopicAttributes>
     */

    public List<TopicAttributes> getAllTopics(){
      return makeAttributes(load().list());
    }


    /**
     * Remove the topic in the databased based on the topicID
     * @param  topicName it's an id of the object in the database
     */
    public void deleteTopic(String topicID) {

       Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, topicID);

        // only the courseId is important here, everything else are placeholders
        deleteEntity(TopicAttributes
                .builder(topicID, null, null, null)
                .build());


    }
}
