package teammates.common.datatransfer;

import java.util.ArrayList;
import java.util.List;

import teammates.common.datatransfer.attributes.FeedbackSessionAttributes;
import teammates.common.datatransfer.attributes.RepliesAttributes;
import teammates.common.datatransfer.attributes.TopicAttributes;

public class TopicDetailsBundle {
  
    public TopicAttributes topic;
    public List<RepliesAttributes> replies = new ArrayList<>();
    public String basicSentence;
    
    public TopicDetailsBundle(TopicAttributes topicData)
    {
      this.topic = topicData;
      this.basicSentence = new String("sentenceHere");
    }
    
    public TopicAttributes getTopic()
    {
      return topic;
    }
    
    public String getBasicSentence() {
      System.out.println("get basic sentence has been called");
      return basicSentence;
    }
}
