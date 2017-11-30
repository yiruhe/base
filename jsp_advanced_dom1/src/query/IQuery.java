package query;

import java.util.List;

public interface IQuery {
	
	public abstract String queryString();

	public abstract List<Object> getParameter();

}
