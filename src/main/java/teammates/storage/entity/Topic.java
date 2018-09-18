package teammates.storage.entity;

import java.time.Instant;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import teammates.common.util.Const;
import teammates.common.util.TimeHelper;

/**
 * Represents a topic entity.
 */
@Entity
@Index
public class Topic extends BaseEntity {

    /**
     * It is a must to set the @Id for the entity, thus GAE can use it to access database
     */
    @Id
    private String topicID;
    private String name;
    private String desc;

    @SuppressWarnings("unused")
   private Topic(){
       // required by Objectify
   }

    public Topic(String id,String name, String desc) {
        this.topicID = id;
        this.setName(name);
        this.setDesc(desc);
    }

   
    private void setDesc(String desc) {
        this.desc = desc;
        
    }

    
    public String getDesc() 
    {
        return desc;
    }
    
    public String getId() {
        return topicID;
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
   
}
