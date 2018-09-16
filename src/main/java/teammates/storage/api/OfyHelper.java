package teammates.storage.api;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;

import teammates.storage.entity.*;

/**
 * Setup in web.xml to register Objectify at application startup.
 **/
public class OfyHelper implements ServletContextListener {

    /**
     * Register entity classes in Objectify service.
     */
    public static void registerEntityClasses() {
        ObjectifyService.register(Account.class);
        ObjectifyService.register(AdminEmail.class);
        ObjectifyService.register(Course.class);
        ObjectifyService.register(CourseStudent.class);
        ObjectifyService.register(FeedbackQuestion.class);
        ObjectifyService.register(FeedbackResponse.class);
        ObjectifyService.register(FeedbackResponseComment.class);
        ObjectifyService.register(FeedbackSession.class);
        ObjectifyService.register(Instructor.class);
        ObjectifyService.register(StudentProfile.class);
        ObjectifyService.register(Topic.class);
        ObjectifyService.register(Reply.class);
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // Invoked by GAE at application startup.
        registerEntityClasses();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // GAE does not currently invoke this method.
    }
}
