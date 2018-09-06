package teammates.test.cases.browsertests;

import org.junit.BeforeClass;
import org.testng.annotations.Test;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.AppUrl;
import teammates.common.util.Const;
import teammates.test.driver.BackDoor;
import teammates.test.pageobjects.StudentDiscussionBoardPage;

public class StudentDiscussionBoardPageUiTest extends BaseUiTestCase {
  private StudentDiscussionBoardPage discussionBoardPage;

  private TopicAttributes validTopic =
          TopicAttributes
                .builder("A1Help", "I need help")
                .build();

  @Test
  protected void prepareTestData() {
    testData = loadDataBundle("/StudentDiscussionBoardPageUiTest.json");
    removeAndRestoreDataBundle(testData);
  }

  @BeforeClass
  public void classSetup() {
    BackDoor.deleteTopic(validTopic.getName()); // delete if it exists
  }

//  @Test
//  public void allTests() throws Exception {
//    testAddAction();
//    testDeleteAction();
//  }

  @Test
  private void testAddAction() throws Exception {
    discussionBoardPage = getDiscussionBoadPageForStudent("studentWithEmptyProfile");

    ______TS("Add action success");
    discussionBoardPage.addTopic(validTopic.getName(), validTopic.getDesc());
    // Assert the page contains the topic
    assertTrue(discussionBoardPage.containsTestTopic());
  }

  @Test
  private void testDeleteAction() throws Exception {
    // Called, assuming the valid topic had been added
    discussionBoardPage.deleteTopic(validTopic.getName());
    // Assert the page doesn't contain the topic
    assertFalse(discussionBoardPage.containsTestTopic());
  }

  private StudentDiscussionBoardPage getDiscussionBoadPageForStudent(String studentId) {
      AppUrl profileUrl = createUrl(Const.ActionURIs.STUDENT_DISCUSSION_BOARD_PAGE)
                                 .withUserId(testData.accounts.get(studentId).googleId);
      return loginAdminToPage(profileUrl, StudentDiscussionBoardPage.class);
  }


  // @Override
  // protected void prepareTestData() throws Exception {
  //   testData = loadDataBundle("/StudentDiscussionBoardPageUiTest.json");
  //   removeAndRestoreDataBundle(testData);
  // }
  //
  // @Test
  // public void allTests() throws Exception {
  //   testNavLinkToPage();
  //   testContent();
  //   testActions();
  // }
  //
  // private void testNavLinkToPage() {
  //   AppUrl profileUrl = createUrl(Const.ActionURIs.STUDENT_HOME_PAGE)
  //                              .withUserId(testData.accounts.get("studentWithEmptyProfile").googleId);
  //   StudentHomePage shp = loginAdminToPage(profileUrl, StudentHomePage.class);
  //   discussionBoardPage = shp.loadDiscussionBoardTab();
  // }
  //
  // private void testContent() throws Exception {
  //   // assumes it is run after NavLinks Test
  //   // (ie already logged in as studentWithEmptyProfile
  //   //  ______TS("Typical case: empty profile values");
  //   // Test doesn't run due to java.lang.RuntimeException: org.w3c.dom.DOMException:
  //   // NAMESPACE_ERR: An attempt is made to create or change an object in a way which
  //   // is incorrect with regard to namespaces.
  //   // discussionBoardPage.verifyHtml("/studentDiscussionBoardPageDefault.html");
  //
  //   // Test the discussion board test data content
  //   discussionBoardPage = getDiscussionBoadPageForStudent("studentWithEmptyProfile");
  //   discussionBoardPage.verifyHtmlPart(
  //          By.id("topics-table"), "/studentDiscussionBoardTableExistingValues.html");
  //
  //   // Test the discussion board form content
  //   discussionBoardPage = getDiscussionBoadPageForStudent("studentWithEmptyProfile");
  //   discussionBoardPage.verifyHtmlPart(
  //          By.className("form"), "/studentDiscussionBoardAddTopicForm.html");
  // }
  //
  // private void testActions() {
  //   // Test the test data has populated the discussion board
  //   discussionBoardPage.ensureDiscussionBoardContainsTestData();
  // }
  //
  // private StudentDiscussionBoardPage getDiscussionBoadPageForStudent(String studentId) {
  //     AppUrl profileUrl = createUrl(Const.ActionURIs.STUDENT_DISCUSSION_BOARD_PAGE)
  //                                .withUserId(testData.accounts.get(studentId).googleId);
  //     return loginAdminToPage(profileUrl, StudentDiscussionBoardPage.class);
  // }
}
