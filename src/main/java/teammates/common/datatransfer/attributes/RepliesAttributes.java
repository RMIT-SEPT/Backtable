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
  private String dateTime;

  private Integer like;
  private Integer dislike;

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

  public String getDesc() {
    return desc;
  }
  public String getStudent() {
    return studentName;
  }
  
  public RepliesAttributes(String desc, String studentName, Integer count, String dateTime,Integer like, Integer dislike)
  {
    this.desc = desc;
    this.studentName = studentName;
    this.id = count;
    this.dateTime = dateTime;
    this.setLike(like);
    this.setDislike(dislike);
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
  
  public String getDateTime() {
    return dateTime;
  }
  
  public void setDesc(String desc)
  {
      this.desc = desc;
  }
  
  @Override
  public Reply toEntity() {
    // TODO Auto-generated method stub
    return new Reply(getDesc(), getStudent(), getId(), getDateTime(),getLike(),getDislike());
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
