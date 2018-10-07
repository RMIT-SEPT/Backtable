package teammates.ui.pagedata;

import teammates.common.util.Const;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.ui.template.ActiveTopicsTable;
import teammates.ui.template.ActiveTopicsTableRow;
import teammates.ui.template.ElementTag;


/**
 * This is the PageData object for the 'Discussion Board Topics' page.
 */


public class StudentDiscussionBoardPageData extends PageData {

  //***********************ATTRIBUTES*************************************//

    private boolean isUsingAjax;
    private ActiveTopicsTable activeTopics;
    private String topicNameToShow;
    private String topicDescToShow;
    //***********************CONSTRUCTOR*************************************//


    public StudentDiscussionBoardPageData(AccountAttributes account, String sessionToken) {
        super(account, sessionToken);
    }

    public String getName() {
        return topicNameToShow;
    }

    public String getDesc() {
        return topicDescToShow;
    }

    public void init(List<TopicAttributes> activeTopicsParam) {
        this.activeTopics = convertToActiveTopicsTable(activeTopicsParam);
    }

    public void init(List<TopicAttributes> activeTopicsParam, String topicNameToShowParam, String topicDescToShowParam) {
        this.activeTopics = convertToActiveTopicsTable(activeTopicsParam);
        this.topicNameToShow = topicNameToShowParam;
        this.topicDescToShow = topicDescToShowParam;
    }

    public void setUsingAjax(boolean isUsingAjax) {
    this.isUsingAjax = isUsingAjax;
    }

    public boolean isUsingAjax() {
    return this.isUsingAjax;
    }

    public String getTopicDescToShow() {
    return topicDescToShow;
    }

    public String getTopicNameToShow() {
    return topicNameToShow;
    }

    public ActiveTopicsTable getActiveTopics() {
    return activeTopics;
    }

    /**
    * Convert TopicAttribute to ActiveTopicsTable for front-end purposes
    * Each TopicAttributes will be converted into ActiveTopicsTableRow which is one of elements of  ActiveTopicsTable
    * @param topics List of TopicAttribute from database
    * @return ActiveTopicsTable
    */

    private ActiveTopicsTable convertToActiveTopicsTable(List<TopicAttributes> topics) {
        ActiveTopicsTable activeTopics = new ActiveTopicsTable();

        int idx = -1;

        for (TopicAttributes topic : topics) {
          idx++;

          List<ElementTag> actionsParam = new ArrayList<>();

          ElementTag viewButton = createButton("View", "btn btn-xs btn-default topic_view" + idx, "",
                                               getDiscussionBoardDetailsLink(topic.getName(), topic.getId()),
                                               Const.Tooltips.TOPIC_DETAILS, false);
          ElementTag editButton = createButton("Edit", "btn btn-xs btn-default topic_edit" + idx, "",
                                               getDiscussionBoardEditLink(topic.getName(), topic.getId()),
                                               Const.Tooltips.TOPIC_EDIT, false);
          ElementTag deleteButton = createButton("Delete", "btn btn-xs btn-default topic_delete_ topic_delete" + idx, "",
                  getDiscussionBoardDeleteLink(topic.getName(), topic.getId()),
                  Const.Tooltips.TOPIC_DELETE, false);
          deleteButton.setAttribute("data-topicname", topic.getName());
          actionsParam.add(viewButton);
          actionsParam.add(editButton);
          actionsParam.add(deleteButton);

          ActiveTopicsTableRow row = new ActiveTopicsTableRow(topic.getId(), topic.getCreator(), sanitizeForHtml(topic.getName()),sanitizeForHtml(topic.getDesc()),actionsParam);
          activeTopics.getRows().add(row);
        }
        return activeTopics;
    }

    //Create button method
    private ElementTag createButton(String content, String buttonClass, String id, String href, String title,
                              boolean isDisabled) {
        ElementTag button = new ElementTag(content);

        button.setAttribute("class", buttonClass);

        if (id != null && !id.isEmpty()) {
          button.setAttribute("id", id);
        }

        if (href != null && !href.isEmpty()) {
          button.setAttribute("href", href);
        }

        if (title != null && !title.isEmpty()) {
          button.setAttribute("title", title);
          button.setAttribute("data-toggle", "tooltip");
          button.setAttribute("data-placement", "top");
        }

        if (isDisabled) {
          button.setAttribute("disabled", null);
        }
        return button;
    }
}
