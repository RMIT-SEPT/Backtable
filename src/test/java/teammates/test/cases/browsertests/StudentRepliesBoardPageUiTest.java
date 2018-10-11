package teammates.test.cases.browsertests;

import org.testng.annotations.Test;

import teammates.common.util.AppUrl;
import teammates.common.util.Const;
import teammates.test.pageobjects.StudentDiscussionBoardPage;
import teammates.test.pageobjects.StudentRepliesBoardPage;

public class StudentRepliesBoardPageUiTest extends BaseUiTestCase {
    private StudentDiscussionBoardPage discussionBoardPage;
    private StudentRepliesBoardPage repliesBoardPage;
    private String topicId, topicName, topicDesc, replyDesc;

    @Override
    protected void prepareTestData() throws Exception {
        testData = loadDataBundle("/StudentRepliesBoardPageUiTest.json");
        removeAndRestoreDataBundle(testData);
      
        topicName = "TESTING_REPLIES_BOARD";
        topicDesc = "testing_replies_board_desc";
        replyDesc = "this_is_a_test_reply";
    }

    @Test
    public void allTests() throws Exception {
        prepareTestData();

        // Create the test topic and get the replies board for that topic
        discussionBoardPage = createTestTopic();
        repliesBoardPage = getRepliesBoardPage(topicName);

        testContent();
        testAddAction();
        testLikeAction();
        testDislikeAction();
        testCancelDeleteAction();
        testDeleteAction();
        deleteTestData();
    }

    private void testContent() {
        assertTrue(repliesBoardPage.containsExpectedTopic(topicName, topicDesc));
    }

    private void testAddAction() throws Exception {
        repliesBoardPage.addReply(replyDesc);
        // Get the replies board page and assert the reply has been added
        repliesBoardPage = getRepliesBoardPage(topicName);
        assertTrue(repliesBoardPage.containsExpectedReply(
                   testData.accounts.get("studentWithEmptyProfile").name, replyDesc));
    }

    private void testLikeAction() throws Exception {
        // Assert the like button increments the likes by one
        assertTrue(repliesBoardPage.likeReply(replyDesc));
    }

    private void testDislikeAction() throws Exception {
        // Assert the dislike button increments the dislikes by one
        assertTrue(repliesBoardPage.dislikeReply(replyDesc));
    }

    private void testCancelDeleteAction() throws Exception {
        repliesBoardPage.cancelDeleteReply(replyDesc);
        // Get the replies board page and assert the reply still exists
        repliesBoardPage = getRepliesBoardPage(topicName);
        assertTrue(repliesBoardPage.containsExpectedReply(
                   testData.accounts.get("studentWithEmptyProfile").name, replyDesc));
    }

    private void testDeleteAction() throws Exception {
        repliesBoardPage.deleteReply(replyDesc);
        // Get the replies board page and assert the reply has been deleted
        repliesBoardPage = getRepliesBoardPage(topicName);
        assertFalse(repliesBoardPage.containsExpectedReply(
                    testData.accounts.get("studentWithEmptyProfile").name, replyDesc));
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

    private StudentRepliesBoardPage getRepliesBoardPage(String topicName) {
        // Load a discussion board page
        discussionBoardPage = getDiscussionBoardPage();
        String topicEditPageUrl = discussionBoardPage.getEditLink(topicName);
        // Get the id from the edit topic page url
        topicId = topicEditPageUrl.split("topicId=")[1].split("&")[0];

        AppUrl repliesBoardPageLink = createUrl(Const.ActionURIs.STUDENT_REPLIES_BOARD_PAGE)
              .withTopicName(topicName)
              .withTopicId(topicId)
              .withUserId(testData.accounts.get("studentWithEmptyProfile").googleId);
        return loginAdminToPage(repliesBoardPageLink, StudentRepliesBoardPage.class);
    }

    private void deleteTestData() {
        // Delete the testing topic
        discussionBoardPage = getDiscussionBoardPage();
        discussionBoardPage.deleteTopic(topicName);
    }
}
