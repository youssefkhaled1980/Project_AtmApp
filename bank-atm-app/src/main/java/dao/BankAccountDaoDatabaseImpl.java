package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.BankAccount;


public class BankAccountDaoDatabaseImpl implements BankAccountDao {

	public BankAccount addAccount(BankAccount bankAccount) {
		Connection conn = null;
		
		try {
			conn = DBUtil.makeconnection();
			
			Statement stmt = conn.createStatement();			
			String query1 = "INSERT INTO accountDetails(accholderid, balance) VALUES ("
							+bankAccount.getAccHolderId()+", 0) returning accholderid";
			
			ResultSet rs = stmt.executeQuery(query1);
			if(rs.next()) {
			bankAccount.setAccHolderId(rs.getInt(1));
			}
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		
		return bankAccount;
	}

	public BankAccount deposit (BankAccount bankAccount, double depositAmount) {
		Connection conn = null;
		Double deposit = depositAmount;
		double balance;
		try {
			conn = DBUtil.makeconnection();	
			Statement stmt1 = conn.createStatement();
			String query1 = "SELECT accnum FROM accountdetails WHERE accholderid ="
					+ bankAccount.getAccHolderId() + ";";
			ResultSet rs1 = stmt1.executeQuery(query1);
			if(rs1.next()) {
				bankAccount. setAccNum(rs1.getInt(1));
			}
			
			
			Statement stmt2 = conn.createStatement();
			String query2 = "SELECT balance FROM accountdetails WHERE accholderid ="
					+ bankAccount.getAccHolderId() + ";";
			ResultSet rs2 = stmt2.executeQuery(query2);
			if (rs2.next()) {
				balance = rs2.getDouble(1);
			Statement stmt = conn.createStatement();
			String query3 = "UPDATE accountdetails SET balance=" + (balance + deposit)
					+ "WHERE accnum=" + bankAccount.getAccNum();
			stmt.executeUpdate(query3) ; 
			System.out.println("$" + deposit + " deposited. Current balance: $" + (balance + deposit));
			
			
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return bankAccount;

	}
			

	

	public BankAccount withdraw(BankAccount bankAccount, double withdrawalAmount) {
		Connection conn = null;
		double withdrawal = withdrawalAmount;
		try {
			conn = DBUtil.makeconnection();
			Statement stmt1 = conn.createStatement();
			String query1 = "SELECT accnum FROM accountdetails WHERE accholderid ="
					+bankAccount.getAccHolderId() + ";";
			ResultSet rs1 = stmt1.executeQuery(query1);
			if(rs1.next()) {
				bankAccount.setAccNum(rs1.getInt(1));
			}
			Statement stmt2 = conn.createStatement();
			String query2 = "SELECT balance FROM accountdetails WHERE accholderid ="
					+ bankAccount.getAccHolderId() + ";";
			ResultSet rs2 = stmt2.executeQuery(query2);
			double balance;
			if (rs2.next()) {
				balance = rs2.getDouble(1);
				if(withdrawal > balance) {
					System.out.println("Insufficient funds. Current balance: $" + balance);
				}else {
					Statement stmt3 = conn.createStatement();
					String query3 = "UPDATE accountdetails SET balance=" + (balance - withdrawal)
							+ "WHERE accnum=" + bankAccount.getAccNum();
					
					stmt3.executeUpdate(query3);
					
					System.out.println();
					System.out.println("$" + withdrawal + " has been withdrawn. Current balance: $" + (balance - withdrawal));
					}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return bankAccount;
	}

	public double displayBalance(BankAccount bankAccount) {

		Connection conn = null;

		try {
			conn = DBUtil.makeconnection();
			
			Statement stmt1 = conn.createStatement();
			String query1 = "SELECT balance FROM accountdetails WHERE accholderid ="
					+ bankAccount. getAccHolderId() + ";";
			ResultSet rs1 = stmt1.executeQuery(query1);

			if (rs1.next()) {
				bankAccount.setAccBalance(rs1.getDouble(1));
				;

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		System.out.println("Balance: $" + bankAccount.getAccBalance());
		return bankAccount.getAccBalance();

	}




}