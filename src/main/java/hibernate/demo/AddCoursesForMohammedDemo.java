package hibernate.demo;

import demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForMohammedDemo {

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

            int theId = 2;
            Student tempStudent = session.get(Student.class, theId);

            System.out.println("Student : " + tempStudent);
            System.out.println("Corses for "+ tempStudent +" : " +tempStudent.getCourses());

            Course tempCourse1 = new Course("Robic - How to speed up");
            Course tempCourse2 = new Course("Elon Musk - How to go to space");

            tempCourse1.addStudents(tempStudent);
            tempCourse2.addStudents(tempStudent);

            System.out.println("Saving the courses ...");
            session.save(tempCourse1);
            session.save(tempCourse2);

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
