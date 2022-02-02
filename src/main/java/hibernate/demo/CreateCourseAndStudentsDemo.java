package hibernate.demo;

import demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {

            //start a transaction
            session.beginTransaction();

            Course tempCourse = new Course("John - How to get money fast");

            System.out.println("Saving the course ... ");
            session.save(tempCourse);
            System.out.println("Course Saved : " + tempCourse);

            Student tempStudent1 = new Student("Ahmed", "Abdulxaliq", "Ahoo@gmail.com");
            Student tempStudent2 = new Student("Mohammed", "kareem", "Momo@gmail.com");

            tempCourse.addStudents(tempStudent1);
            tempCourse.addStudents(tempStudent2);

            System.out.println("Saving the students ...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Saved the students :  " + tempCourse.getStudents());

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
