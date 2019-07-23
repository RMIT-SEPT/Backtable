package teammates.test.cases.browsertests;

import org.junit.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.UUID;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.AppUrl;
import teammates.common.util.Const;
import teammates.test.pageobjects.StudentDiscussionBoardPage;
import teammates.test.pageobjects.StudentHomePage;
import teammates.storage.entity.Reply;

public class StudentDiscussionBoardPageUiTest extends BaseUiTestCase {
  private StudentDiscussionBoardPage discussionBoardPage;
  private String uniqueID = UUID.randomUUID().toString();
  // Create a valid topic for testing
  private TopicAttributes validTopic =
          TopicAttributes
                .builder(uniqueID, "Benny Charles", "A1Help", "I need help", new ArrayList<Reply>(), 0, 0)
                .build();

  protected void prepareTestData() {
      // Load the test data (account used to test)
      testData = loadDataBundle("/StudentDiscussionBoardPageUiTest.json");
      removeAndRestoreDataBundle(testData);
  }

  @BeforeClass
  public void classSetup() {
      // Delete existing test topic if there is one
      discussionBoardPage = getDiscussionBoardPageForStudent("studentWithEmptyProfile");
      discussionBoardPage = discussionBoardPage.deleteTopic(validTopic.getName());
  }

  @Test
  public void allTests() throws Exception {
      prepareTestData();
      testNavLinkToPage();
      testAddAction();
      testCancelDeleteAction();
      testDeleteAction();
  }

protected void testAddAction() throws Exception {
      // Create a new topic
      ______TS("Add action success");
      discussionBoardPage.addTopic(validTopic.getName(), validTopic.getDesc());
      // Assert the page contains the topic
      assertTrue(discussionBoardPage.containsTestTopic());
  }

  private void testCancelDeleteAction() throws Exception {
      discussionBoardPage.cancelDeleteTopic(validTopic.getName());
      // Assert the page still contains the topic
      assertTrue(discussionBoardPage.containsTestTopic());
  }

  private void testDeleteAction() throws Exception {
      // Called, assuming the valid topic had been added
      discussionBoardPage.deleteTopic(validTopic.getName());
      // Assert the page doesn't contain the topic
      assertFalse(discussionBoardPage.containsTestTopic());
  }

  private void testNavLinkToPage() {
      AppUrl profileUrl = createUrl(Const.ActionURIs.STUDENT_HOME_PAGE)
                                 .withUserId(testData.accounts.get("studentWithEmptyProfile").googleId);
      StudentHomePage shp = loginAdminToPage(profileUrl, StudentHomePage.class);
      discussionBoardPage = shp.loadDiscussionBoardTab();
  }

  private StudentDiscussionBoardPage getDiscussionBoardPageForStudent(String studentId) {
      AppUrl profileUrl = createUrl(Const.ActionURIs.STUDENT_DISCUSSION_BOARD_PAGE)
                                 .withUserId(testData.accounts.get(studentId).googleId);
      return loginAdminToPage(profileUrl, StudentDiscussionBoardPage.class);
  }
}
