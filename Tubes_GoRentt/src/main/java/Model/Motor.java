/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Data.*;

import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author Holanta
 */
public class Motor extends Kendaraan implements Asuransi,Serializable {

    public Motor(String merek, int harga_sewa, boolean ketersediaan, String id_kendaraan, String transmisi) {
        super(merek, harga_sewa, ketersediaan, id_kendaraan, transmisi);
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
    
    public void insert_motor() throws SQLException{
        JDBC db = new JDBC();
        String sql = "INSERT INTO `motor` (`id`, `merek`, `harga`, `transmisi`, `ketersediaan`) VALUES ('"+getId_kendaraan()+"', '"+getMerek()+"', '"+getHarga_sewa()+"', '"+getTransmisi()+"',true)";
        db.executequery(sql);
    }
    
    public void update_motor(int i) throws SQLException{
        JDBC db = new JDBC();
        String sql = "UPDATE `motor` SET `ketersediaan` = '"+!isKetersediaan()+"' WHERE `id` = '"+getId_kendaraan()+"'";
        db.executequery(sql);
    }
    
    
}
