package teammates.test.cases.browsertests;

import org.testng.annotations.Test;

import teammates.common.util.AppUrl;
import teammates.common.util.Const;
import teammates.test.pageobjects.StudentDiscussionBoardPage;
import teammates.test.pageobjects.StudentRepliesBoardEditPage;
import teammates.test.pageobjects.StudentRepliesBoardPage;

public class StudentRepliesBoardEditPageUiTest extends BaseUiTestCase {
    private StudentDiscussionBoardPage discussionBoardPage;
    private StudentRepliesBoardPage repliesBoardPage;
    private StudentRepliesBoardEditPage repliesBoardEditPage;
    private String topicId, topicName, topicDesc, replyDesc, newReplyDesc;

    @Override
    protected void prepareTestData() throws Exception {
        testData = loadDataBundle("/StudentRepliesBoardPageUiTest.json");
        removeAndRestoreDataBundle(testData);

        topicName = "TESTING_REPLIES_BOARD_EDIT_PAGE";
        topicDesc = "testing_replies_board_edit_pagedesc";
        replyDesc = "this_is_a_test_reply";
        newReplyDesc = "this_is_a_changed_test_reply";
    }

    @Test
    public void allTests() throws Exception {
        prepareTestData();

        // Create the test topic and get the replies board for that topic
        discussionBoardPage = createTestTopic();
        repliesBoardPage = getRepliesBoardPage(topicName);
        // Create the test reply and get the replies board edit page for that reply
        repliesBoardPage.addReply(replyDesc);
        repliesBoardEditPage = getRepliesBoardEditPage();

        testContent();
        testEditReply();
        testCancelDeleteReply();
        testDeleteReply();
        deleteTestData();
    }

    private void testContent() {
        assertTrue(repliesBoardEditPage.containsExpectedPageContents());
    }

    private void testEditReply() {
        // Get the replies board edit page
        repliesBoardEditPage = getRepliesBoardEditPage();
        repliesBoardEditPage.editReply(newReplyDesc);
        // Get the replies board page and assert the reply has been edited
        repliesBoardPage = getRepliesBoardPage(topicName);
        assertTrue(repliesBoardPage.containsExpectedReply(
                   testData.accounts.get("studentWithEmptyProfile").name, newReplyDesc));
    }

    private void testCancelDeleteReply() {
        // Get the replies board edit page
        repliesBoardEditPage = getRepliesBoardEditPage();
        repliesBoardEditPage.cancelDeleteReply();
        // Get the replies board page and assert the reply still exists
        repliesBoardPage = getRepliesBoardPage(topicName);
        assertTrue(repliesBoardPage.containsExpectedReply(
                   testData.accounts.get("studentWithEmptyProfile").name, newReplyDesc));
    }

    private void testDeleteReply() {
        // Get the replies board edit page
        repliesBoardEditPage = getRepliesBoardEditPage();
        repliesBoardEditPage.deleteReply();
        // Get thre replies board page and assert the reply is gone
        repliesBoardPage = getRepliesBoardPage(topicName);
        assertFalse(repliesBoardPage.containsExpectedReply(
                    testData.accounts.get("studentWithEmptyProfile").name, newReplyDesc));
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

    private StudentRepliesBoardEditPage getRepliesBoardEditPage() {
        // Get the replies board edit page for the test reply
        // Since there is only one test reply, there is no need to get the replyId
        AppUrl repliesBoardEditPageLink = createUrl(Const.ActionURIs.STUDENT_REPLIES_EDIT_PAGE)
                .withTopicId(topicId)
                .withReplyId(0);
        return loginAdminToPage(repliesBoardEditPageLink, StudentRepliesBoardEditPage.class);
    }

    private void deleteTestData() {
        // Delete the testing topic
        discussionBoardPage = getDiscussionBoardPage();
        discussionBoardPage.deleteTopic(topicName);
    }
}
