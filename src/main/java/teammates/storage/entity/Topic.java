package teammates.storage.entity;

import java.util.ArrayList;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Represents a topic entity.
 */
@Entity
@Index
public class Topic extends BaseEntity {

    /**
     * Variables required for Topic saved as part of base entity
     * This includes an ArrayList of associated replies
     * @Id tag must be used to identify the key for GAE
     */
    @Id
    private String topicID;
    private String creator;
    private String name;
    private String desc;
    private Integer count;
    private Integer viewcount;
    private ArrayList<Reply> replies;

    /**
     * Unused constructor required for compilation
     */
    @SuppressWarnings("unused")
   private Topic(){
       // required by Objectify
   }

    /**
     * Constructor for Topic
     * @param id
     * @param creator
     * @param name
     * @param desc
     * @param replies
     * @param count
     * @param viewcount
     */
    public Topic(String id, String creator, String name, String desc, ArrayList<Reply> replies, Integer count,Integer viewcount) {
        this.topicID = id;
        this.creator = creator;
        this.setName(name);
        this.setDesc(desc);
        this.replies = replies;
        this.count = count;
        this.viewcount = viewcount;
    }
    
    /**
     * Getter methods
     */
    public String getId() {
        return topicID;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCreator() {
        return creator;
    }
    
    public Integer getCount()
    {
        return count;
    }
   
    public Integer getViewcount() {
        return viewcount;
    }
    
    public String getDesc() 
    {
        return desc;
    }
    
    public ArrayList<Reply> getReplies(){
        return replies;
    }

    /**
     * Setters
     */
    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    private void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCreator(String Creator) {
        this.creator = creator.trim();
    }
    
    public void setName(String name) {
        this.name = name.trim();
    }
    


    
   
}
