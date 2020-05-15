package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerDAO {
	private Connection conn;
	private ResultSet rs;
	private boolean isIDCheck;
	public CustomerDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";
			String ID= "namhoon"; //개인이 만든 db아이디와 비번 입력해야함
			String pw = "12345";
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL,ID,pw);
			System.out.println("접속 성공");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int confirmInfo(String id, String pw) {
		
		try {
			String SQL = "SELECT USER_ID, UPW FROM USER_INFO WHERE USER_ID = ? and UPW = ?";
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("USER_ID").equals(id) && rs.getString("UPW").equals(pw)) {
					return 1;
				}
				else
					return -1;
			}
			return -1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int insertCustomer(Customer cus) {
		String SQL = "INSERT INTO USER_INFO VALUES(?,?,?,?,?)";
		try {
			Customer customer = cus;
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getID());
			pstmt.setString(3, customer.getPw());
			pstmt.setString(4, customer.getPhone());
			pstmt.setString(5, customer.getIs_Admin());
			pstmt.executeQuery();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public boolean isExistId(String id) {
		
		try {
			String SQL = "SELECT USER_ID FROM USER_INFO WHERE USER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("USER_ID").equals(id)) {
					this.isIDCheck = false;
					return true;
				}
					
				else {
					this.isIDCheck = true;
					return false;
				}
					
			}else {
				this.isIDCheck = true;
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public ObservableList<Customer> getCustomerList(){
		String SQL = "SELECT * FROM CUSTOMER = ?";
		ObservableList<Customer> customerList = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//Customer customer = new Customer(rs.getString(0),rs.getString(1),rs.getString(2),rs.getString(3));
				//customerList.add(customer);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}
	public boolean isCheckID() {
		return this.isIDCheck;
	}
}
