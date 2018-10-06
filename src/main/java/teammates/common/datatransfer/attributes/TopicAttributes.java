package teammates.common.datatransfer.attributes;

import java.util.ArrayList;
import java.util.List;

import teammates.common.util.FieldValidator;
import teammates.common.util.JsonUtils;
import teammates.common.util.SanitizationHelper;
import teammates.storage.entity.Reply;
import teammates.storage.entity.Topic;

public class TopicAttributes extends EntityAttributes<Topic> {

  /* Variable declarations */  
  public String id;
  public String creator;
  public String name;
  public String desc;
  public Integer count;
  public Integer viewCounter;
  public ArrayList<RepliesAttributes> replies;

  /* TopicAttributes constructor */
  public TopicAttributes(String topicID, String creator, String name, String desc, ArrayList<RepliesAttributes> replies, Integer count, Integer viewCounter) {
      this.id = SanitizationHelper.sanitizeTitle(topicID);
      this.creator = SanitizationHelper.sanitizeTitle(creator);
      this.name = SanitizationHelper.sanitizeTitle(name);
      this.desc = SanitizationHelper.sanitizeTitle(desc);
      this.replies = replies;
      this.count = count;
      this.viewCounter = viewCounter;
  }

  /*Builder is used as a constructor to initiate new instance of TopicAttribute*/
  public static Builder builder(String topicID, String creator, String name, String desc, ArrayList<Reply> replies, Integer count,Integer viewCounter) {
      return new Builder(topicID, creator, name, desc, replies, count,viewCounter);
  }
  
  /* Getters */
  
  public Integer getViewCounter() {
      return viewCounter;
  }
  
  public String getId() {
      return id;
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
  
    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<RepliesAttributes> getReplies(){
        return replies;
    }
    
    public Integer getCount()    {
        return count;
    }
    

    /* Setters */
    
    public void setViewCounter(Integer viewCounter) {
        this.viewCounter = viewCounter;
    }
 
    public void setReplies(ArrayList<RepliesAttributes> replies)
    {
        this.replies = replies;
    }
  
    
    /* Function to add a reply to the topic count iterated as it is used as partial key to identify reply*/
    public void addReply(RepliesAttributes reply)
    {
        if(replies == null)
        {
           replies = new ArrayList<RepliesAttributes>();
        }
        replies.add(reply);
        count++;
    }
   
    /* Used to validate strings stored in topic */
    @Override
    public List<String> getInvalidityInfo() { FieldValidator validator = new FieldValidator();
          List<String> errors = new ArrayList<>();
          addNonEmptyError(validator.getInvalidityInfoForCourseName(getName()), errors);
          return errors;
    }

     /* returns object Topic representing this TopicAttributes, will then be able to be stored in database */
     @Override
     public Topic toEntity() {
        ArrayList<Reply> repliesEntity = new ArrayList<Reply>();
        if(getReplies() != null)
        {
           for(RepliesAttributes replyAtt: getReplies())
           {
               repliesEntity.add(replyAtt.toEntity());
           }
        }
        return new Topic(getId(), getCreator(), getName(), getDesc(), repliesEntity, count,viewCounter);
      }
  
      /* Inherited methods, not all necessary for our functionality */
      @Override
      public String getIdentificationString() {
        return null;
      }
    
      @Override
      public String getEntityTypeAsString() {
        return "Topic";
      }
    
      @Override
      public String getBackupIdentifier() {
        return null;
      }
    
      @Override
      public String getJsonString() {
        return JsonUtils.toJson(this, TopicAttributes.class);
      }
    
      @Override
      public void sanitizeForSaving() {
      }
    
      /* Takes ArrayList of Reply entities, returns array of RepliesAttributes */
      /* Required in order to take objects from database and build them back up to a usable state */
      public static ArrayList<RepliesAttributes> getRepliesAtt(ArrayList<Reply> replies)
      {
        if(replies != null)
        {
          ArrayList<RepliesAttributes> repliesAtt = new ArrayList<RepliesAttributes>();
          for(Reply reply:replies)
          {
            repliesAtt.add(new RepliesAttributes(reply.getDesc(), reply.getStudentName(), reply.getId(), reply.getDateTime(),reply.getLike(),reply.getDislike()));
          }      
          return repliesAtt;
        }
        return null;
      }
      
      public void removeReply(RepliesAttributes reply)
      {
          replies.remove(reply);
      }
      
      /* Calls above method, is used to return a TopicAttributes instance based on a Topic entity in database */
      public static class Builder {
         private final TopicAttributes topicAttributes;
            
         public Builder(String topicID, String creator, String name, String desc, ArrayList<Reply> replies, Integer count,Integer viewCounter) {
             ArrayList<RepliesAttributes> repliesAtt = getRepliesAtt(replies);
             topicAttributes = new TopicAttributes(topicID, creator, name, desc, repliesAtt, count,viewCounter);
         }
    
         public TopicAttributes build() {
             return topicAttributes;
         }
    }
}
