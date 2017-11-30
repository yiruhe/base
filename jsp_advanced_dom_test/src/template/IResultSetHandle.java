package template;

import java.sql.ResultSet;

public interface IResultSetHandle<T> {

	
	
	public abstract T handle(ResultSet set);
	
}
