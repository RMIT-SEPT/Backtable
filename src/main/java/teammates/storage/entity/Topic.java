package teammates.storage.entity;

import java.time.Instant;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import teammates.common.util.Const;
import teammates.common.util.TimeHelper;

@Entity
@Index
public class Topic extends BaseEntity {
  @Id
  private String id;
  private String desc;
  private String studentName;
  
  // TODO: change to `java.time.Instant` once we have upgraded to Objectify 6
  private Date createdAt;
  
  public Topic(String id, String desc, String studentName, Instant createdAt) {
    this.setUniqueId(id);
    this.setDesc(desc);
    this.setStudentName(studentName);
    if (createdAt == null) {
        this.setCreatedAt(Instant.now());
    } else {
        this.setCreatedAt(createdAt);
    }
}
  public void setUniqueId(String uniqueId) {
    this.id = uniqueId.trim();
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
