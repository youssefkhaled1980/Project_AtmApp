package presentation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import exception.AccountnotfoundException;
import exception.SystemException;
import model.BankAccount;
import model.UserAccount;
import service.BankAccountService;
import service.BankAccountServiceImpl;
import service.UserAccountService;
import service.UserAccountServiceImpl;

public class BankAccountDataBaseMain {

	public static void main(String[] args) throws AccountnotfoundException, SystemException {

		Scanner scan = new Scanner(System.in);
		BankAccountService accountService = new BankAccountServiceImpl();
		UserAccountService userService = new UserAccountServiceImpl();

		BankAccount bankaccount = new BankAccount();
		System.out.println("**************************");
		System.out.println("***Banking Application***");
		System.out.println("*************************");
		System.out.println();

		int option1 = 0;
		String ch = "y";

		System.out.println("1. Register new Account Holder ");

		while ("y".equals(ch)) {

			System.out.println("2. Existing Account Holder login ");
			System.out.println("3. Exit ");

			UserAccount userLogin = new UserAccount();

			option1 = scan.nextInt();
			scan.nextLine();

			switch (option1) {
			case 1:
				UserAccount newUserAccount = new UserAccount();

				System.out.println();
				System.out.println("Enter a new password: ");
				String password = scan.nextLine();
				newUserAccount.setPassword(password);

				UserAccount existingUserAccount = null;
				try {
					existingUserAccount = userService.register(newUserAccount);

				} catch (SystemException e) {
					System.out.println("Error try again later!!");
					userService.exitApp();
				} catch (SQLException sqle) {
					System.out.println("Error try again later!!");
					userService.exitApp();
				}

				System.out.println();
				System.out.println("Thank you your login is saved");

				System.out.println();
				System.out.println("Your new Account Holder ID: " + existingUserAccount.getAccHolderId());

				System.out.println();
				System.out.println("Registration successful");
				System.out.println();

				bankaccount.setAccHolderId(existingUserAccount.getAccHolderId());
				accountService.addAccount(bankaccount);
				break;

			case 2:

				System.out.println();
				System.out.println("Enter Account Holder ID: ");
				userLogin.setAccHolderId(scan.nextInt());
				scan.nextLine();

				System.out.println();
				System.out.println("Enter password: ");
				userLogin.setPassword(scan.nextLine());

				try {
					UserAccount existingUserAccount1 = userService.validateUser(userLogin);
					bankaccount.setAccHolderId(existingUserAccount1.getAccHolderId());

				} catch (SystemException e) {
					System.out.println("Login error");
					continue;
				} catch (SQLException sqle) {
					System.out.println("Login error");
					continue;
				}

				while (true) {

					System.out.println();
					System.out.println("Welcome Back!!");

					char proceed = 'y';

					while (proceed == 'y') {

						System.out.println();

						System.out.println("1. display balance");
						System.out.println("2.  Deposit ");
						System.out.println("3.  Withdraw ");
						System.out.println("4. Exit");

						int option2 = scan.nextInt();

						switch (option2) {
						case 1:

							System.out.println();
							accountService.displayBalance(bankaccount);
							System.out.println();

							System.out.println("Proceed? (y/n)");
							proceed = scan.next().charAt(0);
							break;

						case 2:

							double deposit;

							System.out.println();
							System.out.println("How much would you like to deposit? ");
							deposit = scan.nextDouble();

							System.out.println();
							accountService.deposit(bankaccount, deposit);

							System.out.println("Proceed? (y/n)");
							proceed = scan.next().charAt(0);
							break;

						case 3:

							double withdrawal;

							System.out.println();
							System.out.println("How much would you like to withdraw?");
							withdrawal = scan.nextDouble();

							accountService.withdraw(bankaccount, withdrawal);

							System.out.println("Procced? (y/n)");
							proceed = scan.next().charAt(0);
							break;

						case 4:

							System.out.println("Thank you for using ***Account Management System***");
							System.out.println("-----Program terminated-----");
							scan.close();
							System.exit(0);
							break;

						}
					}
					ch = "n";
					break;
				}

			case 3:
				System.out.println();
				System.out.println("******************************************");
				System.out.println("***********Thank you !!!******************");
				System.out.println("************Bank Application closed****************");
				scan.close();
				System.exit(0);

			}

		}

	}
}
