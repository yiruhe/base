package servletdemo.templete.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultSetHandlerImplement<T> implements IResultSetHandler<List<T>> {
	
	private Class<T> obj = null;
	

	@Override
	public List<T> handler(ResultSet set) {
	
		List<T> list = new ArrayList<T>();
		
		try{
			
			while(set.next()){
				
				T instantiation = this.obj.newInstance();
				
	
				//获取bean信息
				BeanInfo introspector = Introspector.getBeanInfo(obj,Object.class);
				//获取属性描述符
				PropertyDescriptor[] property = introspector.getPropertyDescriptors();
				
				
				for(PropertyDescriptor descroptor :property){
					
					//获取名称
					String name = descroptor.getName();
						
					//存入对象
					descroptor.getWriteMethod().invoke(instantiation,set.getObject(name));
						
						
				}
				
				list.add(instantiation);
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
			
		return list;
	}

	
	public ResultSetHandlerImplement(Class<T> obj){
	
		this.obj = obj;
		
	}
	
}
