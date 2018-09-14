package teammates.common.datatransfer.attributes;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import teammates.common.util.Assumption;
import teammates.common.util.FieldValidator;
import teammates.common.util.JsonUtils;
import teammates.common.util.SanitizationHelper;
import teammates.storage.entity.Topic;

public class TopicAttributes extends EntityAttributes<Topic> {
  
  public String id;
  public String name;
  public String desc;
  public List<RepliesAttributes> replies;
  public TopicAttributes(String topicID, String name, String desc) {
      
      this.id = SanitizationHelper.sanitizeTitle(topicID);
      this.name = SanitizationHelper.sanitizeTitle(name);
      this.desc = SanitizationHelper.sanitizeTitle(desc);
  }
  
/*Builder is used as a constructor to initiate instance of TopicAttribute*/
public static Builder builder(String topicID, String name, String desc) {
      return new Builder(topicID, name, desc);

  }
  
  public String getId() {
      return id;
  }
 
   public String getName() {
      return name;
    }
  
   

   public String getDesc() {
     return desc;
   }
   
 

  @Override
  public List<String> getInvalidityInfo() { FieldValidator validator = new FieldValidator();
      List<String> errors = new ArrayList<>();
      
      addNonEmptyError(validator.getInvalidityInfoForCourseName(getName()), errors);

      return errors;
  }

  @Override
  public Topic toEntity() {
      return new Topic(getId(), getName(), getDesc());
  }

  @Override
  public String getIdentificationString() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getEntityTypeAsString() {
    // TODO Auto-generated method stub
    return "Topic";
  }

  @Override
  public String getBackupIdentifier() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getJsonString() {
    // TODO Auto-generated method stub
    return JsonUtils.toJson(this, TopicAttributes.class);
  }

  @Override
  public void sanitizeForSaving() {
    
    
  }


  
  
  

public static class Builder {
    private static final String REQUIRED_FIELD_CANNOT_BE_NULL = "Non-null value expected";
    private final TopicAttributes topicAttributes;

    public Builder(String topicID, String name, String desc) {
       // validateRequiredFields(name, desc);
        topicAttributes = new TopicAttributes(topicID, name, desc);
    }

    
    

    public TopicAttributes build() {
        return topicAttributes;
    }

    private void validateRequiredFields(Object... objects) {
        for (Object object : objects) {
            Assumption.assertNotNull(REQUIRED_FIELD_CANNOT_BE_NULL, object);
        }
    }    
}

}
