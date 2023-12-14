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
public class Mobil extends Kendaraan implements Asuransi, Serializable{
    private int kapasitas;

    public Mobil(int kapasitas, String merek, int harga_sewa, boolean ketersediaan, String id_kendaraan, String transmisi) {
        super(merek, harga_sewa, ketersediaan, id_kendaraan, transmisi);
        this.kapasitas = kapasitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
    
    @Override
    public void addAsuransi() {
        this.setHarga_sewa(this.getHarga_sewa()+konstanta_asuransi_mobil);
    }
    
    @Override
   public boolean equals(Object obj) {
      Mobil s = (Mobil)obj;
      return super.getId_kendaraan().equalsIgnoreCase(s.getId_kendaraan()) && super.getMerek().equalsIgnoreCase(s.getMerek());
   }
    
}
