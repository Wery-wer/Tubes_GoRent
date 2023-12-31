/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.JDBC;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author Holanta
 */
public class Penyewa implements Serializable{
    private String nama;
    private String nomor_telepon;
    private String alamat;

    public Penyewa(String nama, String nomor_telepon, String alamat) {
        this.nama = nama;
        this.nomor_telepon = nomor_telepon;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void insert_penyewa() throws SQLException{
        JDBC db = new JDBC();
        String sql = "INSERT INTO `penyewa` (`nama`, `nomor_telepon`, `alamat`) VALUES ('"+getNama()+"', '"+getNomor_telepon()+"', '"+getAlamat()+"')";
        db.executequery(sql);
        db.conn.close();
    }

}
