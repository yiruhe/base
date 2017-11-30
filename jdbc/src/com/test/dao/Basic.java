package com.test.dao;


import org.junit.Test;

public class Basic {



    @Test
    public void  test(){

        //DAO 的设计规范:
//        DAO组件包含DAO接口和DAO实现类以及DAO测试类
//                分包规范:
//        package 域名倒写.模块名称.组件名

        //domain : 封装sql信息的对象,是中转站

//        com.**.***.domain 存储domain 文件
//        com.**.***.dao 存储dao接口文件
//        com.**.***.dao.implement 存储 dao implement 文件
//        com.**.***.test  test 文件

        //起名规范:
//            domain类: describe instance ,用英文表示 example: employee
//            DAO interface: IXxxDAO   example: IEmployeeDAO
//            DAO implement: xxxDAOImplement
//            DAO  test: 根据DAO接口生成测试类:xxxDAOTest EmployeeDAOTest

        //create DAO instance standardize:
//            1.DAO对象起名,统统叫做xxxDAO
//             2.面对接口编程
//            IEmployeeDAO employeeDAO = new EmployeeDAOImplement();

        //接口要提供文档注释

//        PreparedStatement 最重要的一点好处是它拥有更佳的性能优势，
//        SQL语句会预编译在数据库系统中。执行计划同样会被缓存起来，它允许数据库做参数化查询。
//        使用预处理语句比普通的查询更快，因为它做的工作更少（数据库对SQL语句的分析，编译，优化已经在第一次查询前完成了）





    }


}
