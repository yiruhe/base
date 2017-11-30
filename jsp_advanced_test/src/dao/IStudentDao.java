package dao;

import java.util.List;

import page.PageList;
import query.GenericQuery;
import domain.Student;

public interface IStudentDao{
	
	public abstract List<Student> query(GenericQuery obj);
	
	/**
	 * 
	 * @param currentPage  	当前页
	 * @param pageSize    	每页的数据数量
	 * @return				返回一个分页的结果集
	 */
	
	public abstract PageList queryPage(Integer currentPage,Integer pageSize);
	
	
	//把两种查询封装到一起
	//public abstract void advancedQuery(GenericQuery obj,Integer currentPage,Integer pageSize);
	
	public abstract PageList advancedQuery(GenericQuery obj);
} 