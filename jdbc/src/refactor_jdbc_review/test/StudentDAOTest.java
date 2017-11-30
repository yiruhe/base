package refactor_jdbc_review.test;


import org.junit.Test;
import refactor_jdbc_review.dao.implement.StudentDAOImplement;
import refactor_jdbc_review.domian.Student;

public class StudentDAOTest {


    @Test
    public void test(){


//        new StudentDAOImplement().save(new Student("mali","chinese",60));


        System.out.println(new StudentDAOImplement().queryStudentList());



    }
}
