package service;

import java.util.List;

import exception.AccountnotfoundException;
import exception.SystemException;
import model.BankAccount;

public interface BankAccountService {
	
	BankAccount addAccount(BankAccount bankAccount); // create

	BankAccount deposit(BankAccount bankAccount, double deposit); // update

	BankAccount withdraw(BankAccount bankAccount, double withdrawal); // update

	double displayBalance(BankAccount accountPojo); // read
}
