package refactor_jdbc_review.template.handler;


import refactor_jdbc_review.template.handler.IResultSetHandlerStandard;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultSetHandler<T> implements IResultSetHandlerStandard<List<T>> {

    Class<T> clazz = null;

    @Override
    public List<T> deal(ResultSet set){


        //存储 对象
        List<T> list = new ArrayList<>();

        try{

            while(set.next()){

                //实例化对象
                T instance = clazz.newInstance();

                BeanInfo instrospector = Introspector.getBeanInfo(clazz,Object.class);

                //获取属性描述器数组
                PropertyDescriptor[] descriptor =  instrospector.getPropertyDescriptors();

                for(int i=0;i<descriptor.length;i++){



                    //通过introspector拿到对象字段,通过字段获取表中相同名字字段的数据
                    String name = descriptor[i].getName();

                    //获取set集合中的数据,并保存到对象中
                    descriptor[i].getWriteMethod().invoke(instance,set.getObject(name));

                }
//                将对象存入List集合
                list.add(instance);
            }

            return list;

        }catch(Exception e){

            e.printStackTrace();

        }

        return null;
    }


    public ResultSetHandler(Class<T> clazz){

        this.clazz = clazz;

    }


}
