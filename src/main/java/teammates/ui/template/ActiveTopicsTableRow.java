package teammates.ui.template;

import java.util.List;

public class ActiveTopicsTableRow {
    private String topicId;
    private String topicName;
    private String createdAtDateString;
    private String createdAtDateStamp;
    private String createdAtFullDateTimeString;
    private String href;
    private List<ElementTag> actions;

    public ActiveTopicsTableRow(String topicIdParam, String topicNameParam,
                                 String createdAtDateStringParam, String createdAtDateStampParam,
                                 List<ElementTag> actionsParam) {
        this.topicId = topicIdParam;
        this.topicName = topicNameParam;
        this.createdAtDateString = createdAtDateStringParam;
        this.createdAtDateStamp = createdAtDateStampParam;
        this.href = href;
        this.actions = actionsParam;
    }

    public String getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getCreatedAtDateString() {
        return createdAtDateString;
    }

    public String getCreatedAtDateStamp() {
        return createdAtDateStamp;
    }

    public String getCreatedAtFullDateTimeString() {
        return createdAtFullDateTimeString;
    }

    public String getHref() {
        return href;
    }

    public List<ElementTag> getActions() {
        return actions;
    }

}
