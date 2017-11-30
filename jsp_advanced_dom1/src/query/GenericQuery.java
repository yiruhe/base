package query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public abstract class GenericQuery implements IQuery{

	//参数的数据
	private List<Object> parameters = new ArrayList<>();
	
	//条件
	private List<String> conditions = new ArrayList<String>();
	
	//排序的数据
	private Map<String,String> OrderByMap = new LinkedHashMap<>();
	
	
	//所有的查询对象都有分页所以把这个定义在这里
	//这个对象就是在接受用户传递的数据,所以定义在这里
	private Integer currentPage = 1 ;
	private Integer pageSize = 10;
	
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
		
		
		if(OrderByMap.size() >0){
			
			
			sql.append(" LIMIT ");
			
			//把排序添加到SQL中
			Set<Entry<String,String>> OrderBySet = OrderByMap.entrySet();
			 
			for(Iterator<Entry<String,String>> iterator = OrderBySet.iterator();iterator.hasNext();){
			
				
				
					Entry<String,String> entry = iterator.next();
					
					String columnName = entry.getKey();
					String value = entry.getValue();
					sql.append(columnName).append(" ").append(value).append(",");
			}
			
			//删除最后一个逗号
			sql.deleteCharAt(sql.length() - 1);
			
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
	
	protected void setOrderBy(String columnName,OrderBy setOrderBy){
		
		OrderByMap.put(columnName,setOrderBy.name());
	};

	//可以设置一个enum
	enum OrderBy{
		ASC,DESC
	}
	
	
	
	public Integer getCurrentPage(){
		
		return this.currentPage;
	}
	public Integer getPageSize(){
		
		return this.pageSize;
	}
	
	public void setCurrentPage(Integer currentPage){
		
		this.currentPage = currentPage;
		
	}
	public void setPageSize(Integer pageSize){
		
		this.pageSize = pageSize;
	}
}
