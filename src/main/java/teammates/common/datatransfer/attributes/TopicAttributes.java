package teammates.common.datatransfer.attributes;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import teammates.common.datatransfer.attributes.CourseAttributes.Builder;
import teammates.common.util.Assumption;
import teammates.common.util.JsonUtils;
import teammates.common.util.SanitizationHelper;
import teammates.common.util.TimeHelper;
import teammates.storage.entity.Course;
import teammates.storage.entity.Topic;

public class TopicAttributes extends EntityAttributes<Topic> {
  
  public String name;
  public String desc;
 
  public Instant createdAt;
  
  public TopicAttributes(String name, String desc) {
      this.name = SanitizationHelper.sanitizeTitle(name);
      this.desc = SanitizationHelper.sanitizeTitle(desc);
      this.createdAt = Instant.now();
  }
  
 


public static Builder builder(String name, String desc) {
      return new Builder(name, desc);
  }
  
  
  
   public String getName() {
      return name;
    }
  
   
   public String getDesc() {
     return desc;
   }
   
 

  @Override
  public List<String> getInvalidityInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Topic toEntity() {
      return new Topic(getName(), getDesc(), createdAt);
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
    // TODO Auto-generated method stub
    
  }
  

  public String getCreatedAtDateStamp() {
      return TimeHelper.formatDateTimeToIso8601Utc(createdAt);
  }
  
  

  
  
  

public static class Builder {
    private static final String REQUIRED_FIELD_CANNOT_BE_NULL = "Non-null value expected";
    private final TopicAttributes topicAttributes;

    public Builder(String name, String desc) {
        validateRequiredFields(name, desc);
        topicAttributes = new TopicAttributes(name, desc);
    }

    public Builder withCreatedAt(Instant createdAt) {
        if (createdAt != null) {
            topicAttributes.createdAt = createdAt;
        }

        return this;
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

