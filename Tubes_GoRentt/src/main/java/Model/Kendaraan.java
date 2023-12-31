/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Data.JDBC;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Holanta
 */
public abstract class Kendaraan implements Serializable{
    private String merek;
    private int harga_sewa = 0;
    private boolean ketersediaan;
    private String id_kendaraan;
    private String transmisi;

    public Kendaraan(String merek, int harga_sewa, boolean ketersediaan, String id_kendaraan, String transmisi) {
        this.merek = merek;
        this.harga_sewa = harga_sewa;
        this.ketersediaan = ketersediaan;
        this.id_kendaraan = id_kendaraan;
        this.transmisi = transmisi;
    }

    
    
    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public int getHarga_sewa() {
        return harga_sewa;
    }

    public void setHarga_sewa(int harga_sewa) {
        this.harga_sewa = harga_sewa;
    }

    public boolean isKetersediaan() {
        return ketersediaan;
    }

    public void setKetersediaan(boolean ketersediaan) {
        this.ketersediaan = ketersediaan;
        try {
            JDBC db = new JDBC();
            String sql = "UPDATE `mobil` SET `ketersediaan` = "+ketersediaan+" WHERE `id` = '"+this.id_kendaraan+"'";
        db.executequery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Kendaraan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String getId_kendaraan() {
        return id_kendaraan;
    }

    public void setId_kendaraan(String id_kendaraan) {
        this.id_kendaraan = id_kendaraan;
    }

    public String getTransmisi() {
        return transmisi;
    }

    public void setTransmisi(String transmisi) {
        this.transmisi = transmisi;
    }
    
    public abstract void addAsuransi();
}
