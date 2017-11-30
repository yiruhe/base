package refactor_jdbc_review.dao;

import refactor_jdbc_review.domian.Student;

import java.util.List;

/**
 *
 */
public interface IStudentDAO {

    /**
     * 保存对象中的数据到数据库
     * @param student
     */
    public abstract void save(Student student);

    /**
     *
     *@param student
     */
    public abstract void update(Student student);


    /**
     * delete a student information
     * @param id int
     */
    public abstract void delete(int id);

    /**
     * 根据id查取student information
     * @param id int
     * @return Student object
     */
    public abstract Student queryStudent(int id);

    /**
     *取出 all information for student
     * @return List
     */
    public abstract List queryStudentList();
}
