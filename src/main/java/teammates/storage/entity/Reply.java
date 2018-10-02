package teammates.storage.entity;

import java.time.Instant;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import teammates.common.util.TimeHelper;

@Entity
public class Reply extends BaseEntity {
  @Id
  private String desc;
  private String studentName;
  private Integer id;
  private String dateTime;
  
  // TODO: change to `java.time.Instant` once we have upgraded to Objectify 6
  private Date createdAt;
  
  @SuppressWarnings("unused")
  private Reply(){
      // required by Objectify
  }
  
  public Reply(String desc, String studentName, Integer id, String dateTime) {
    this.setDesc(desc);
    this.setStudentName(studentName);
    this.setId(id);
    this.setDateTime(dateTime);
}
  public String getDesc() {
    return desc;
}
  public void setDesc(String desc) {
    this.desc = desc.trim();
}
  public Integer getId()
  {
      return id;
  }
  public String getDateTime()
  {
    return dateTime;
  }
  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }
  public void setId(Integer id)
  {
      this.id = id;
  }
  public String getStudentName() {
    return studentName;
}
  public void setStudentName(String studentName) {
    this.studentName = studentName.trim();
}
  
  public Instant getCreatedAt() {
    return TimeHelper.convertDateToInstant(this.createdAt);
}
  public void setCreatedAt(Instant createdAt) {
    this.createdAt = TimeHelper.convertInstantToDate(createdAt);
}
}
