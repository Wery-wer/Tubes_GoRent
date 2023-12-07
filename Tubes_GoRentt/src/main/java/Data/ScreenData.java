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
    
    public void setarrMotor(){
        this.arrMotor = s.readmtr();
    }
    
    public void setDefaultTableModel(){
        int idx = 1;
        for (int i = 0;i<arrMobil.size();i++) {
            tabeltersedia.addRow(new Object []{i+1, arrMobil.get(i).getId_kendaraan(),"Mobil", arrMobil.get(i).getMerek(), arrMobil.get(i).getTransmisi(), arrMobil.get(i).getKapasitas(), arrMobil.get(i).getHarga_sewa()});
            idx++;
        }
        
        for (int i = 0;i<arrMotor.size();i++) {
            tabeltersedia.addRow(new Object []{idx, arrMotor.get(i).getId_kendaraan(),"Motor", arrMotor.get(i).getMerek(), arrMotor.get(i).getTransmisi(), 2, arrMotor.get(i).getHarga_sewa()});
            idx++;
        }
    }

    public static void addtabeltersedia(String id,String jenis ,String merek,String transmisi,int kapasitas, int harga) {
        tabeltersedia.addRow(new Object [] {tabeltersedia.getRowCount()+1,id,jenis,merek,transmisi,kapasitas,harga});
        tabeltersedia.fireTableDataChanged();
    }
    
    
    
}
