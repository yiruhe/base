package refactor_jdbc_2.template;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * deal JavaBean Object to database
 */
public class BeanHandler<T>  implements IResultSetHandlerStandard<List<T>>{

    private Class<T> clazz = null;

    @Override
    public List<T> deal(ResultSet resultSet){

            ArrayList<T> list = new ArrayList<T>();

        try{

            while(resultSet.next()){

                BeanInfo beanInfo = Introspector.getBeanInfo(clazz,Object.class);

                PropertyDescriptor[] descriptor = beanInfo.getPropertyDescriptors();


                T objBean= clazz.newInstance();

                for(int i=0;i<descriptor.length;i++){

                    String columnName = descriptor[i].getName();

                    Object values = resultSet.getObject(columnName);

                    descriptor[i].getWriteMethod().invoke(objBean,values);

                }

                list.add(objBean);
            }
        }catch(Exception e){

           e.printStackTrace();

        }

        return list;

    }

    public BeanHandler(Class<T> clazz){

        this.clazz = clazz;

    }

}
