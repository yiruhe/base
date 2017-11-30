package dao.implement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import templet.IResultHandler;
import templet.JdbcTemplate;
import dao.IPartNameDao;
import domain.DepartmentName;

public class DepartNameImplement implements IPartNameDao{

	@Override
	public int save(DepartmentName obj) {
		
		String sql = "INSERT classdir(id,part_name,part_id) values(?,?,?)";
		
		int affectedRowNumber = JdbcTemplate.update(sql,obj.getId(),obj.getDepartName(),obj.getDepartIndex());
		
		return affectedRowNumber;
	}

	@Override
	public int delete(Integer id) {
		
		String sql = "DELETE FROM classdir WHERE id = ?";
	
		return JdbcTemplate.update(sql,id);
	}

	@Override
	public DepartmentName get(int id) {
		
		
		String sql = "SELECT * FROM classdir WHERE id = ?";
		
		System.out.println("---------------------------------");
		
		return JdbcTemplate.query(sql,new partNameHandleImplement(),id).get(0);
	}

	@Override
	public List<DepartmentName> query() {
		
		String sql = "SELECT * FROM classdir";
		
		return JdbcTemplate.query(sql,new partNameHandleImplement());
	}

	@Override
	public int update(DepartmentName obj) {
		
		String sql = "UPDATE classdir SET part_name=?,part_id=? WHERE id = ?";
		
		return  JdbcTemplate.update(sql,obj.getDepartName(),obj.getDepartIndex(),obj.getId());
	}
	
	class partNameHandleImplement implements IResultHandler<List<DepartmentName>>{

		@Override
		public List<DepartmentName> handle(ResultSet set) {
			
			List<DepartmentName> list = new ArrayList<DepartmentName>();
			
			try{
				
				
				while(set.next()){
		
					//获取参数
					int id = set.getInt("id");
					String name = set.getString("part_name");
					int departId = set.getInt("part_id");
					
					//创建一个
					DepartmentName departmentName = new DepartmentName();
		
					//注入值
					departmentName.setId(id);
					departmentName.setDepartName(name);
					departmentName.setDepartIndex(departId);
					
					//添加到集合中
					list.add(departmentName);
				}
				
			}catch(Exception e){
				
				e.printStackTrace();
				
			}
			
			
			
			return list;
		}
		
		
		
	}

}
