package teammates.test.cases.datatransfer;

import java.util.ArrayList;
import java.util.UUID;

import org.testng.annotations.Test;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.storage.entity.Reply;
import teammates.test.cases.BaseTestCase;

public class TopicAttributesTest extends BaseTestCase {
    private String testName = "Benny Charles";
    private String validName = "A1Help";
    private String validDesc = "I need help";

    // Test 1a.
    @Test
    public void testStandardBuilder() {
        TopicAttributes validTopic =
            TopicAttributes
                .builder(UUID.randomUUID().toString(), testName, "A1Help", "I need help", new ArrayList<Reply>(), 0, 0)
                .build();
        assertEquals(validName, validTopic.getName());
        assertEquals(validDesc, validTopic.getDesc());
    }

    // Test 1b.
    @Test
    public void testBuilderWithNullDescription() {
        try {
            TopicAttributes.builder(UUID.randomUUID().toString(), testName, validName, null, new ArrayList<Reply>(), 0, 0)
                .build();
            signalFailureToDetectException();
        } catch (AssertionError e) {
            assertEquals("Non-null value expected", e.getMessage());
        }
    }

    // Test 1c.
    @Test
    public void testBuilderWithNullName() {
        try {
            TopicAttributes.builder(UUID.randomUUID().toString(), testName, null, validDesc, new ArrayList<Reply>(), 0, 0)
                .build();
            signalFailureToDetectException();
        } catch (AssertionError e) {
            assertEquals("Non-null value expected", e.getMessage());
        }
    }
}
