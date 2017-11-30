package templet;

import java.sql.ResultSet;
import java.util.List;

public interface IResultHandler<T> {
	
	

	public abstract T handle(ResultSet set);
}
