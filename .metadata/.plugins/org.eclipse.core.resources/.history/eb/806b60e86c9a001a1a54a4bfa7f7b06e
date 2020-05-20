package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SDAO {
   static Connection conn = null;
   static Statement stat = null;
   static ResultSet rs = null;

   static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
   static String ID = "namhoon";
   static String PW = "12345";
   
   // SQL 호출
   public SDAO() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         System.out.println("connect");
      } catch (ClassNotFoundException e) {
         System.out.println("로딩 실패");
         e.printStackTrace();
      }
   }
   // 날짜별 총액
   public static ObservableList<SDTO> search_date(String date) {
      String sql = "select odate, sum(mprice) from menu, orders where orders.omenu_id = menu.menu_id GROUP by odate";
      ObservableList<SDTO> DAO_date = FXCollections.observableArrayList();
      System.out.println("시작");
      try {
         conn = DriverManager.getConnection(URL, ID, PW);
         stat = conn.createStatement();
         rs = stat.executeQuery(sql);
         System.out.println("넣기");
         SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
         while (rs.next()) {
            String to = format.format(rs.getDate("odate"));
            System.out.println(to);
            SDTO sdto = new SDTO(rs.getString("odate"), rs.getString("SUM(mprice)"));
            if (date.equals(to)) {
               System.out.println(rs.getString("odate") + " " + rs.getString("SUM(mprice)"));
               DAO_date.add(sdto);
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

      return DAO_date;
   }
   //메뉴별 총액
   public static ObservableList<SDTO> search_menu(String date) {
      String sql = "select mname,sum(mprice),odate from menu, orders where orders.omenu_id = menu.menu_id GROUP by mname, odate";
      ObservableList<SDTO> menu_DAO = FXCollections.observableArrayList();
      System.out.println("시작");
      try {
         conn = DriverManager.getConnection(URL, ID, PW);
         stat = conn.createStatement();
         rs = stat.executeQuery(sql);

         SimpleDateFormat fm = new SimpleDateFormat("yy/MM/dd");
         while (rs.next()) {
            SDTO S = new SDTO(rs.getString("Mname"), rs.getString("sum(mprice)"));
            System.out.println(rs.getString("mname"));
            String to = fm.format(rs.getDate("odate"));
            System.out.println(to);
            if (date.equals(to)) {
               System.out.println(rs.getString("Mname") + rs.getString("sum(mprice)"));
               
               menu_DAO.add(S);
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

      return menu_DAO;
   }

}