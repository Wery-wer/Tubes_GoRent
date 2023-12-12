/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.Mobil;
import Model.Motor;
import Model.Transaksi;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OMEN 870
 */
public class ScreenData {
    Save s = new Save();
    public static ArrayList<Mobil> arrMobil = new ArrayList<Mobil>();
    public static ArrayList<Motor> arrMotor = new ArrayList<Motor>();
    public static ArrayList<Transaksi> arrTransaksi = new ArrayList<Transaksi>();
    public static DefaultTableModel tabeltersedia = new DefaultTableModel(null,
    new String [] {
        "No", "ID Kendaraan", "Tipe Kendaraan", "Merek", "Transmisi", "Kapasitas", "Harga"
    });
    public static DefaultTableModel tabeltersewa = new DefaultTableModel(null,
    new String [] {
        "No", "ID Kendaraan", "Tipe Kendaraan", "Merek", "Tanggal Pengembalian"
    });
    
    public void setarrMobil(){
        this.arrMobil = s.readm();
    }
    
    public void setarrMotor(){
        this.arrMotor = s.readmtr();
    }
    
    public void setarrTransaksi(){
        this.arrTransaksi = s.readTransaksi();
        System.out.println(arrTransaksi);
    }
    
    
    public void settabeltersedia(){
        if(tabeltersedia.getRowCount() == 0){
            int idx = 1;
            for (int i = 0;i<arrMobil.size();i++) {
                if(arrMobil.get(i).isKetersediaan()){
                    tabeltersedia.addRow(new Object []{i+1, arrMobil.get(i).getId_kendaraan(),"Mobil", arrMobil.get(i).getMerek(), arrMobil.get(i).getTransmisi(), arrMobil.get(i).getKapasitas(), arrMobil.get(i).getHarga_sewa()});
                    idx++;
                }
            
            }
        
            for (int i = 0;i<arrMotor.size();i++) {
                if(arrMotor.get(i).isKetersediaan()){
                tabeltersedia.addRow(new Object []{idx, arrMotor.get(i).getId_kendaraan(),"Motor", arrMotor.get(i).getMerek(), arrMotor.get(i).getTransmisi(), 2, arrMotor.get(i).getHarga_sewa()});
                idx++;
                }
            }
        }
        
    }
    //TERSEWA
    public void settabeltersewa(){
        if (tabeltersewa.getRowCount() == 0){
            int idx = 0;
            for (int i = 0;i<arrTransaksi.size();i++) {
                if (arrTransaksi.get(i).getMobil() != null){
                    tabeltersewa.addRow(new Object[] {idx+1,arrTransaksi.get(i).getId_kendaraan(),"Mobil",arrTransaksi.get(i).getMobil().getMerek(),arrTransaksi.get(i).getTanggal_penyewaan()});
                    idx++;
                }else if(arrTransaksi.get(i).getMotor() != null){
                    tabeltersewa.addRow(new Object[] {idx+1,arrTransaksi.get(i).getId_kendaraan(),"Motor",arrTransaksi.get(i).getMotor().getMerek(),arrTransaksi.get(i).getTanggal_penyewaan()});
                    idx++;
                }
            }
        }
        
    }
    

    public void addtabeltersedia(Motor mtr,Mobil m) {
        if(m != null){
            tabeltersedia.addRow(new Object [] {tabeltersedia.getRowCount()+1,m.getId_kendaraan(),"Mobil",m.getMerek(),m.getTransmisi(),m.getKapasitas(),m.getHarga_sewa()});
            tabeltersedia.fireTableDataChanged();
        }else if (mtr != null){
            tabeltersedia.addRow(new Object [] {tabeltersedia.getRowCount()+1,mtr.getId_kendaraan(),"Motor",mtr.getMerek(),mtr.getTransmisi(),2,mtr.getHarga_sewa()});
            tabeltersedia.fireTableDataChanged();
        }
        
    }
    
    public void addtabeltersewa(Transaksi t) {
        if (t.getMobil() != null){
            tabeltersewa.addRow(new Object [] {tabeltersewa.getRowCount()+1,t.getMobil().getId_kendaraan(),"Mobil",t.getMobil().getMerek(),t.getTanggal_penyewaan()});
            tabeltersewa.fireTableDataChanged();
        }else if (t.getMotor() != null){
            tabeltersewa.addRow(new Object [] {tabeltersewa.getRowCount()+1,t.getMotor().getId_kendaraan(),"Motor",t.getMotor().getMerek(),t.getTanggal_penyewaan()});
            tabeltersewa.fireTableDataChanged();
        }
        
    }
    
    public Motor getMotor(String id_kendaraan){
        for (Motor motor : arrMotor) {
            if (motor.getId_kendaraan().equals(id_kendaraan)) {
                return motor; // Motor ditemukan
            }
        }
        return null;
    }
    
    public Mobil getMobil(String id_kendaraan){
        for (Mobil mobil: arrMobil) {
            if (mobil.getId_kendaraan().equals(id_kendaraan)) {
                return mobil;
            }
        }
        return null;
    }

    
    
    
}
