/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author OMEN 870
 */
public class JDBC {
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3307/gorent";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    public static Connection conn;
    static PreparedStatement stmt;
    static Statement st;
    static ResultSet rs;
    
    public JDBC() throws SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            st = conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Connection Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
     public void executequery (String SQLString) {
        try {
            st.executeUpdate(SQLString);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),"Communication Error",JOptionPane.WARNING_MESSAGE); 
        }
    }
     
    public ResultSet getData(String SQLString) {
        try {
            rs = st.executeQuery(SQLString);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error  :"+e.getMessage(),"Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
    
    
//    public String DeleteDB(String nim){
//        String sql = "DELETE FROM mahasiswa WHERE NIM = ?";
//        try{
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, nim);
//            stmt.executeUpdate();
//            System.out.println("didelete");
//        }catch (SQLException ex) {
//            return "gagal delete";
//        }
//        return "Berhasil delete";
//    }
//    
//    public String UpdateDB(String nimlama, String nimbaru,String nama,String prodi){
//        String sql = "UPDATE mahasiswa Set nim = ?, nama = ?, prodi = ? WHERE NIM = ?";
//        try{
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, nimbaru);
//            stmt.setString(2, nama);
//            stmt.setString(3, prodi);
//            stmt.setString(4, nimlama);
//            stmt.executeUpdate();
//            System.out.println("updated");
//        }catch (SQLException ex) {
//            return "gagal update";
//        }
//        return "Berhasil update";
//    }
    
}
