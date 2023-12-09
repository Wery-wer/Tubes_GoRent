/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.*;
import java.time.format.*;;

/**
 *
 * @author Holanta
 */
public class Transaksi {
    private String id_transaksi; 
            //id_kendaraan;
    private int lama_penyewaan, total_harga;
    private Pembayaran pembayaran; 
    private Pengembalian pengembalian;
    private LocalDateTime tanggal_penyewaan;
    private Penyewa data_penyewa;
    private Mobil mobil; 
    private Motor motor;
    
    

    public String getId_transaksi() {
        return id_transaksi;
    }
    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }
    public int getLama_penyewaan() {
        return lama_penyewaan;
    }
    public void setLama_penyewaan(int lama_penyewaan) {
        this.lama_penyewaan = lama_penyewaan;
    }
    public String getTanggal_penyewaan() {
        DateTimeFormatter IniAdalahBentukFormatnya = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return (tanggal_penyewaan.format(IniAdalahBentukFormatnya));     
    }
    public void setTanggal_penyewaan(String tanggal_penyewaan) {
        DateTimeFormatter IniAdalahBentukFormatnya = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.tanggal_penyewaan = LocalDateTime.parse(tanggal_penyewaan, IniAdalahBentukFormatnya);
    }

    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    public int getTotal_harga() {
        return total_harga;
    }
    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }    
    public boolean cek_status_bayar() {
        return (pembayaran.getStatus_bayar());
    }
    public void createPembayaran(int jumlah_bayar) {
        this.pembayaran = new Pembayaran();
        this.pembayaran.setJumlah_bayar(jumlah_bayar);
    }
    
    
}
