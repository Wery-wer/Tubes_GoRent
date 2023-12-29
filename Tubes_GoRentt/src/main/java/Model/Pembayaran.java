/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.sql.Date;
import Data.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Holanta
 */
public class Pembayaran implements Serializable {
    private String id_pembayaran;
    private LocalDate tanggal_bayar;
    private boolean status_bayar;
    private String metode_bayar;
    private int jumlah_bayar;

    public Pembayaran(String id_pembayaran, Date tanggal_bayar, boolean status_bayar, String metode_bayar, int jumlah_bayar) {
        this.id_pembayaran = id_pembayaran;
        
        this.status_bayar = status_bayar;
        this.metode_bayar = metode_bayar;
        this.jumlah_bayar = jumlah_bayar;
        if(tanggal_bayar != null){
            this.tanggal_bayar = tanggal_bayar.toLocalDate();
        }
    }
    
    
    public String getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(String id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public LocalDate getTanggal_bayar() {
        return tanggal_bayar;
    }

    public void setTanggal_bayar(LocalDate tanggal_bayar) {
        if(tanggal_bayar != null){
            this.tanggal_bayar = tanggal_bayar;
            try {
                JDBC db = new JDBC();
                String sql = "UPDATE `pembayaran` SET `tanggal_pembayaran` = '"+this.tanggal_bayar+"' where id = '"+this.id_pembayaran+"'";
                db.executequery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
//    public void setTanggal_bayarfromdb(Date tgl){
//        if(tgl != null){
//            this.tanggal_bayar = tgl.toLocalDate();
//            try {
//                JDBC db = new JDBC();
//                String sql = "UPDATE `pembayaran` SET `tanggal_pembayaran` = '"+this.tanggal_bayar+"' where id = '"+this.id_pembayaran+"'";
//                db.executequery(sql);
//            } catch (SQLException ex) {
//                Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//    }

    public boolean getStatus_bayar() {
        return status_bayar;
    }

    public void setStatus_bayar(boolean status_bayar) {
        
        try {
            this.status_bayar = status_bayar;
            
            JDBC db = new JDBC();
            String sql = "UPDATE `pembayaran` SET `status_bayar` = "+status_bayar+" where id = '"+this.id_pembayaran+"'";
            db.executequery(sql);
            System.out.println(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }

    public String getMetode_bayar() {
        return metode_bayar;
    }

    public void setMetode_bayar(String metode_bayar) {
        this.metode_bayar = metode_bayar;
        try {
            JDBC db = new JDBC();
            String sql = "UPDATE `pembayaran` SET `metode_bayar` = '"+metode_bayar+"' where id = '"+this.id_pembayaran+"'";
            db.executequery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getJumlah_bayar() {
        return jumlah_bayar;
    }

    public void setJumlah_bayar(int jumlah_bayar) {
        this.jumlah_bayar = jumlah_bayar;
    }
    
    public void insert_pembayaran() throws SQLException{
        JDBC db = new JDBC();
        String sql = "INSERT INTO `pembayaran` (`id_pembayaran`, `jumlah_bayar`, `status_bayar`, `metode_bayar`, `tanggal_bayar`) VALUES ('"+this.id_pembayaran+"','"+this.jumlah_bayar+"', '"+this.status_bayar+"', '', '')";
        db.executequery(sql);
    }
    
    public void update_pembayaran(Transaksi trs) throws SQLException{
        JDBC db = new JDBC();
        String sql = "UPDATE `pembayaran` SET `status_bayar`,`metode_bayar`, `tanggal_bayar` VALUES ('"+trs.getPembayaran().getStatus_bayar()+"', '"+trs.getPembayaran().getMetode_bayar()+"', '"+trs.getPembayaran().getTanggal_bayar()+"')";
        db.executequery(sql);
    }
}
