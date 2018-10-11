package teammates.test.cases.pagedata;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import teammates.storage.entity.Reply;
import teammates.test.cases.BaseTestCase;
import teammates.ui.pagedata.StudentDiscussionBoardPageData;
import teammates.ui.template.ActiveTopicsTable;
import teammates.ui.template.ActiveTopicsTableRow;
import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;

public class StudentDiscussionBoardPageDataTest extends BaseTestCase {
    private ArrayList<TopicAttributes> falseData;
    private AccountAttributes acct;
    private String testName = "Benny Charles";

    private StudentDiscussionBoardPageData sdbpd;

    @Test
    public void testAll() {
        testWithNoTopics();
        testWithTopics();
    }

    private void testWithNoTopics() {
        sdbpd = initializeData();
        testNoTopics(sdbpd.getActiveTopics());
    }

    private void testWithTopics() {
        sdbpd = initializeData();
        sdbpd = createFalseData(sdbpd);
        testTopics(sdbpd.getActiveTopics());
    }

    private StudentDiscussionBoardPageData initializeData() {
        acct = AccountAttributes.builder()
                .withGoogleId("valid.id")
                .withName("full name")
                .withEmail("e@email.com")
                .withInstitute("inst")
                .withIsInstructor(false)
                .build();
        return new StudentDiscussionBoardPageData(acct, dummySessionToken);
    }

    private StudentDiscussionBoardPageData createFalseData(StudentDiscussionBoardPageData data) {
        falseData = new ArrayList<TopicAttributes>();

        TopicAttributes validTopic =
            TopicAttributes
                .builder(UUID.randomUUID().toString(), testName, "A1Help", "I need help", new ArrayList<Reply>(), 0, 0)
                .build();
        TopicAttributes validTopic2 =
            TopicAttributes
                .builder(UUID.randomUUID().toString(), testName, "A2Help", "I need help", new ArrayList<Reply>(), 0, 0)
                .build();

        // Add the topics
        falseData.add(validTopic);
        falseData.add(validTopic2);
        data.init(falseData);
        return data;
    }

    private void testNoTopics(ActiveTopicsTable topics) {
        assertTrue(topics == null);
    }

    private void testTopics(ActiveTopicsTable topics) {
        List<ActiveTopicsTableRow> rows = topics.getRows();

        for(int i=0; i<rows.size(); i++) {
            // Get the topic attributes (for the page data and the fake data)
            String rowCreator = rows.get(i).getCreator();
            String rowName = rows.get(i).getName();
            String rowDesc = rows.get(i).getDesc();

            // Assert they are equal
            assertEquals(rowCreator, falseData.get(i).getCreator());
            assertEquals(rowName, falseData.get(i).getName());
            assertEquals(rowDesc, falseData.get(i).getDesc());
        }
    }
}
