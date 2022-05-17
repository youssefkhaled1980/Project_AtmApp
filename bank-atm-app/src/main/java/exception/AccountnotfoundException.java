package exception;

public class AccountnotfoundException extends Exception {
	
	private int accNum;

	@Override
	public String toString() {
		return "AccountnotfoundException [accNum=" + accNum + "]";
	}

	public AccountnotfoundException(int accNum) {
		super();
		this.accNum = accNum;
	}

	public AccountnotfoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

}
