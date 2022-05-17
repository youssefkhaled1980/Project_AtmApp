package service;

import java.sql.SQLException;

import dao.UserAccountDao;
import dao.UserAccountDaoImpl;
import exception.SystemException;
import model.UserAccount;

public class UserAccountServiceImpl implements UserAccountService {
UserAccountDao userAccountDao;
	
	public UserAccountServiceImpl() {
		userAccountDao = new UserAccountDaoImpl();
	}

	public UserAccount register(UserAccount userAccount) throws SQLException, SystemException {
		UserAccount newUserAccount = this.userAccountDao.register(userAccount);
		return newUserAccount;
	}

	public UserAccount validateUser(UserAccount userAccount) throws SQLException, SystemException {
		UserAccount existingUserAccount = this.userAccountDao.login(userAccount);
		return existingUserAccount;
	}

	public void exitApp() {
		userAccountDao.exitApp();
		
	}

	

}
