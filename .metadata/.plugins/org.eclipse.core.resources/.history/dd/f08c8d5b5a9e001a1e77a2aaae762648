package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.AdminController;
import controller.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String driver = "oracle.jdbc.driver.OracleDriver";
	String ID= "namhoon"; //개인이 만든 db아이디와 비번 입력해야함
	String pw = "12345";
	
	public OrderDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL,ID,pw);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ObservableList<OrderList> getOrderList() {
		String SQL = "SELECT ORDER_ID, OUSER_ID, MNAME, (MPRICE*OCOUNT) as PRICE ,OCOUNT FROM orders,menu where ORDERS.OMENU_ID = MENU.MENU_ID and TO_CHAR(orders.odate,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD') and orders.oiscomplete = 0 order by order_id";
		ObservableList<OrderList> oList = FXCollections.observableArrayList();
		try {
			conn = DriverManager.getConnection(dbURL,ID,pw);
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			//System.out.println("쿼리받을 준비");
			//System.out.println(SQL);
			
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
	public void cancelOrder(String order_id) {
		String SQL = "delete from orders where order_id = ?";
		try {
			conn = DriverManager.getConnection(dbURL,ID,pw);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, order_id);
			pstmt.executeUpdate();
			System.out.println("주문취소");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void calculateUserSale(String order_id) {
		String SQL = "update user_info set total_sales = total_sales + (select MPRICE*OCOUNT FROM orders,menu where ORDERS.OMENU_ID = MENU.MENU_ID and TO_CHAR(orders.odate,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD') and order_id = ?) where user_id = (select ouser_id from orders where order_id = ?)";
		try {
			conn = DriverManager.getConnection(dbURL,ID,pw);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, order_id);
			pstmt.setString(2, order_id);
			pstmt.executeUpdate();
			System.out.println("사용자 Sale 증가");

		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void changeOIsComplete(String order_id) {
		
		String SQL = "update orders set oisComplete = 1 where order_id = ?";
		
		try {
			conn = DriverManager.getConnection(dbURL,ID,pw);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, order_id);
			int r = pstmt.executeUpdate();
			System.out.println(order_id+"완료");
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void setOrderList() {
		String SQL = "SELECT ORDER_ID, OUSER_ID, MNAME, (MPRICE*OCOUNT) as PRICE ,OCOUNT FROM orders,menu where ORDERS.OMENU_ID = MENU.MENU_ID and TO_CHAR(orders.odate,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD') and orders.oiscomplete = 0 order by order_id";
		
		try {
			
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			System.out.println("쿼리받을 준비");
			//System.out.println(SQL);
			
			while(rs.next()) {
				OrderList olist = new OrderList(rs.getString("ORDER_ID"),rs.getString("OUSER_ID"),rs.getString("MNAME"),rs.getString("PRICE"),rs.getString("OCOUNT"));
				if(Main.orderList.contains(olist)) {
					continue;
				}
				Main.orderList.add(olist);
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
		
	}
	
}
