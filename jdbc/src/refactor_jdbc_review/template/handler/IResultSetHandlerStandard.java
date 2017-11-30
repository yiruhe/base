package refactor_jdbc_review.template.handler;

import java.sql.ResultSet;

/**
 *
 */
public interface IResultSetHandlerStandard<T>{




    public abstract T deal(ResultSet set);

}




