package templet;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.implement.DepartNameImplement;
import domain.DepartmentName;
import domain.Student;

public  class HandlerImpelement implements IResultHandler<List<Student>>{

	private DepartNameImplement dirDao = new DepartNameImplement();
	
	private Map<Integer,DepartmentName> map = new HashMap<>();
	
	@Override
	public List<Student> handle(ResultSet set) {
		Student student = null;
		List<Student> list = new ArrayList<Student>();
		try{
			
			while(set.next()){
				 
				Long sid = set.getLong("id");
				String name = set.getString("name");
				String department = set.getString("department");
				Integer score = set.getInt("score");
				Integer deparmentIndex = set.getInt("part_id");
				
				student = new Student();
		
				student.setId(sid);
				
				student.setName(name);
				
				student.setDepartment(department);
				
				student.setScore(score);
				
				//student.setDeparmentIndex(deparmentIndex);
				
				//通过deparmentIndex查询对应的产品表中的数据
				if(deparmentIndex != null){
					
					DepartmentName deparmentRow = map.get(deparmentIndex);
					
					//检查缓存中是否有数据
					if(deparmentRow == null){

						//查询数据库并获取数据
						 deparmentRow = dirDao.get(deparmentIndex);
						
						 //把对象缓存起来
						map.put(deparmentIndex,deparmentRow);
						
					}
					student.setDepartmentDirectory(deparmentRow);
				}
				
				//把对象注入到student
				
				//添加到集合
				list.add(student);
			 }
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		 
		 
		 
		 return list;
		
	}

}
