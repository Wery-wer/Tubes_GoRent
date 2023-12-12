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
    private String id_kendaraan;
    private int lama_penyewaan, total_harga;
    private Pembayaran pembayaran; 
    private Pengembalian pengembalian;
    private LocalDateTime tanggal_penyewaan;
    private Penyewa data_penyewa;
    private Mobil mobil; 
    private Motor motor;

    public Transaksi(String id_transaksi, String id_kendaraan, int lama_penyewaan, int total_harga, Penyewa data_penyewa, Mobil mobil, Motor motor) {
        this.id_transaksi = id_transaksi;
        this.id_kendaraan = id_kendaraan;
        this.lama_penyewaan = lama_penyewaan;
        this.total_harga = total_harga;
        this.tanggal_penyewaan = LocalDateTime.now();
        this.data_penyewa = data_penyewa;
        this.mobil = mobil;
        this.motor = motor;
    }
    
    

    public String getId_kendaraan() {
        return id_kendaraan;
    }

    public void setId_kendaraan(String id_kendaraan) {
        this.id_kendaraan = id_kendaraan;
    }
    
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
        DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return tanggal_penyewaan.format(displayFormatter);  
    }
    
    public void setTanggal_penyewaan() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = LocalDateTime.now().format(formatter);
        this.tanggal_penyewaan = LocalDateTime.parse(formattedDate, formatter);
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
