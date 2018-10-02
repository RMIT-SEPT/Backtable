package teammates.ui.template;

import java.util.List;

public class ActiveTopicsTableRow {
    private String name;
    private String creator;
    private String desc;
    private String href;
    private String id;
    private List<ElementTag> actions;

    public ActiveTopicsTableRow(String id, String creator, String name, String desc,
                                 List<ElementTag> actionsParam) {
        this.id = id;
        this.creator = creator;
        this.name = name;
        this.desc = desc;
        this.href = href;
        this.actions = actionsParam;
    }

    public String getName() {
        return name;
    }

    public String getCreator() {
        return creator;
    }
    
    public String getDesc() {
        return desc;
    }

    public String getHref() {
        return href;
    }

    public List<ElementTag> getActions() {
        return actions;
    }
    public String getId()
    {
      return id;
    }

}
