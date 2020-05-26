package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderHistoryDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String driver = "oracle.jdbc.driver.OracleDriver";
	String ID= "namhoon"; //개인이 만든 db아이디와 비번 입력해야함
	String pw = "12345";
	
	public OrderHistoryDAO() {
		try {
			Class.forName(driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String setTotalOrderPrice(String id) {
		
		String SQL = "select total_sales from user_info where user_id = ?";
		String ans = "";
		try {
			conn = DriverManager.getConnection(dbURL,ID,pw);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ans = rs.getString("total_sales");
			}
			System.out.println("db불러오기 성공");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("db불러오기 실패");
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ans;
	}
	public ObservableList<OrderHistoryDTO> setHistoryList(String id) {
		String SQL = "select ouser_id, mname,odate, mprice, ocount from orders,menu where orders.omenu_id = menu.menu_id and ouser_id = ? and oisComplete = 1 order by orders.odate";
		ObservableList<OrderHistoryDTO> ohList = FXCollections.observableArrayList();
		try {
			conn = DriverManager.getConnection(dbURL,ID,pw);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderHistoryDTO ohistory = new OrderHistoryDTO(rs.getString("ouser_id"),rs.getString("odate"),rs.getString("mname"),rs.getString("mprice"),rs.getString("ocount")); 
				ohList.add(ohistory);
			}
			System.out.println("db불러오기 성공");
		}
		catch(Exception e) {
			System.out.println("주문이력 db불러오기 실패");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ohList;
	}
}
