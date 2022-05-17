package model;

public class UserAccount {
	
	private int accHolderId;
	private String password;
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAccount(int accHolderId, String password) {
		super();
		this.accHolderId = accHolderId;
		this.password = password;
	}
	public int getAccHolderId() {
		return accHolderId;
	}
	public void setAccHolderId(int accHolderId) {
		this.accHolderId = accHolderId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserAccount [accHolderId=" + accHolderId + ", password=" + password + "]";
	}

}
