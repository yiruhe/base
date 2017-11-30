package query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class GenericQuery implements IQuery{
	
	//当前页
	private Integer currentPage = 1;
	
	//每页的大小
	private Integer pageSize = 10;
	
	//查询的参数
	private List<Object> list = new ArrayList<>();
	//查询的条件
	private List<String> conditions = new ArrayList<>();
	
	//存储排序相关的数据
	private Map<String,String> orderBy = new LinkedHashMap<>();
	
	//拼接查询条件
	public  String getSQLConditions(){
		
			
			conditions.clear();
			list.clear();
		
			StringBuilder sql = new StringBuilder(100);
			
			this.addConditions();
		
			for(int i=0;i<conditions.size();i++){
				
				if(i==0){
					
					sql.append(" WHERE ");
				}else{
					
					sql.append(" AND ");
					
				}
				sql.append(conditions.get(i));
			}
			
			//--------------拼接 Order By----------------
			
			if(orderBy.size() >0){
				
				//获取entry,遍历map中的数据
				Set<Entry<String,String>> set = orderBy.entrySet();
				
				Iterator<Entry<String,String>> iterator = set.iterator();
				
				sql.append(" ORDER BY ");
				
				while(iterator.hasNext()){
					
					
					Entry<String,String> entry = iterator.next();
					
					//获取相关数据
					String columnName = entry.getKey();
					String orderBy = entry.getValue();
					
					//拼接sql
					sql.append(columnName).append(" ").append(orderBy).append(",");
				}
				
				//删除最后一个,好
				sql.deleteCharAt(sql.length() - 1);
			}
			
			
			return sql.toString();
		}
		
		
		//返回查询参数
		public List<Object> getParameter(){
			
			return list;
			
		}
		
		public void addQuery(String condition,Object...param){
			
			list.addAll(Arrays.asList(param));
			conditions.add(condition);
		}
		
		//暴露给子类使用的方法
		protected void addConditions(){
			
			
		}
		
		//设置排序map的值
		public void addOrderBy(String columnName,OrderBy setOrder){
			
			//把enum对象的名字存储到map中,用于拼接SQL
			orderBy.put(columnName,setOrder.name());
			
		}
		
		//定义排序的规则
		enum OrderBy{
			ASC,DESC
		}
		
		
		//----------------------------------------
		
		
		//GET/SET
		public Integer getCurrentPage(){
			
			return this.currentPage;
			
		}
		
		public Integer getPageSize(){
			
			return this.pageSize;
			
		}


		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		
		
		public void setCurrentPage(Integer currentPage){
			
			this.currentPage = currentPage;
			
		}

}
