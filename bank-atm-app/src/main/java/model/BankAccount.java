package model;

public class BankAccount {
	private int accNum;
	private int accHolderId;
	private double accBalance;




	@Override
	public String toString() {
		return "BankAccount [accNum=" + accNum + ", accHolderId=" + accHolderId + ", accBalance=" + accBalance + "]";
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public int getAccHolderId() {
		return accHolderId;
	}

	public void setAccHolderId(int accHolderId) {
		this.accHolderId = accHolderId;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public BankAccount(int accNum, int accHolderId, int accBalance) {
		super();
		this.accNum = accNum;
		this.accHolderId = accHolderId;
		this.accBalance = accBalance;
	}

	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount showAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

}
