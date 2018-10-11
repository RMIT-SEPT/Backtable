package teammates.test.cases.browsertests;

import org.testng.annotations.Test;

import teammates.common.util.AppUrl;
import teammates.common.util.Const;
import teammates.test.pageobjects.StudentDiscussionBoardTopicEditPage;
import teammates.test.pageobjects.StudentDiscussionBoardPage;

public class StudentDiscussionBoardTopicEditPageUiTest extends BaseUiTestCase {
    private StudentDiscussionBoardTopicEditPage topicEditPage;
    private StudentDiscussionBoardPage discussionBoardPage;
    private String topicId, topicName, topicDesc, newTopicName, newTopicDesc;

    @Override
    protected void prepareTestData() throws Exception {
        testData = loadDataBundle("/StudentDiscussionBoardTopicEditPageUiTest.json");
        removeAndRestoreDataBundle(testData);
        // Following strings created locally, rather than storing in the json file
        topicName = "TESTING_EDIT_PAGE_TOPIC";
        topicDesc = "testing_edit_page_desc";
        newTopicName = "CHANGED_TESTING_EDIT_PAGE_TOPIC";
        newTopicDesc = "changed_testing_edit_page_desc";
    }

    @Test
    public void allTests() throws Exception {
      prepareTestData();
      // Manually create the test on the discussion board using Selenium
      discussionBoardPage = createTestTopic();
      // Load the newly created edit topic page
      topicEditPage = getTopicEditPage(topicName);
      testEditTopicAction();
      testCancelDeleteTopicAction();
      testDeleteTopicAction();
    }

    private void testEditTopicAction() {
        // Edit the topic
        topicEditPage.editTopic(newTopicName, newTopicDesc);
        topicEditPage = getTopicEditPage(newTopicName);
        assertTrue(topicEditPage.containsExpectedTopic(newTopicName, newTopicDesc));
    }

    private void testCancelDeleteTopicAction() {
        // Cancel the deletion
        topicEditPage.cancelDeleteTopic();
        assertTrue(topicEditPage.containsExpectedTopic(newTopicName, newTopicDesc));
    }

    private void testDeleteTopicAction() {
        // Delete the topic
        topicEditPage.deleteTopic();
        assertFalse(topicEditPage.containsExpectedTopic(newTopicName, newTopicDesc));
    }

    private StudentDiscussionBoardPage createTestTopic() {
        // Manually create the test on the discussion board using Selenium
        discussionBoardPage = getDiscussionBoardPage();
        discussionBoardPage.addTopic(topicName, topicDesc);
        return discussionBoardPage;
    }

    private StudentDiscussionBoardPage getDiscussionBoardPage() {
        // Return the student discussion board page
        AppUrl profileUrl = createUrl(Const.ActionURIs.STUDENT_DISCUSSION_BOARD_PAGE)
                .withUserId(testData.accounts.get("studentWithEmptyProfile").googleId);
        return loginAdminToPage(profileUrl, StudentDiscussionBoardPage.class);
    }

    private StudentDiscussionBoardTopicEditPage getTopicEditPage(String topicName) {
        // Load a discussion board page
        discussionBoardPage = getDiscussionBoardPage();
        // Get the edit page link for a pre-existing testing topic
        String topicEditPageUrl= discussionBoardPage.getEditLink(topicName);

        // Get the id of the topic from the edit link
        // There was no easy way to get the id, which was crucial for creating the edit topic page
        topicId = topicEditPageUrl.split("topicId=")[1].split("&")[0];

        // Load the edit topic page for the pre-existing testing topic
        AppUrl topicEditPageLink = createUrl(Const.ActionURIs.STUDENT_DISCUSSION_BOARD_EDIT_TOPIC_PAGE)
              .withTopicName(topicName)
              .withTopicId(topicId)
              .withUserId(testData.accounts.get("studentWithEmptyProfile").googleId);
        return loginAdminToPage(topicEditPageLink, StudentDiscussionBoardTopicEditPage.class);
    }
}
