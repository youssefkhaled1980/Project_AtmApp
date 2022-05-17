package dao;

import java.beans.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.SystemException;
import model.UserAccount;

public class UserAccountDaoImpl implements UserAccountDao {

	public UserAccount register(UserAccount userAccount) throws SQLException, SystemException {
		Connection conn = DBUtil.makeconnection();
		
		try {
			java.sql.Statement stmt = conn.createStatement();
			String query = "INSERT INTO userdetails(password) VALUES('"
					+userAccount.getPassword()+"') returning accholderid";
			ResultSet rs =  stmt.executeQuery(query);
			rs.next();
			userAccount.setAccHolderId(rs.getInt("accholderid"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
						
					
		return userAccount;
	
		
	}

	public UserAccount login(UserAccount userAccount) throws SQLException, SystemException {
		Connection conn = DBUtil.makeconnection();
		
		try {
			java.sql.Statement stmt =  conn.createStatement();
			String query = "SELECT * FROM userdetails WHERE accholderid="+userAccount. getAccHolderId()
							+"and password='"+userAccount.getPassword()+"';";
			ResultSet rs =  ((java.sql.Statement) stmt).executeQuery(query);
			if(rs.next()) {
				System.out.println();
				System.out.println("login successful");
				
			}
			else {
				System.out.println("Account Holder not found");
				System.out.println("-----Program terminated-----");
				System.exit(0);
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userAccount;
		
	}

	public void exitApp() {
		
		
	}

}
