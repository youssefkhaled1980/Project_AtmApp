package service;

import dao.BankAccountDao;
import dao.BankAccountDaoDatabaseImpl;

import model.BankAccount;

public class BankAccountServiceImpl implements BankAccountService {
	BankAccountDao accountDao;

	public BankAccountServiceImpl() {
		accountDao = new BankAccountDaoDatabaseImpl();
	}

	public BankAccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(BankAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public BankAccount addAccount(BankAccount bankAccount) {

		return accountDao.addAccount(bankAccount);
	}

	public BankAccount deposit(BankAccount bankAccount, double depositAmount) {

		return accountDao.deposit(bankAccount, depositAmount);
	}

	public BankAccount withdraw(BankAccount accountPojo, double withdrawalAmount) {

		return accountDao.withdraw(accountPojo, withdrawalAmount);
	}

	public double displayBalance(BankAccount accountPojo) {
		// TODO Auto-generated method stub
		return accountDao.displayBalance(accountPojo);
	}


	
}
