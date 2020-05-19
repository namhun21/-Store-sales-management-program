package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public OrderDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";
			String ID= "namhoon"; //개인이 만든 db아이디와 비번 입력해야함
			String pw = "12345";
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL,ID,pw);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ObservableList<OrderList> getOrderList() {
		String SQL = "SELECT ORDER_ID, OUSER_ID, MNAME, (MPRICE*OCOUNT) as PRICE ,OCOUNT FROM orders,menu where ORDERS.OMENU_ID = MENU.MENU_ID and TO_CHAR(orders.odate,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD') and orders.oiscomplete = 0";
		ObservableList<OrderList> oList = FXCollections.observableArrayList();
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			System.out.println("쿼리받을 준비");
			System.out.println(SQL);
			
			while(rs.next()) {
				OrderList ol = new OrderList(rs.getString("ORDER_ID"),rs.getString("OUSER_ID"),rs.getString("MNAME"),rs.getString("PRICE"),rs.getString("OCOUNT"));
				oList.add(ol);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return oList;
	}
	
}
