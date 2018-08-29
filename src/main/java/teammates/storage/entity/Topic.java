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

    @Id
    private String id;

    private String name;

    // TODO: change to `java.time.Instant` once we have upgraded to Objectify 6
    private Date createdAt;

    private String timeZone;

    @SuppressWarnings("unused")
    private Topic() {
        // required by Objectify
    }

    public Topic(String topicId, String topicName, String topicTimeZone, Instant createdAt) {
        this.setUniqueId(topicId);
        this.setName(topicName);
        if (topicTimeZone == null) {
            this.setTimeZone(Const.DEFAULT_TIME_ZONE.getId());
        } else {
            this.setTimeZone(topicTimeZone);
        }
        if (createdAt == null) {
            this.setCreatedAt(Instant.now());
        } else {
            this.setCreatedAt(createdAt);
        }
    }

    public String getUniqueId() {
        return id;
    }

    public void setUniqueId(String uniqueId) {
        this.id = uniqueId.trim();
    }

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

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
