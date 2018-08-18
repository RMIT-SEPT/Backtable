package teammates.common.datatransfer.attributes;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import teammates.common.util.JsonUtils;
import teammates.common.util.SanitizationHelper;
import teammates.storage.entity.Course;
import teammates.storage.entity.Topic;

public class TopicAttributes extends EntityAttributes<Topic> {
  
  public Instant createdAt;
  public String id;
  public String desc;
  public String studentName;
  
  public TopicAttributes(String id, String desc, String studentName) {
    this.id = SanitizationHelper.sanitizeTitle(id);
    this.desc = SanitizationHelper.sanitizeTitle(desc);
    this.studentName = SanitizationHelper.sanitizeTitle(studentName);
    this.createdAt = Instant.now();
}
  
   public String getId() {
     System.out.println("get id has been called = " + id);
     return id;
   }
   public String getDesc() {
     return desc;
   }
   public String getName() {
     return studentName;
 }
   

  @Override
  public List<String> getInvalidityInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Topic toEntity() {
    // TODO Auto-generated method stub
    return new Topic(getId(), getDesc(), getName(), createdAt);
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
}
