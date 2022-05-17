package dao;

import java.sql.SQLException;

import exception.SystemException;
import model.UserAccount;

public interface UserAccountDao {
	UserAccount register(UserAccount userAccount) throws SQLException, SystemException;
	UserAccount login (UserAccount userAccount) throws SQLException, SystemException;
	public void exitApp();

}
