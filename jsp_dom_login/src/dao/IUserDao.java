package dao;

import domain.User;

public interface IUserDao {

	/**
	 * 检查用户(在调用者判断密码),查询该账户是否存在
	 * @param userName (账户唯一)
	 * @return
	 */
	
	public abstract User getUserByUserName(String userName);
	
}
