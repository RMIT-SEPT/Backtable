package teammates.common.datatransfer.attributes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import teammates.storage.entity.Reply;
import teammates.storage.entity.Topic;

public class RepliesAttributes extends EntityAttributes<Reply> {

  public Instant createdAt;
  private String desc;
  private String studentName;
  public Integer id;
  
  public String getDesc() {
    return desc;
  }
  public String getStudent() {
    return studentName;
  }
  
  public RepliesAttributes(String desc, String studentName, Integer count)
  {
    this.desc = desc;
    this.studentName = studentName;
    this.id = count;
  }
  @Override
  public List<String> getInvalidityInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  public Integer getId()
  {
      return id;
  }
  
  public void setDesc(String desc)
  {
      this.desc = desc;
  }
  
  @Override
  public Reply toEntity() {
    // TODO Auto-generated method stub
    return new Reply(getDesc(), getStudent(), getId());
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
