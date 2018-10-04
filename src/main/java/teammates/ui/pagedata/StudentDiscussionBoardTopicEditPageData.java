package teammates.ui.pagedata;

import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.ui.template.ElementTag;

public class StudentDiscussionBoardTopicEditPageData extends PageData {
    private TopicAttributes topic;
    private Integer count;
    private ElementTag editTopicButton;
    private ElementTag deleteTopicButton;

    public StudentDiscussionBoardTopicEditPageData(AccountAttributes account, String sessionToken, TopicAttributes topic, Integer count) {
      super(account, sessionToken);
      this.topic = topic;
      this.count = count;

      createTopicRelatedButtons();
    }

    private void createTopicRelatedButtons() {
        editTopicButton = createEditTopicButton();
        deleteTopicButton = createDeleteTopicButton();
    }

    public TopicAttributes getTopic() {
      return topic;
    }

    public ElementTag getEditTopicButton() {
        return editTopicButton;
    }

    public ElementTag getDeleteTopicButton() {
        return deleteTopicButton;
    }

    private ElementTag createEditTopicButton() {
        String buttonContent = "<span class=\"glyphicon glyphicon-pencil\"></span> Edit";
        String buttonId = "btnEditTopic";

        return createBasicButton(buttonContent, buttonId, "javascript:;", null, false);
    }

    private ElementTag createDeleteTopicButton() {
        String buttonContent = "<span class=\"glyphicon glyphicon-trash\"></span> Delete";
        String buttonId = "btnDeleteTopic";
        String href = getDiscussionBoardDeleteLink(topic.getName(), topic.getId());

        ElementTag button = createBasicButton(buttonContent, buttonId, href, null, false);
        button.setAttribute("data-topicname", topic.getName());
        String existingClasses = button.removeAttribute("class");
        button.setAttribute("class", existingClasses + " topic_delete_");

        return button;
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
