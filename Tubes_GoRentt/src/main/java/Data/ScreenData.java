/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.Mobil;
import Model.Motor;
import Model.Pembayaran;
import Model.Penyewa;
import Model.Transaksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
     public static DefaultTableModel tabeltransaksi = new DefaultTableModel(null,
    new String [] {
        "ID","Tanggal Penyewaan","Nama Penyewa", "Merek Kendaraan", "Total Bayar", "Status"
    });
    
    public void setarrMobil(){
        this.arrMobil.clear();
        JDBC db;
        try {
            db = new JDBC();
            String sql = "SELECT * FROM `mobil`";
            ResultSet rs = db.getData(sql);
            while(rs.next()){
                Mobil m = new Mobil(rs.getInt("kapasitas"),rs.getString("merek"),rs.getInt("harga"),rs.getBoolean("ketersediaan"),rs.getString("id"),rs.getString("transmisi"));
                this.arrMobil.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScreenData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setarrMotor(){
        this.arrMotor.clear();
        JDBC db;
        try {
            db = new JDBC();
            String sql = "SELECT * FROM `motor`";
            ResultSet rs = db.getData(sql);
            while(rs.next()){
                Motor m = new Motor(rs.getString("merek"),rs.getInt("harga"),rs.getBoolean("ketersediaan"),rs.getString("id"),rs.getString("transmisi"));
                this.arrMotor.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScreenData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setarrTransaksi(){
        this.arrTransaksi.clear();
        JDBC db;
        try {
            db = new JDBC();
            String sql = "SELECT * FROM `transaksi` INNER JOIN `penyewa` on penyewa.id = transaksi.penyewaid LEFT JOIN `pengembalian` on transaksi.pengembalianid = pengembalian.id LEFT JOIN `pembayaran` on transaksi.pembayaranid = pembayaran.id";
            ResultSet rs = db.getData(sql);
            while(rs.next()){
                Penyewa pnyw = new Penyewa(rs.getString("nama"),rs.getString("nomor_telepon"),rs.getString("alamat"));
                if(rs.getString("mobilid") != null){
                    Mobil m = getMobil(rs.getString("mobilid"));
                    Transaksi trs = new Transaksi(rs.getString("id"),m.getId_kendaraan(),rs.getInt("lama_penyewaan"), rs.getInt("total_harga"), pnyw, m, null);
                    trs.setTanggal_penyewaan(rs.getDate("tanggal_penyewaan"));
//                    if (rs.getString("pengembalianid") != null){
//                        //set pengembalian
//                    }
                    if (rs.getString("pembayaranid") != null){
                        Pembayaran pmb = new Pembayaran(rs.getString("id"),rs.getDate("tanggal_pembayaran"),rs.getBoolean("Status_bayar"),rs.getString("Metode_bayar"),rs.getInt("Jumlah_bayar"));
//                        pmb.setId_pembayaran(rs.getString("id"));
//                        pmb.setJumlah_bayar(rs.getInt("Jumlah_bayar"));
//                        pmb.setMetode_bayar(rs.getString("Metode_bayar"));
//                        pmb.setStatus_bayar(rs.getBoolean("Status_bayar"));
//                        pmb.setTanggal_bayarfromdb(rs.getDate("tanggal_pembayaran"));
                        
                        trs.setPembayaran(pmb);
                    }
                    this.arrTransaksi.add(trs);
                }else if(rs.getString("motorid") != null){
                    Motor mtr = getMotor(rs.getString("motorid"));
                    Transaksi trs = new Transaksi(rs.getString("id"),mtr.getId_kendaraan(),rs.getInt("lama_penyewaan"), rs.getInt("total_harga"), pnyw, null, mtr);
                    trs.setTanggal_penyewaan(rs.getDate("tanggal_penyewaan"));
                    this.arrTransaksi.add(trs);
                    
                }
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    //tersedia
    public void settabeltersedia(){ 
        tabeltersedia = new DefaultTableModel(null,
    new String [] {
        "No", "ID Kendaraan", "Tipe Kendaraan", "Merek", "Transmisi", "Kapasitas", "Harga"
    });
            int idx = 1;
            for (int i = 0;i<arrMobil.size();i++) {
                if(arrMobil.get(i).isKetersediaan()){
                    tabeltersedia.addRow(new Object []{idx, arrMobil.get(i).getId_kendaraan(),"Mobil", arrMobil.get(i).getMerek(), arrMobil.get(i).getTransmisi(), arrMobil.get(i).getKapasitas(), arrMobil.get(i).getHarga_sewa()});
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
    
    public void addtabeltersedia(Motor mtr,Mobil m) {
        if(m != null){
            tabeltersedia.addRow(new Object [] {tabeltersedia.getRowCount()+1,m.getId_kendaraan(),"Mobil",m.getMerek(),m.getTransmisi(),m.getKapasitas(),m.getHarga_sewa()});

        }else if (mtr != null){
            tabeltersedia.addRow(new Object [] {tabeltersedia.getRowCount()+1,mtr.getId_kendaraan(),"Motor",mtr.getMerek(),mtr.getTransmisi(),2,mtr.getHarga_sewa()});

        }
        
    }
    
    
    
    
    //TERSEWA
    public void settabeltersewa(){
        tabeltersewa = new DefaultTableModel(null,
    new String [] {
        "No", "ID Kendaraan", "Tipe Kendaraan", "Merek", "Tanggal Pengembalian"
    });
            int idx = 0;
            for (int i = 0;i<arrTransaksi.size();i++) {
                if(arrTransaksi.get(i).cek_status_bayar()){
                    
                
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
    
    
    public void addtabeltersewa(Transaksi t) {
        if (t.getMobil() != null){
            tabeltersewa.addRow(new Object [] {tabeltersewa.getRowCount()+1,t.getMobil().getId_kendaraan(),"Mobil",t.getMobil().getMerek(),t.getTanggalPengembalian()});

        }else if (t.getMotor() != null){
            tabeltersewa.addRow(new Object [] {tabeltersewa.getRowCount()+1,t.getMotor().getId_kendaraan(),"Motor",t.getMotor().getMerek(),t.getTanggalPengembalian()});

        }
        
    }
    
    
    //transaksi
    public void settabeltransaksi(){
        tabeltransaksi = new DefaultTableModel(null,
    new String [] {
        "ID","Tanggal Penyewaan","Nama Penyewa", "Merek Kendaraan", "Total Bayar", "Status"
    });
            int idx = 0;
            for (int i = 0;i<arrTransaksi.size();i++) {
                if (arrTransaksi.get(i).getMobil() != null){
                    tabeltransaksi.addRow(new Object[] {arrTransaksi.get(i).getId_transaksi(),arrTransaksi.get(i).getTanggal_penyewaan(),arrTransaksi.get(i).getData_penyewa().getNama(),arrTransaksi.get(i).getMobil().getMerek(),arrTransaksi.get(i).getTotal_harga(),arrTransaksi.get(i).cek_status_bayar()});
                    idx++;
                }else if(arrTransaksi.get(i).getMotor() != null){
                    tabeltransaksi.addRow(new Object[] {arrTransaksi.get(i).getId_transaksi(),arrTransaksi.get(i).getTanggal_penyewaan(),arrTransaksi.get(i).getData_penyewa().getNama(),arrTransaksi.get(i).getMotor().getMerek(),arrTransaksi.get(i).getTotal_harga(),arrTransaksi.get(i).cek_status_bayar()});
                    idx++;
                }
            }
    }
    
    public void addtabeltransaksi(Transaksi t){
        if (t.getMobil() != null){
            tabeltransaksi.addRow(new Object [] {t.getId_transaksi(),t.getTanggal_penyewaan(),t.getData_penyewa().getNama(),t.getMobil().getMerek(),t.getTotal_harga(),t.cek_status_bayar()});

        }else if (t.getMotor() != null){
            tabeltransaksi.addRow(new Object [] {t.getId_transaksi(),t.getTanggal_penyewaan(),t.getData_penyewa().getNama(),t.getMotor().getMerek(),t.getTotal_harga(),t.cek_status_bayar()});

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

    public Transaksi getTransaksi(String id_transaksi) {
        for (Transaksi trs : arrTransaksi) {
            if (trs.getId_transaksi().equals(id_transaksi)) {
                return trs; // Motor ditemukan
            }
        }

        return null;
    }
    
    public void updatetabletransaksi(int row){
        Object[] o = new Object[]{tabeltransaksi.getValueAt(row, 0),tabeltransaksi.getValueAt(row, 1),tabeltransaksi.getValueAt(row, 2),tabeltransaksi.getValueAt(row, 3),tabeltransaksi.getValueAt(row, 4),true};
        tabeltransaksi.removeRow(row);
        tabeltransaksi.addRow(o);
    }   
}
