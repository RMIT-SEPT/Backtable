package teammates.ui.template;

import java.util.List;

public class RepliesDiv {
    private String name;
    private String desc;
    private String id;
    private String dateTime;
    private Integer like;
    private Integer dislike;
    private String createdAtDateString;
    private String createdAtDateStamp;
    private String createdAtFullDateTimeString;
    
    
    private List<ElementTag> actions;

    public RepliesDiv(String name, String id, String desc, List<ElementTag> actionsParam, String dateTime, Integer like, Integer dislike) {
        
        this.name = name;
        this.desc = desc;
        this.id = id;
        this.actions = actionsParam;
        this.dateTime = dateTime;
        this.like = like;
        this.dislike = dislike;
    }

    public String getId() {
        return id;
    }

    public String getDateTime()
    {
      return dateTime;
    }
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
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


    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }
}
