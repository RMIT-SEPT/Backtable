package teammates.test.cases.datatransfer;

import java.time.Instant;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.google.appengine.api.datastore.Text;

import teammates.common.datatransfer.attributes.FeedbackResponseCommentAttributes;
import teammates.storage.entity.FeedbackResponseComment;
import teammates.test.cases.BaseTestCase;

/**
 * SUT: {@link teammates.common.datatransfer.attributes.FeedbackResponseCommentAttributes}.
 */
public class FeedbackResponseCommentAttributesTest extends BaseTestCase {

    @Test
    public void testBuilderWithDefaultValues() {
        FeedbackResponseCommentAttributes feedbackAttributes = FeedbackResponseCommentAttributes
                .builder("course", "name", "email", new Text(""))
                .build();

        // Default values for following fields
        assertEquals(feedbackAttributes.giverSection, "None");
        assertEquals(feedbackAttributes.receiverSection, "None");
        assertEquals(feedbackAttributes.showCommentTo, new ArrayList<>());
        assertEquals(feedbackAttributes.showGiverNameTo, new ArrayList<>());
        assertTrue(feedbackAttributes.isVisibilityFollowingFeedbackQuestion);
    }

    @Test
    public void testBuilderWithNullValues() {
        FeedbackResponseCommentAttributes feedbackAttributes = FeedbackResponseCommentAttributes
                .builder("course", "name", "email", new Text(""))
                .withFeedbackResponseId(null)
                .withFeedbackQuestionId(null)
                .withShowGiverNameTo(null)
                .withShowCommentTo(null)
                .withLastEditorEmail(null)
                .withReceiverSection(null)
                .withGiverSection(null)
                .withCreatedAt(Instant.now())
                .withLastEditedAt(null)
                .withFeedbackResponseCommentId(null)
                .withVisibilityFollowingFeedbackQuestion(null)
                .build();

        // Default values for following fields
        assertEquals(feedbackAttributes.giverSection, "None");
        assertEquals(feedbackAttributes.receiverSection, "None");
        assertEquals(feedbackAttributes.lastEditorEmail, feedbackAttributes.giverEmail);
        assertEquals(feedbackAttributes.lastEditedAt, feedbackAttributes.createdAt);
        assertTrue(feedbackAttributes.isVisibilityFollowingFeedbackQuestion);
    }

    @Test
    public void testValueOf() {
        FeedbackResponseComment responseComment = new FeedbackResponseComment("course", "name",
                "question", "giver", "response", Instant.now(),
                new Text("comment"), "giverSection", "receiverSection",
                null, null, null, null);

        FeedbackResponseCommentAttributes feedbackAttributes =
                FeedbackResponseCommentAttributes.valueOf(responseComment);

        assertEquals(responseComment, feedbackAttributes);
    }

    private void assertEquals(FeedbackResponseComment responseComment,
                              FeedbackResponseCommentAttributes feedbackAttributes) {
        assertEquals(responseComment.getCourseId(), feedbackAttributes.courseId);
        assertEquals(responseComment.getFeedbackSessionName(), feedbackAttributes.feedbackSessionName);
        assertEquals(responseComment.getFeedbackQuestionId(), feedbackAttributes.feedbackQuestionId);
        assertEquals(responseComment.getGiverEmail(), feedbackAttributes.giverEmail);
        assertEquals(responseComment.getFeedbackResponseId(), feedbackAttributes.feedbackResponseId);
        assertEquals(responseComment.getShowCommentTo(), feedbackAttributes.showCommentTo);
        assertEquals(responseComment.getShowGiverNameTo(), feedbackAttributes.showGiverNameTo);
        assertEquals(responseComment.getCreatedAt(), feedbackAttributes.createdAt);
        assertEquals(responseComment.getCommentText(), feedbackAttributes.commentText);
        assertEquals(responseComment.getLastEditorEmail(), feedbackAttributes.lastEditorEmail);
        assertEquals(responseComment.getLastEditedAt(), feedbackAttributes.lastEditedAt);
        assertEquals(responseComment.getGiverSection(), feedbackAttributes.giverSection);
        assertEquals(responseComment.getReceiverSection(), feedbackAttributes.receiverSection);
        assertEquals(responseComment.getFeedbackResponseCommentId(), feedbackAttributes.feedbackResponseCommentId);

        if (responseComment.getIsVisibilityFollowingFeedbackQuestion() == null) {
            assertTrue(feedbackAttributes.isVisibilityFollowingFeedbackQuestion);
        } else {
            assertEquals(responseComment.getIsVisibilityFollowingFeedbackQuestion().booleanValue(),
                    feedbackAttributes.isVisibilityFollowingFeedbackQuestion);
        }
    }
}
