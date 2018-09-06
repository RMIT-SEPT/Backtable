package teammates.test.cases.browsertests;

import org.junit.BeforeClass;
import org.testng.annotations.Test;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.AppUrl;
import teammates.common.util.Const;
import teammates.test.driver.BackDoor;
import teammates.test.pageobjects.StudentDiscussionBoardPage;
import teammates.test.pageobjects.StudentHomePage;

public class StudentDiscussionBoardPageUiTest extends BaseUiTestCase {
  private StudentDiscussionBoardPage discussionBoardPage;

  private TopicAttributes validTopic =
          TopicAttributes
                .builder("A1Help", "I need help")
                .build();

  protected void prepareTestData() {
    testData = loadDataBundle("/StudentDiscussionBoardPageUiTest.json");
    removeAndRestoreDataBundle(testData);
  }

  @BeforeClass
  public void classSetup() {
    BackDoor.deleteTopic(validTopic.getName()); // delete if it exists
  }

  @Test
  public void allTests() throws Exception {
    prepareTestData();
    testNavLinkToPage();
    testAddAction();
    testDeleteAction();
  }

  private void testAddAction() throws Exception {
    discussionBoardPage = getDiscussionBoadPageForStudent("studentWithEmptyProfile");

    ______TS("Add action success");
    discussionBoardPage.addTopic(validTopic.getName(), validTopic.getDesc());
    // Assert the page contains the topic
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

  private StudentDiscussionBoardPage getDiscussionBoadPageForStudent(String studentId) {
      AppUrl profileUrl = createUrl(Const.ActionURIs.STUDENT_DISCUSSION_BOARD_PAGE)
                                 .withUserId(testData.accounts.get(studentId).googleId);
      return loginAdminToPage(profileUrl, StudentDiscussionBoardPage.class);
  }
}
