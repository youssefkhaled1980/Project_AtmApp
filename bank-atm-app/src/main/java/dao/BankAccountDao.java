package dao;

import java.util.List;

import model.BankAccount;


public interface BankAccountDao {
	BankAccount addAccount(BankAccount accountPojo); // create

	BankAccount deposit(BankAccount accountPojo, double depositAmount); // update

	BankAccount withdraw (BankAccount accountPojo, double withdrawalAmount); // update

	double displayBalance(BankAccount accountPojo); // read

}
