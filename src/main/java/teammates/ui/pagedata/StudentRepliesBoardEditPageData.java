package teammates.ui.pagedata;

import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.ui.template.ElementTag;
/**
 * Page data for replies board edit 
 */
public class StudentRepliesBoardEditPageData extends PageData {
    /*
     * Variable Declarations
     */
    private TopicAttributes topic;
    private RepliesAttributes reply;
    private ElementTag editReplyButton;
    private ElementTag deleteReplyButton;

    //Constructor
    public StudentRepliesBoardEditPageData(AccountAttributes account, String sessionToken, TopicAttributes topic, RepliesAttributes reply) {
      super(account, sessionToken);
      this.topic = topic;
      this.reply = reply;
      createReplyRelatedButtons();
    }

    //create buttons related to reply
    private void createReplyRelatedButtons() {
      editReplyButton = createEditReplyButton();
      deleteReplyButton = createDeleteReplyButton();
    }
    
    //create edit reply button
    private ElementTag createEditReplyButton() {
        String buttonContent = "<span class=\"glyphicon glyphicon-pencil\"></span> Edit";
        String buttonId = "btnEditReply";

        return createBasicButton(buttonContent, buttonId, "javascript:;", null, false);
    }

    //create delete reply button
    private ElementTag createDeleteReplyButton() {
        String buttonContent = "<span class=\"glyphicon glyphicon-trash\"></span> Delete";
        String buttonId = "btnDeleteReply";
        String href = getReplyBoardDeleteLink(topic.getId(), reply.getId().toString());

        ElementTag button = createBasicButton(buttonContent, buttonId, href, null, false);
        button.setAttribute("data-topicname", topic.getName());
        String existingClasses = button.removeAttribute("class");
        button.setAttribute("class", existingClasses + " topic_delete_");

        return button;
    }

    //GETTERS 
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

    public ElementTag getDeleteReplyButton() {
        return deleteReplyButton;
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
