package hibernate.demo;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {

            //start a transaction
            session.beginTransaction();

            Course tempCourse = new Course("How to get money fast");

            tempCourse.addReview(new Review("Great Course, I Love it"));
            tempCourse.addReview(new Review("Best Course"));
            tempCourse.addReview(new Review("What is that course"));
            tempCourse.addReview(new Review("Good, Well Done"));

            System.out.println("Saving the course : " + tempCourse);
            System.out.println("Reviews : " + tempCourse.getReviews());
            session.save(tempCourse);

            //commit the transaction
            session.getTransaction().commit();


            System.out.println("Done ..!!!.. ");
        }
        finally {
            session.close();
            factory.close();
        }

    }

}
