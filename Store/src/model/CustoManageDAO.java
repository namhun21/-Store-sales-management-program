package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustoManageDAO {
   static Connection conn = null;
   static Statement stat = null;
   static ResultSet rs = null;
   private PreparedStatement pstmt1;

   static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
   private String ID = "namhoon";
   private String PW = "12345";

   public CustoManageDAO() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         System.out.println("connect");
      } catch (ClassNotFoundException e) {
         System.out.println("로딩 실패");
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public ObservableList<CumaDTO> Cus_value() {
      String sql = "select UNAME, user_id, total_sales from user_info where uname not like 'admin%'";
      ObservableList<CumaDTO> call_info = FXCollections.observableArrayList();
      System.out.println("시작");
      try {
         conn = DriverManager.getConnection(URL, ID, PW);
         stat = conn.createStatement();
         rs = stat.executeQuery(sql);
         String total;
         System.out.println("넣기");
         while (rs.next()) {
            System.out.println(
                  rs.getString("Uname") + " " + rs.getString("user_id") + " " + rs.getString("total_sales"));
//            total = Integer.toString(rs.getInt("total_sales"));
            total = rs.getString("total_sales");
            System.out.println(total);
            CumaDTO cuma = new CumaDTO(rs.getString("Uname"), rs.getString("user_id"), rs.getString("total_sales"));
            call_info.add(cuma);
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

      return call_info;
   }

   public boolean Cus_delete(String id) {
      String sql = "DELETE FROM user_info WHERE user_id = ?";
//      ObservableList<CumaDTO> call_info = FXCollections.observableArrayList();
      System.out.println("시작");
      try {
         conn = DriverManager.getConnection(URL, ID, PW);
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();

         // pstmt = conn.prepareStatement(sql);
         pstmt.executeUpdate();

      } catch (Exception e) {
         System.out.println("실패");
         return false;
      }
      return true;
   }

   public void pw_change(String pw_user, String user_id) {

      String SQL = "update user_info set upw = ? where user_id = ?";
      try {
         conn = DriverManager.getConnection(URL, ID, PW);
         pstmt1 = conn.prepareStatement(SQL);
         pstmt1.setString(1, pw_user);
         pstmt1.setString(2, user_id);
         System.out.println(user_id + "비번 : " + pw_user + " " + "완료");
         rs = pstmt1.executeQuery();
         pstmt1.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("실패");
      } finally {
         try {
            pstmt1.close();
            conn.close();
         } catch (SQLException e) {

            e.printStackTrace();
         }
      }

   }
}