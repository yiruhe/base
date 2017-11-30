package com.dao_demo.test;

import org.junit.Test;
import com.dao_demo.domain.StudentDemo;
import com.dao_demo.dao.implement.StudentImplementDemo;
import java.util.List;


public class TestDemo {



    @Test
    public void testSave(){

      //  new StudentImplementDemo().save(new StudentDemo(3,"小白","语文",60));

//        new StudentImplementDemo().delete(3);

//        new StudentImplementDemo().update(new StudentDemo(1,"小可","语文",70));

//        StudentDemo student =  new StudentImplementDemo().getStudentInformation(1);

//        System.out.println(student);

        List<StudentDemo> studentArray =  new StudentImplementDemo().getStudentInformationArray();

        System.out.println(studentArray);
    }

}
