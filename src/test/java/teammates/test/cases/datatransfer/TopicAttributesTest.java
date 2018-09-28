package teammates.test.cases.datatransfer;

import org.testng.annotations.Test;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.test.cases.BaseTestCase;

public class TopicAttributesTest extends BaseTestCase {

    private String validName = "A1Help";
    private String validDesc = "I need help";

    // Test 1a.
/*    @Test
    public void testStandardBuilder() {
      TopicAttributes topicAttributes = TopicAttributes
              .builder(validName, validDesc)
              .build();
      assertEquals(validName, topicAttributes.getName());
      assertEquals(validDesc, topicAttributes.getDesc());
    }

    // Test 1b.
    @Test
    public void testBuilderWithNullDescription() {
      try {
        TopicAttributes.builder(validName, null)
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
        TopicAttributes.builder(null, validDesc)
              .build();
        signalFailureToDetectException();
      } catch (AssertionError e) {
        assertEquals("Non-null value expected", e.getMessage());
      }
    }*/
}
