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

/**
 *
 * @author OMEN 870
 */
public class JDBC {
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/pbotpminggu13";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static PreparedStatement stmt;
    static Statement st;
    static ResultSet rs;
    public JDBC () {
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          try {
            conn  = (Connection) DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
              System.out.println("Koneksi Berhasil");
        } catch (SQLException ex) {
              System.out.println("Koneksi gagal");
        }
    }
    
    
     public String executequery(String sql){
        try {
            stmt.executeUpdate();
            System.out.println("Berhasil");
        } catch (SQLException ex) {
            System.out.println("gagal");
            return "gagal";
        }
        return "Berhasil";
        
    }
     
    public ResultSet getData(){
        try {
            String sql = "select * from mahasiswa ";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("berhasil");
        } catch (SQLException ex) {
            System.out.println("gagal select");
        }
        return rs;  
    }
    
    
    public String DeleteDB(String nim){
        String sql = "DELETE FROM mahasiswa WHERE NIM = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nim);
            stmt.executeUpdate();
            System.out.println("didelete");
        }catch (SQLException ex) {
            return "gagal delete";
        }
        return "Berhasil delete";
    }
    
    public String UpdateDB(String nimlama, String nimbaru,String nama,String prodi){
        String sql = "UPDATE mahasiswa Set nim = ?, nama = ?, prodi = ? WHERE NIM = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nimbaru);
            stmt.setString(2, nama);
            stmt.setString(3, prodi);
            stmt.setString(4, nimlama);
            stmt.executeUpdate();
            System.out.println("updated");
        }catch (SQLException ex) {
            return "gagal update";
        }
        return "Berhasil update";
    }
    
}
