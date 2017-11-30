package dao;

import java.util.List;

import page.PageList;
import query.GenericQuery;
import query.QueryParameter;
import domain.Student;

public interface IStudentDao {
	
	
	
	public abstract  List<Student> list1(QueryParameter obj);
	
	public abstract PageList PageQuery(GenericQuery obj);
}
