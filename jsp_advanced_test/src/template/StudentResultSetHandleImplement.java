package template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.IEngineerDirDao;
import dao.implement.EngineerDaoImplement;
import domain.Engineer;
import domain.Student;

public class StudentResultSetHandleImplement implements IResultSetHandle<List<Student>>{

	private IEngineerDirDao engineerDao = new EngineerDaoImplement();
	
	@Override
	public List<Student> handle(ResultSet set) {

		List<Student> list = new ArrayList<>();
		Map<Integer,Engineer> map = new HashMap<>();
		
		try {
			while(set.next()){
				
				Integer id = set.getInt("id");
				String name = set.getString("name");
				String department = set.getString("department");
				Integer score = set.getInt("score");
				Integer engineerId = set.getInt("part_id");
				
				Student student = new Student();
				//把数据存储到student对象中
				student.setName(name);
				student.setId(id);
				student.setDepartment(department);
				student.setScore(score);
			
				if(engineerId != null && engineerId != 0){
					
					Engineer engineer = map.get(engineerId);
					
					if(engineer == null){
						
						 engineer = engineerDao.getEnginnerId(engineerId);
						 
						 //缓存到map中,防止重复查询
						 map.put(engineerId, engineer);
					}
					
					student.setEngineerDir(engineer);
				
				}
				
				
				//添加到集合中
				list.add(student);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}

}
