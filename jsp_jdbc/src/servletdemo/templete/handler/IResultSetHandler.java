package servletdemo.templete.handler;

import java.sql.ResultSet;

public interface IResultSetHandler<T> {
	
	
	
	
	public abstract T handler(ResultSet set);

}
