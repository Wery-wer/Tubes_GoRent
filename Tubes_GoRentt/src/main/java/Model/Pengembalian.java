/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Holanta
 */
public class Pengembalian implements Serializable{
    private Pembayaran pembayaran;
    private LocalDate tanggal_kembali;
    private int denda;
    private boolean status_pengembalian;

    public Pengembalian(Pembayaran pembayaran, LocalDate tanggal_kembali, int denda, boolean status_pengembalian) {
        this.pembayaran = pembayaran;
        this.tanggal_kembali = tanggal_kembali;
        this.denda = denda;
        this.status_pengembalian = status_pengembalian;
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
    
    public void createPembayaran(String id_pembayaran, java.sql.Date tanggal_bayar, boolean status_bayar, String metode_bayar, int jumlah_bayar) {
        this.pembayaran = new Pembayaran(id_pembayaran,tanggal_bayar,status_bayar,metode_bayar,jumlah_bayar);
    }
    
    public boolean cek_status_bayar(){
        return this.pembayaran.getStatus_bayar();
    }
    
    
}
