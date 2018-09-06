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
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.storage.entity.Course;
import teammates.storage.entity.FeedbackQuestion;
import teammates.storage.entity.Topic;

public class TopicsDb extends EntitiesDb<Topic, TopicAttributes> {

  
  @Override
  protected LoadType<Topic> load() {
    return ofy().load().type(Topic.class);
  }

      public static final String ERROR_UPDATE_NON_EXISTENT_TOPIC = "Trying to update a Topic that doesn't exist: ";

      public void createTopics(Collection<TopicAttributes> topicsToAdd) throws InvalidParametersException {
          List<TopicAttributes> topicsToUpdate = createEntities(topicsToAdd);
          for (TopicAttributes topic : topicsToUpdate) {
              try {
                  updateTopic(topic);
              } catch (EntityDoesNotExistException e) {
                  // This situation is not tested as replicating such a situation is
                  // difficult during testing
                  Assumption.fail("Entity found be already existing and not existing simultaneously");
              }
          }
      }

      /**
       * Preconditions: <br>
       * * All parameters are non-null.
       * @return Null if not found.
       */
      public TopicAttributes getTopic(String topicId) {
          Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, topicId);

          return makeAttributesOrNull(getTopicEntity(topicId));
      }

      public List<TopicAttributes> getTopics(List<String> topicIds) {
          Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, topicIds);

          return makeAttributes(getTopicEntities(topicIds));
      }

      
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
       * Note: This is a non-cascade delete.<br>
       *   <br> Fails silently if there is no such object.
       * <br> Preconditions:
       * <br> * {@code topicId} is not null.
       */
   

     

      @Override
      protected Topic getEntity(TopicAttributes attributes) {
          return getTopicEntity(attributes.getName());
      }


      private Topic getTopicEntity(String topicId) {
          return load().id(topicId).now();
      }

      private List<Topic> getTopicEntities(List<String> topicIds) {
          if (topicIds.isEmpty()) {
              return new ArrayList<>();
          }

          return new ArrayList<>(
                  load().ids(topicIds).values());
      }

      @Override
      protected TopicAttributes makeAttributes(Topic entity) {
          Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, entity);
        
          return TopicAttributes.builder(entity.getName(), entity.getName())
                  .build();
      }
    
      @Override
      protected QueryKeys<Topic> getEntityQueryKeys(TopicAttributes attributes) {
          Key<Topic> keyToFind = Key.create(Topic.class, attributes.getName());
          return load().filterKey(keyToFind).keys();
      }
      
      public List<TopicAttributes> getAllTopics(){
          return makeAttributes(load().list());
      }


    public void deleteTopic(String topicName) {

            Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, topicName);

            // only the courseId is important here, everything else are placeholders
            deleteEntity(TopicAttributes
                    .builder(topicName, "Non-existent course")
                    .build());


    }
}
