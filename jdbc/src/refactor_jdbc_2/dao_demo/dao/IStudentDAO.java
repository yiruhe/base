package refactor_jdbc_2.dao_demo.dao;

import refactor_jdbc_2.dao_demo.domain.StudentDemo;

import java.util.List;


public interface IStudentDAO {


    //不能写静态函数

    /**
     *保存student中的数据到数据库中
     * @param student
     * @since  1.0
     */
    public abstract void save(StudentDemo student);


    /**
     *根据id删除数据库中相应的数据
     * @param id
     *
     * @since 1.0
     */
    public abstract void delete(Integer id);

    /**
     *修改数据库中相应的数据
     * @param student
     * @since 1.0
     */
    public abstract void update(StudentDemo student);

    /**
     *
     * 根据id获取对应的student information
     * @param id
     * @author jame
     * @since 1.0
     */
    public abstract StudentDemo getStudentInformation(Integer id);


    public abstract List getStudentInformationArray();



}
