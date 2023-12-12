/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Holanta
 */
public class Pembayaran implements Serializable {
    private String id_pembayaran;
    private Date tanggal_bayar;
    private boolean status_bayar;
    private String metode_bayar;
    private int jumlah_bayar;

    public String getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(String id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public Date getTanggal_bayar() {
        return tanggal_bayar;
    }

    public void setTanggal_bayar(Date tanggal_bayar) {
        this.tanggal_bayar = tanggal_bayar;
    }

    public boolean getStatus_bayar() {
        return status_bayar;
    }

    public void setStatus_bayar(boolean status_bayar) {
        this.status_bayar = status_bayar;
    }

    public String getMetode_bayar() {
        return metode_bayar;
    }

    public void setMetode_bayar(String metode_bayar) {
        this.metode_bayar = metode_bayar;
    }

    public int getJumlah_bayar() {
        return jumlah_bayar;
    }

    public void setJumlah_bayar(int jumlah_bayar) {
        this.jumlah_bayar = jumlah_bayar;
    }
    
    
}
