package teammates.ui.template;

import java.util.List;

public class ArchivedTopicsTableRow {
    private String topicId;
    private String topicName;
    private String createdAtDateString;
    private String createdAtDateStamp;
    private String createdAtFullDateTimeString;
    private List<ElementTag> actions;

    public ArchivedTopicsTableRow(String topicIdParam, String topicNameParam,
            String createdAtDateStringParam, String createdAtDateStampParam,
            String createdAtFullDateTimeStringParam, List<ElementTag> actionsParam) {
        this.topicId = topicIdParam;
        this.topicName = topicNameParam;
        this.createdAtDateString = createdAtDateStringParam;
        this.createdAtDateStamp = createdAtDateStampParam;
        this.createdAtFullDateTimeString = createdAtFullDateTimeStringParam;
        this.actions = actionsParam;
    }

    public String getCourseId() {
        return topicId;
    }

    public String getCourseName() {
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

    public List<ElementTag> getActions() {
        return actions;
    }
}
