package teammates.storage.entity;

import java.time.Instant;
import java.util.Date;

import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import teammates.common.util.TimeHelper;

public class Reply extends BaseEntity {
  @Id
  private String desc;
  private String studentName;
  
  // TODO: change to `java.time.Instant` once we have upgraded to Objectify 6
  private Date createdAt;
  
  public Reply(String desc, String studentName, Instant createdAt) {
    this.setDesc(desc);
    this.setStudentName(studentName);
    if (createdAt == null) {
        this.setCreatedAt(Instant.now());
    } else {
        this.setCreatedAt(createdAt);
    }
}
  public String getDesc() {
    return desc;
}
  public void setDesc(String desc) {
    this.desc = desc.trim();
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
