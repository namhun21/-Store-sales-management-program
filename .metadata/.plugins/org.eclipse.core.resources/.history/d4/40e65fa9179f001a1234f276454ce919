package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javafx.scene.control.TableView;

public class MenuDAO {
	private String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String ID = "namhoon";
	private String PW = "12345";

	private Connection conn = null;

	public MenuDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int[] checkMenuID(TableView<TableRowDataModel> orderListTable) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from menu where mname = ?";
		int[] result = new int[30];
		try {
			// 디비 연결
			conn = DriverManager.getConnection(URL, ID, PW);
			pstmt = conn.prepareStatement(sql);
			int index = 0;
			for (int i = 0; orderListTable.getItems().size() > i; i++) {
				String menuName = (String) orderListTable.getColumns().get(0).getCellObservableValue(i).getValue();
				pstmt.setString(1, menuName);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					// input order table success
					result[index++] = rs.getInt("menu_id");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		System.out.println(Arrays.toString(result));
		return result;
	}

	public void inputOrder(TableView<TableRowDataModel> orderListTable, String uId) {
		int orderID = 1, menuCnt = orderListTable.getItems().size(), j = 0;
	      int[] menuID = checkMenuID(orderListTable);
	      SimpleDateFormat formatter = new SimpleDateFormat("yy.MM.dd");
	      String date = formatter.format(new java.util.Date());
	      int[] mCnt = new int[27];
	      while (menuCnt-- > 0) {
	         mCnt[j] = (int) orderListTable.getColumns().get(1).getCellObservableValue(j).getValue();
	         j++;
	      }

		Statement stat = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "insert into orders values(?,?,?,?,?,0)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 디비 연결
			conn = DriverManager.getConnection(URL, ID, PW);
			stat = conn.createStatement();
			rs = stat.executeQuery("select order_id from orders");
			while (rs.next()) {
				if (orderID == rs.getInt("order_id"))
					orderID++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stat != null)
				try {
					stat.close();
				} catch (SQLException ex) {
				}
		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 디비 연결
			// conn = DriverManager.getConnection(URL, ID, PW);
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < menuID.length; i++) {
				if (menuID[i] == 0)
					break;
				pstmt.setInt(1, orderID++);
				pstmt.setString(2, uId);
				pstmt.setInt(3, menuID[i]);
				pstmt.setString(4, date);
				pstmt.setInt(5, mCnt[i]);
				int result = pstmt.executeUpdate();
				if (result != -1) {
					// input order table success
					System.out.println("Order successed");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}

}
