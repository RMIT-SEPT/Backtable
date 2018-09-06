package teammates.test.cases.pagedata;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import teammates.common.util.Const;
import teammates.common.util.StringHelper;
import teammates.test.cases.BaseTestCase;
import teammates.ui.pagedata.StudentDiscussionBoardPageData;
import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.datatransfer.TopicDetailsBundle;

public class StudentDiscussionBoardPageDataTest extends BaseTestCase {

    // private TopicDetailsBundle tdb;
    // private ArrayList<TopicDetailsBundle> falseData;
    // private AccountAttributes acct;
    //
    // private StudentDiscussionBoardPageData sdbpd;
    //
    // @Test
    // public void testAll() {
    //   testWithNoTopics();
    //   testWithTopics();
    // }
    //
    // private void testWithNoTopics() {
    //   sdbpd = initializeData();
    //   testNoTopics(sdbpd.getTopics());
    // }
    //
    // private void testWithTopics() {
    //   sdbpd = initializeData();
    //   sdbpd = createFalseData(sdbpd);
    //   testTopics(sdbpd.getTopics());
    // }
    //
    // private StudentDiscussionBoardPageData initializeData() {
    //   acct = AccountAttributes.builder()
    //           .withGoogleId("valid.id")
    //           .withName("full name")
    //           .withEmail("e@email.com")
    //           .withInstitute("inst")
    //           .withIsInstructor(false)
    //           // .withStudentProfileAttributes(spa)
    //           .build();
    //   return new StudentDiscussionBoardPageData(acct, dummySessionToken);
    // }
    //
    // private StudentDiscussionBoardPageData createFalseData(StudentDiscussionBoardPageData data) {
    //   data.topics = new ArrayList<TopicDetailsBundle>();
    //   falseData = new ArrayList<TopicDetailsBundle>();
    //
    //   falseData.add(new TopicDetailsBundle(new TopicAttributes("Testing Topic One", "This is the description for Topic One.")));
    //   falseData.add(new TopicDetailsBundle(new TopicAttributes("Testing Topic Two", "This is the description for Topic Two.")));
    //
    //   data.topics = falseData;
    //   return data;
    // }
    //
    // private void testNoTopics(List<TopicDetailsBundle> topics) {
    //   assertTrue(topics == null);
    // }
    //
    // private void testTopics(List<TopicDetailsBundle> topics) {
    //   for(int i=0; i<topics.size(); i++) {
    //     // Get the topic attributes (for the page data and the fake data)
    //     TopicAttributes ta = topics.get(i).getTopic();
    //     TopicAttributes taFalse = falseData.get(i).getTopic();
    //
    //     // Assert they are equal
    //     assertEquals(ta.getName(), taFalse.getName());
    //     assertEquals(StringHelper.convertToEmptyStringIfNull(ta.getDesc()), taFalse.getDesc());
    //   }
    // }
}
