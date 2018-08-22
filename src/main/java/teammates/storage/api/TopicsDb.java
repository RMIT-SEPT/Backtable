package teammates.storage.api;

import static com.googlecode.objectify.ObjectifyService.ofy;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.LoadType;
import com.googlecode.objectify.cmd.QueryKeys;

import teammates.common.datatransfer.attributes.FeedbackQuestionAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.storage.entity.FeedbackQuestion;
import teammates.storage.entity.Topic;

public class TopicsDb extends EntitiesDb<Topic, TopicAttributes> {

  public TopicAttributes getTopic(String topicId) {
    Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, topicId);

    return makeAttributesOrNull(getTopicEntity(topicId),
            "Trying to get non-existent Topic: " + topicId);
}
  
  private Topic getTopicEntity(String topicId) {
    Assumption.assertNotNull(Const.StatusCodes.DBLEVEL_NULL_INPUT, topicId);

    Key<Topic> key = makeKeyOrNullFromWebSafeString(topicId);
    if (key == null) {
        return null;
    }
    return ofy().load().key(key).now();
  }
  
  @Override
  protected LoadType<Topic> load() {
    // TODO Auto-generated method stub
    return ofy().load().type(Topic.class);
  }

  @Override
  protected Topic getEntity(TopicAttributes attributes) {
    if (attributes.getId() != null) {
      return getTopicEntity(attributes.getId());
  }
  return getTopicEntity(attributes.id);
}

  @Override
  protected QueryKeys<Topic> getEntityQueryKeys(TopicAttributes attributes) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected TopicAttributes makeAttributes(Topic entity) {
    // TODO Auto-generated method stub
    return null;
  }

}
