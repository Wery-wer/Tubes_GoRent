/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.JDBC;
import java.io.Serializable;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Holanta
 */
public class Pengembalian implements Serializable{
    private Pembayaran pembayaran;
    private LocalDate tanggal_kembali;
    private int denda;
    private boolean status_pengembalian;

    public Pengembalian(Transaksi trs) {
        
        this.tanggal_kembali = LocalDate.now();
        this.denda = this.tanggal_kembali.compareTo(trs.getTanggal_penyewaan())*100000;
        this.status_pengembalian = true;
        createPembayaran(trs.getId_transaksi()+"_1",null, true,null,this.denda);
        
        
        try {
            String sqlidpembayaran = "(SELECT id FROM `pembayaran` WHERE id = '"+this.pembayaran.getId_pembayaran()+"')";
            String sql = "INSERT INTO `pengembalian`(`id`, `tanggal_kembali`, `denda`, `status_pengembalian`, `pembayaranid`) VALUES ('"+trs.getId_transaksi()+"','"+this.tanggal_kembali+"',"+this.denda+","+this.status_pengembalian+","+sqlidpembayaran+")";
            String sql1 = "INSERT INTO `pembayaran`(`status_bayar`, `metode_bayar`, `jumlah_bayar`, `id`) VALUES ("+this.pembayaran.getStatus_bayar()+","+this.pembayaran.getMetode_bayar()+",'"+this.pembayaran.getJumlah_bayar()+"','"+this.pembayaran.getId_pembayaran()+"')";
            JDBC db = new JDBC();
            db.executequery(sql1);
            db.executequery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Pengembalian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public LocalDate getTanggal_kembali() {
        return tanggal_kembali;
    }

    public void setTanggal_kembali(LocalDate tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }

    public boolean isStatus_pengembalian() {
        return status_pengembalian;
    }

    public void setStatus_pengembalian(boolean status_pengembalian) {
        this.status_pengembalian = status_pengembalian;
    }
    
    private void createPembayaran(String id_pembayaran, Date tanggal_bayar, boolean status_bayar, String metode_bayar, int jumlah_bayar) {
        this.pembayaran = new Pembayaran(id_pembayaran,tanggal_bayar,status_bayar,metode_bayar,jumlah_bayar);
    }
    
    public boolean cek_status_bayar(){
        return this.pembayaran.getStatus_bayar();
    }
    
    
}
