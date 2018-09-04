package teammates.test.cases.browsertests;

import org.testng.annotations.Test;

import teammates.common.util.AppUrl;
import teammates.common.util.Const;
import teammates.test.pageobjects.StudentHomePage;
import teammates.test.pageobjects.StudentDiscussionBoardPage;

public class StudentDiscussionBoardPageUiTest extends BaseUiTestCase {
  private StudentDiscussionBoardPage discussionBoardPage;

  @Override
  protected void prepareTestData() throws Exception {
    testData = loadDataBundle("/StudentDiscussionBoardPageUiTest.json");
    removeAndRestoreDataBundle(testData);
  }

  @Test
  public void allTests() throws Exception {
    testNavLinkToPage();
    testContent();
    testActions();
  }

  private void testNavLinkToPage() {
    AppUrl profileUrl = createUrl(Const.ActionURIs.STUDENT_HOME_PAGE)
                               .withUserId(testData.accounts.get("studentWithEmptyProfile").googleId);
    StudentHomePage shp = loginAdminToPage(profileUrl, StudentHomePage.class);
    discussionBoardPage = shp.loadDiscussionBoardTab();
  }

  private void testContent() throws Exception {
    // assumes it is run after NavLinks Test
    // (ie already logged in as studentWithEmptyProfile
    ______TS("Typical case: empty profile values");

    discussionBoardPage.verifyHtml("/studentDiscussionBoardPageDefault.html");
  }

  private void testActions() {
    // Call method to test the new topic action once fully implemented

    // Test the test data has populated the discussion board
    discussionBoardPage.ensureDiscussionBoardContainsTestData();
  }

}
