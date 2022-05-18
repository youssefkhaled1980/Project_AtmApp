package dao;

import java.util.List;

import model.BankAccount;


public interface BankAccountDao {
	BankAccount addAccount(BankAccount bankAccount); // create

	BankAccount deposit(BankAccount bankAccount, double depositAmount); // update

	BankAccount withdraw (BankAccount bankAccount, double withdrawalAmount); // update

	double displayBalance(BankAccount bankAccount); // read

}
