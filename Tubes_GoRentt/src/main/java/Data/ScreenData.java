/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.Mobil;
import Model.Motor;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OMEN 870
 */
public class ScreenData {
    Save s = new Save();
    public static ArrayList<Mobil> arrMobil = new ArrayList<Mobil>();
    public static ArrayList<Motor> arrMotor = new ArrayList<Motor>();
    public static DefaultTableModel tabeltersedia = new DefaultTableModel(null,
    new String [] {
        "No", "ID Kendaraan", "Tipe Kendaraan", "Merek", "Transmisi", "Kapasitas", "Harga"
    });
    
    public void setarrMobil(){
        this.arrMobil = s.readm();
    }
    
    public void setDefaultTableModel(){
        for (int i = 0;i<arrMobil.size();i++) {
            tabeltersedia.addRow(new Object []{i+1, arrMobil.get(i).getId_kendaraan(),"Mobil", arrMobil.get(i).getMerek(), arrMobil.get(i).getTransmisi(), arrMobil.get(i).getKapasitas(), arrMobil.get(i).getHarga_sewa()});
        }
    }
    
}
