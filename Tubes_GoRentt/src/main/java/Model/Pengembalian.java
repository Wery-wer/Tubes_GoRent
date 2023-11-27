/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Holanta
 */
public class Pengembalian {
    private Pembayaran pembayaran;
    private Date tanggal_kembali;
    private int denda;
    private boolean status_pengembalian;

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public Date getTanggal_kembali() {
        return tanggal_kembali;
    }

    public void setTanggal_kembali(Date tanggal_kembali) {
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
    
    public void createPembayaran(int jumlah_bayar){
        this.pembayaran = new Pembayaran();
        
    }
}
