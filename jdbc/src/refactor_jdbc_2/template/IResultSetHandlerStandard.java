package refactor_jdbc_2.template;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 */
public interface IResultSetHandlerStandard<T> {


    /**
     *
     *@param resultSet
     */
    public abstract T deal(ResultSet resultSet);

}
