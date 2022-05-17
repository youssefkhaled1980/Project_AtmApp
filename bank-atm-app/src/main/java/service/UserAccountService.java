package service;

import java.sql.SQLException;

import exception.SystemException;
import model.UserAccount;

public interface UserAccountService {
	
	UserAccount register(UserAccount userAccount) throws SQLException, SystemException;
	UserAccount validateUser(UserAccount userAccount) throws SQLException, SystemException;
	void exitApp();


}
