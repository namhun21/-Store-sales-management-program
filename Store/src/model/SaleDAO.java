package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SaleDAO {
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;

	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String ID = "namhoon";
	String PW = "12345";

	public SaleDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("connect");
		} catch (ClassNotFoundException e) {
			System.out.println("로딩 실패");
			e.printStackTrace();
		}
	}

	public ObservableList<SaleDTO> sql() {
		String query = "SELECT ordate ,sum(sump) FROM jioo group by ordate";
		ObservableList<SaleDTO> mDAO = FXCollections.observableArrayList();
		System.out.println("시작");
		try {
			conn = DriverManager.getConnection(URL, ID, PW);
			stat = conn.createStatement();
			rs = stat.executeQuery(query);
			//System.out.println("rs.next() : " + rs.next());
			while (rs.next()) {
				SaleDTO S = new SaleDTO(rs.getString("ordate"), rs.getString("SUM(SUMP)"));
				mDAO.add(S);
//				System.out.println(S);
			}
		} catch (Exception e) {
			System.out.println("실패");
		} finally {
			try {
				rs.close();
				stat.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return mDAO;
	}
	
	public ObservableList<SaleDTO> search(String s){
		String sql = "select ordate, sum(sump) from jioo group by ordate";
		ObservableList<SaleDTO> mmDAO = FXCollections.observableArrayList();
		
		System.out.println("시작");
		try {
			conn = DriverManager.getConnection(URL, ID, PW);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//		    pstmt.setString(1, s);
//			System.out.println("rs.next() : " + rs.next());
			while (rs.next()) {
				SaleDTO S = new SaleDTO(rs.getString("ordate"), rs.getString("SUM(SUMP)"));
//				SDTO S = new SDTO(rs.getString("ordate"));
				if(s.equals(rs.getString("ordate")))
				{
				System.out.println("OK");
				System.out.println(rs.getString("ordate") + rs.getString("SUM(SUMP)"));
//				System.out.println(rs.getString("ordate") + " " + rs.getString("SUM(SUMP)"));
				mmDAO.add(S);
//				System.out.println(mmDAO);
				}
			}
		} catch (Exception e) {
			System.out.println("실패");
		} finally {
			try {
				rs.close();
				stat.close();
				conn.close();
			} catch (Exception e) {
			}
		}

		return mmDAO;
	}
	
	public ObservableList<SaleDTO> search_menu(String s){
		String sql = "select Menu, sum(sump), ordate from jioo group by menu, ordate";
		ObservableList<SaleDTO> mmmDAO = FXCollections.observableArrayList();
		
		System.out.println("시작");
		try {
			conn = DriverManager.getConnection(URL, ID, PW);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//		    pstmt.setString(1, s);
//			System.out.println("rs.next() : " + rs.next());
			while (rs.next()) {
				SaleDTO S = new SaleDTO(rs.getString("Menu"), rs.getString("SUM(SUMP)"));
//				SDTO S = new SDTO(rs.getString("ordate"));
				if(s.equals(rs.getString("ordate")))
				{
				System.out.println("OK");
				System.out.println(rs.getString("Menu") + rs.getString("SUM(SUMP)"));
//				System.out.println(rs.getString("ordate") + " " + rs.getString("SUM(SUMP)"));
				mmmDAO.add(S);
//				System.out.println(mmDAO);
				}
			}
		} catch (Exception e) {
			System.out.println("실패");
		} finally {
			try {
				rs.close();
				stat.close();
				conn.close();
			} catch (Exception e) {
			}
		}

		return mmmDAO;
	}
}
