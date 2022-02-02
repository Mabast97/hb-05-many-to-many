package JDBC;

import demo.entity.Student;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/?user=hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        Student s = new Student("Mabast", "Hashm", "M@gmail.com");

        System.out.println(s);

        try {
            System.out.println("Connecting to database: "+ jdbcUrl);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection Successfull !!!");

        }catch (Exception exc){
            exc.printStackTrace();
        }
    }



}
