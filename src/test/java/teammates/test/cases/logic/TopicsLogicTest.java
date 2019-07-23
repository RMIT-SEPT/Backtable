package teammates.test.cases.logic;

import java.util.ArrayList;
import java.util.UUID;

import org.testng.annotations.Test;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.logic.core.TopicsLogic;
import teammates.storage.api.TopicsDb;
import teammates.storage.entity.Reply;

public class TopicsLogicTest extends BaseLogicTest {

    private static final TopicsLogic topicsLogic = TopicsLogic.inst();
    private static final TopicsDb topicsDb = new TopicsDb();
    private String testName = "Benny Charles";

    private TopicAttributes validTopic1 =
            TopicAttributes
            .builder(UUID.randomUUID().toString(), testName, "A1Help", "I need help", new ArrayList<Reply>(), 0, 0)
            .build();
    private TopicAttributes validTopic2 =
            TopicAttributes
            .builder(UUID.randomUUID().toString(), testName, "A2Help", "I need help", new ArrayList<Reply>(), 0, 0)
            .build();

    @Test
    public void testAll() throws Exception {
        testCreateTopic();
        testDeleteTopic();
    }

    private void testCreateTopic() throws Exception {
        ______TS("typical case");
        topicsLogic.createTopic(validTopic1.getId(), validTopic1.getCreator(), validTopic1.getName(),
                                validTopic1.getDesc(), new ArrayList<Reply>(), validTopic1.getCount(),
                                validTopic1.getViewCounter());
        verifyPresent(validTopic1.getId());

        ______TS("Null description");
        try {
            topicsLogic.createTopic(validTopic2.getId(), validTopic2.getCreator(), validTopic2.getName(),
                    null, new ArrayList<Reply>(), validTopic2.getCount(),
                    validTopic2.getViewCounter());
            signalFailureToDetectException();
        } catch (AssertionError e) {
            assertEquals("Non-null value expected", e.getMessage());
        }
        verifyAbsentInDatastore(validTopic2);

        ______TS("Null name");
        try {
            topicsLogic.createTopic(validTopic2.getId(), validTopic2.getCreator(), null,
                    validTopic2.getDesc(), new ArrayList<Reply>(), validTopic2.getCount(),
                    validTopic2.getViewCounter());
            signalFailureToDetectException();
        } catch (AssertionError e) {
            assertEquals("Non-null value expected", e.getMessage());
        }
        verifyAbsentInDatastore(validTopic2);
    }

    private void testDeleteTopic() {
        // Run assuming the topic is still in the datastore
        ______TS("typical case");
        topicsLogic.deleteTopicCascade(validTopic1.getId());
        verifyAbsentInDatastore(validTopic1);
    }

    private void verifyPresent(String topicId) {
        assertNotNull(topicsDb.getTopic(topicId));
    }
}
