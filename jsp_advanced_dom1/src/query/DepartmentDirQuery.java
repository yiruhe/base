package query;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DepartmentDirQuery implements IQuery{
	
	
	private String name;
	private List<Object> parameters = new ArrayList();
	private List<String> conditions = new ArrayList<String>();

	@Override
	public String queryString() {
		
		
		StringBuilder sql = new StringBuilder(200);
		
		this.customizedParameter();
		
		for(int i=0;i<conditions.size();i++){
			
			if(i==0){
				
				sql.append(" WHERE ");
			}else{
				sql.append(" AND ");
			}
			
			
			sql.append(conditions.get(i));
			
		}
		
		System.out.println(sql);
		
		return null;
	}

	@Override
	public List<Object> getParameter() {
		
		return this.parameters;
	}
	
	public void customizedParameter(){
		
		if(this.name != null && !"".equals(name)){
			
			parameters.add(name);
			conditions.add("%"+name+"%");
		}
		
	}

}
