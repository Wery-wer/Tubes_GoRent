/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

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
    }
    
    @Override
    public boolean equals(Object obj) {
      Motor s = (Motor)obj;
      return super.getId_kendaraan().equalsIgnoreCase(s.getId_kendaraan()) && super.getMerek().equalsIgnoreCase(s.getMerek());
    }
}
