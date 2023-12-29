/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Data.JDBC;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.time.*;
import java.time.format.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Holanta
 */
public class Transaksi implements Serializable{
    private String id_transaksi; 
    private String id_kendaraan;
    private int lama_penyewaan, total_harga;
    private Pembayaran pembayaran; 
    private Pengembalian pengembalian;
    private LocalDate tanggal_penyewaan;
    private Penyewa data_penyewa;
    private Mobil mobil; 
    private Motor motor;
    
    public Transaksi(String id_transaksi, String id_kendaraan, int lama_penyewaan, int total_harga, Penyewa data_penyewa, Mobil mobil, Motor motor) {
        
        this.id_transaksi = id_transaksi;
        this.id_kendaraan = id_kendaraan;
        this.lama_penyewaan = lama_penyewaan;
        this.total_harga = total_harga * lama_penyewaan;
        this.tanggal_penyewaan = LocalDate.now();
        this.data_penyewa = data_penyewa;
        this.mobil = mobil;
        this.motor = motor;
        createPembayaran(this.id_transaksi,null, false,null,this.total_harga);
        
        try {

            String sqlidpembayaran = "(SELECT id FROM `pembayaran` WHERE id = '"+this.pembayaran.getId_pembayaran()+"')";
            String sqlidpenyewa = "(SELECT id FROM `penyewa` WHERE id = '"+this.id_transaksi+"_0')";
            System.out.println(sqlidpenyewa);
            String sql;
            String sql2 = "INSERT INTO `penyewa`(`id`, `nama`, `nomor_telepon`, `alamat`) VALUES ('"+this.id_transaksi+"_0"+"','"+data_penyewa.getNama()+"','"+data_penyewa.getNomor_telepon()+"','"+data_penyewa.getAlamat()+"')";
            String sql3 = "INSERT INTO `pembayaran`(`status_bayar`, `metode_bayar`, `jumlah_bayar`, `id`) VALUES ("+this.pembayaran.getStatus_bayar()+","+this.pembayaran.getMetode_bayar()+",'"+this.pembayaran.getJumlah_bayar()+"','"+this.pembayaran.getId_pembayaran()+"')";
            JDBC db = new JDBC();
            db.executequery(sql2);
            db.executequery(sql3);
            if (mobil != null){
                String sqlidmobil = "(SELECT id FROM `mobil` WHERE id = '"+this.mobil.getId_kendaraan()+"')";
                sql = "INSERT INTO `transaksi`(`id`, `lama_penyewaan`, `total_harga`, `tanggal_penyewaan`, `penyewaid`, `mobilid`, `pembayaranid`) VALUES ('"+this.id_transaksi+"','"+this.lama_penyewaan+"','"+this.total_harga+"','"+this.tanggal_penyewaan+"',"+sqlidpenyewa+","+sqlidmobil+","+sqlidpembayaran+")";
            }else{
                String sqlidmotor = "(SELECT id FROM `motor` WHERE id = '"+this.motor.getId_kendaraan()+"')";
                sql = "INSERT INTO `transaksi`(`id`, `lama_penyewaan`, `total_harga`, `tanggal_penyewaan`, `penyewaid`, `motorid`, `pembayaranid`) VALUES ('"+this.id_transaksi+"','"+this.lama_penyewaan+"','"+this.total_harga+"','"+this.tanggal_penyewaan+"',"+sqlidpenyewa+","+sqlidmotor+","+sqlidpembayaran+")";
            }
            
            db.executequery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    

    public String getId_kendaraan() {
        return id_kendaraan;
    }

    public Penyewa getData_penyewa() {
        return data_penyewa;
    }

    public void setData_penyewa(Penyewa data_penyewa) {
        this.data_penyewa = data_penyewa;
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
    public LocalDate getTanggal_penyewaan() {
        return this.tanggal_penyewaan; 
    }
    
    public void setTanggal_penyewaan(Date date) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String formattedDate = LocalDateTime.now().format(formatter);
//        this.tanggal_penyewaan = LocalDate.parse(formattedDate, formatter);
            this.tanggal_penyewaan = date.toLocalDate();
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
//    public final void createPembayaran(int jumlah_bayar) {
//        this.pembayaran = new Pembayaran();
//        this.pembayaran.setId_pembayaran(this.id_transaksi+"_1");
//        this.pembayaran.setJumlah_bayar(jumlah_bayar);
//        this.pembayaran.setStatus_bayar(false);
//    }
    
    public void createPembayaran(String id_pembayaran, java.sql.Date tanggal_bayar, boolean status_bayar, String metode_bayar, int jumlah_bayar) {
        this.pembayaran = new Pembayaran(id_pembayaran,tanggal_bayar,status_bayar,metode_bayar,jumlah_bayar);
    }
    
    public LocalDate getTanggalPengembalian(){
        LocalDate dt = this.tanggal_penyewaan.plusDays(this.getLama_penyewaan());
        return dt;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }
    
    @Override
    public boolean equals (Object obj){
        Transaksi trs = (Transaksi) obj;
        return this.getId_transaksi().equalsIgnoreCase(trs.getId_kendaraan());
    }

    
    
}
