/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Controller.JDBC;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Holanta
 */
public class Motor extends Kendaraan implements Asuransi,Serializable {

    public Motor(String merek, int harga_sewa, boolean ketersediaan, String id_kendaraan, String transmisi) {
        super(merek, harga_sewa, ketersediaan, id_kendaraan, transmisi);
        JDBC db;
        try {
            db = new JDBC();
            String sql = "INSERT INTO `motor` (`id`, `merek`, `harga`, `transmisi`, `ketersediaan`) VALUES ('"+getId_kendaraan()+"', '"+getMerek()+"', '"+getHarga_sewa()+"', '"+getTransmisi()+"',true)";
            db.executequery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Motor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void addAsuransi() {
        this.setHarga_sewa(this.getHarga_sewa()+konstanta_asuransi_motor);
    }
    
    @Override
    public boolean equals(Object obj) {
      Motor s = (Motor)obj;
      return super.getId_kendaraan().equalsIgnoreCase(s.getId_kendaraan()) && super.getMerek().equalsIgnoreCase(s.getMerek());
    }
    
    
}
