package teammates.storage.entity;

import java.time.Instant;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import teammates.common.util.Const;
import teammates.common.util.TimeHelper;

/**
 * Represents a course entity.
 */
@Entity
@Index
public class Topic extends BaseEntity {

    private String name;
    private String desc;
    private Date createdAt;
    

   

    public Topic(String name, String desc, Instant createdAt) {
       // this.setUniqueId(topic);
        this.setName(name);
        this.setDesc(desc);
        if (createdAt == null) {
            this.setCreatedAt(Instant.now());
        } else {
            this.setCreatedAt(createdAt);
        }
    }

   
    private void setDesc(String desc) {
        this.desc = desc;
        
    }

    
    private String getDesc() 
    {
        return desc;
    }
    /*public String getUniqueId() {
        return id;
    }

    public void setUniqueId(String uniqueId) {
        this.id = uniqueId.trim();
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public Instant getCreatedAt() {
        return TimeHelper.convertDateToInstant(this.createdAt);
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = TimeHelper.convertInstantToDate(createdAt);
    }

   
}
