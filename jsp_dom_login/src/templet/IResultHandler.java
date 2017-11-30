package templet;

import java.sql.ResultSet;

public interface IResultHandler<T> {
	
	

	public abstract T handle(ResultSet set);
}
