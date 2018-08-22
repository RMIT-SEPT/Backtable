package teammates.common.datatransfer.attributes;

import java.time.Instant;
import java.util.List;

import teammates.storage.entity.Reply;
import teammates.storage.entity.Topic;

public class RepliesAttributes extends EntityAttributes<Reply> {

  public Instant createdAt;
  private String desc;
  private String studentName;
  
  public String getDesc() {
    return desc;
  }
  public String getStudent() {
    return studentName;
  }
  
  RepliesAttributes(String desc, String studentName)
  {
    this.desc = desc;
    this.studentName = studentName;
  }
  @Override
  public List<String> getInvalidityInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Reply toEntity() {
    // TODO Auto-generated method stub
    return new Reply(getDesc(), getStudent(), createdAt);
  }

  @Override
  public String getIdentificationString() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getEntityTypeAsString() {
    // TODO Auto-generated method stub
    return "Reply";
  }

  @Override
  public String getBackupIdentifier() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getJsonString() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void sanitizeForSaving() {
    // TODO Auto-generated method stub
    
  }

}
