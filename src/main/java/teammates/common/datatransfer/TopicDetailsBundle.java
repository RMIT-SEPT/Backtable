package teammates.common.datatransfer;

import java.util.ArrayList;
import java.util.List;

import teammates.common.datatransfer.attributes.CourseAttributes;
import teammates.common.datatransfer.attributes.FeedbackSessionAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.SanitizationHelper;

public class TopicDetailsBundle {
  
    public TopicAttributes topic;
    public List<RepliesAttributes> replies = new ArrayList<>();
   // public String basicSentence;
    
    public TopicDetailsBundle(TopicAttributes topicData)
    {
      this.topic = topicData;
     /* this.topic = TopicAttributes
              .builder(SanitizationHelper.desanitizeIfHtmlSanitized(topicData.getName()),
                      SanitizationHelper.desanitizeIfHtmlSanitized(topicData.getDesc()),
                      topicData.getTimeZone())
              .build();
          this.topic.createdAt = topicData.createdAt;*/
      
     }
    
    public TopicAttributes getTopic()
    {
      return topic;
    }
    
    /*public String getBasicSentence() {
      System.out.println("get basic sentence has been called");
      //return basicSentence;
    }*/
}
