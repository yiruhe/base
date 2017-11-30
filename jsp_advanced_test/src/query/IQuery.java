package query;

import java.util.List;

public interface IQuery {
	
	public abstract String getSQLConditions();

	public abstract List<Object> getParameter();
}
