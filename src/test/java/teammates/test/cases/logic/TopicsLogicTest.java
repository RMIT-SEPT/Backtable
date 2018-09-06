package teammates.test.cases.logic;

import org.testng.annotations.Test;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.logic.core.TopicsLogic;

public class TopicsLogicTest extends BaseLogicTest {

    private static final TopicsLogic topicsLogic = TopicsLogic.inst();

    @Test
    public void testAll() throws Exception {
        testCreateTopic();
        testDeleteTopic();
    }

    private void testCreateTopic() throws Exception {

        ______TS("typical case");
        TopicAttributes topicAttributes = TopicAttributes
                .builder("A1Help", "I need help")
                .build();
        topicsLogic.createTopic(topicAttributes.getName(), topicAttributes.getDesc());
        verifyPresentInDatastore(topicAttributes);

        ______TS("Null description");
        try {
            topicsLogic.createTopic(topicAttributes.getName(), null);
            signalFailureToDetectException();
        } catch (AssertionError e) {
            assertEquals("Non-null value expected", e.getMessage());
        }

        ______TS("Null name");
        try {
            topicsLogic.createTopic(null, topicAttributes.getDesc());
            signalFailureToDetectException();
        } catch (AssertionError e) {
            assertEquals("Non-null value expected", e.getMessage());
        }
    }

    private void testDeleteTopic() {
      // Run assuming the topic is still in the datastore
      ______TS("typical case");
      TopicAttributes topicAttributes = TopicAttributes
              .builder("A1Help", "I need help")
              .build();
      topicsLogic.deleteTopicCascade(topicAttributes.getName());
      verifyAbsentInDatastore(topicAttributes);
    }

}
