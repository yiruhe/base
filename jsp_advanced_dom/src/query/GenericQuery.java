package query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class GenericQuery implements IQuery{

	private List<Object> parameters = new ArrayList<>();
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
		
		return sql.toString();
	}

	

	
	//留给子类使用
	protected abstract void customizedParameter();

	//返回查询参数
	@Override
	public List<Object> getParameter() {
		
		return this.parameters;
	}
	
	
	//设置查询参数,条件;
	protected void setParameter(String condition,Object...param){
		
		this.parameters.addAll(Arrays.asList(param));
		this.conditions.add(condition);
		
	}

}
