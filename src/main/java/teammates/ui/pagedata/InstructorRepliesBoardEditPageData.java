package teammates.ui.pagedata;

import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.ui.template.ElementTag;

public class InstructorRepliesBoardEditPageData extends PageData {
    private TopicAttributes topic;
    private RepliesAttributes reply;
    private ElementTag editReplyButton;

    public InstructorRepliesBoardEditPageData(AccountAttributes account, String sessionToken) {
      super(account, sessionToken);

      createReplyRelatedButtons();
    }

    private void createReplyRelatedButtons() {
      editReplyButton = createEditReplyButton();
    }

    private ElementTag createEditReplyButton() {
        String buttonContent = "<span class=\"glyphicon glyphicon-pencil\"></span> Edit";
        String buttonId = "btnEditReply";

        return createBasicButton(buttonContent, buttonId, "javascript:;", null, false);
    }

    public void init(TopicAttributes topic, RepliesAttributes reply)
    {
        this.topic = topic;
        this.reply = reply;
    }

    public TopicAttributes getTopic()
    {
        return topic;
    }

    public RepliesAttributes getReply()
    {
        return reply;
    }

    public ElementTag getEditReplyButton() {
        return editReplyButton;
    }

    public String getDiscussionBoardDetailsLink()
    {
        return getInstructorDiscussionBoardDetailsLink(topic.getName(), topic.getId());
    }

    /**
     * Creates a basic bootstrap button for use in {@code <a></a>} tags in panel header.
     */
    private ElementTag createBasicButton(String buttonText, String buttonId, String href, String tooltipText,
                                         boolean isDisabled) {
        ElementTag button = new ElementTag(buttonText);
        button.setAttribute("type", "button");
        button.setAttribute("class", "btn btn-primary btn-xs");

        if (buttonId != null) {
            button.setAttribute("id", buttonId);
        }
        if (href != null) {
            button.setAttribute("href", href);
        }
        if (tooltipText != null) {
            button.setAttribute("title", tooltipText);
            button.setAttribute("data-toggle", "tooltip");
            button.setAttribute("data-placement", "top");
        }
        if (isDisabled) {
            button.setAttribute("disabled", null);
        }

        return button;
    }
}
