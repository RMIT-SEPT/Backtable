package teammates.ui.pagedata;

import teammates.common.util.Const;
import teammates.logic.api.Logic;
import teammates.ui.template.ActiveTopicsTable;
import teammates.ui.template.ActiveTopicsTableRow;
import teammates.ui.template.ElementTag;
import teammates.ui.template.RepliesDiv;

import java.util.ArrayList;
import java.util.List;

import teammates.common.datatransfer.CourseDetailsBundle;
import teammates.common.datatransfer.TeamDetailsBundle;
import teammates.common.datatransfer.TopicDetailsBundle;
import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.datatransfer.attributes.InstructorAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.StudentAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;

public class StudentRepliesBoardPageData extends PageData {
   
  public TopicAttributes topic;
  public ArrayList<RepliesDiv> replies;
  public Integer count;

    public Integer getViewcount() {
        return viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public Integer viewcount;


    public void setTopic(TopicAttributes topic) {
        this.topic = topic;
    }

    public void setReplies(ArrayList<RepliesDiv> replies) {
        this.replies = replies;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public StudentRepliesBoardPageData(AccountAttributes account, String sessionToken) {
    super(account, sessionToken);
  }
  
  public void init(TopicAttributes topic) {
      this.topic = topic;
      if(topic.getReplies() != null)
      {
          replies = new ArrayList<RepliesDiv>();
          convertReplies(topic.getReplies());
      }
      this.count = topic.getCount();
      this.viewcount = topic.getViewCounter();

  }
  
  public ArrayList<RepliesDiv> getReplies()
  {
      return replies;
  }
  
  public String getDesc() {
      return topic.getDesc();
  }
  
  public String getName() {
      return topic.getName();
  }

    public String getID() {
        return topic.getId();
    }


    public TopicAttributes getTopic() {
        return topic;
    }

    private void convertReplies(List<RepliesAttributes> replies) {

        int idx = -1;
        
        for (RepliesAttributes reply : replies) {
          idx++;

          List<ElementTag> actionsParam = new ArrayList<>();

          ElementTag editButton = createButton("Edit Reply", "btn btn-warning reply_edit",
                                               getReplyBoardEditLink(topic.getId(), reply.getId().toString()),
                                               Const.Tooltips.REPLY_EDIT, false);
       
          actionsParam.add(editButton);
          
          this.replies.add(new RepliesDiv(reply.getStudent(), reply.getId().toString(), reply.getDesc(), actionsParam, reply.getDateTime()));

        }
    }
    
    private ElementTag createButton(String content, String buttonClass, String href, String title,
            boolean isDisabled) {
        ElementTag button = new ElementTag(content);

        button.setAttribute("class", buttonClass);
        
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
