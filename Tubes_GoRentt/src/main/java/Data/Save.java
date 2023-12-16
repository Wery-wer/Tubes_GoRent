/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.Mobil;
import Model.Motor;
import Model.Transaksi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author OMEN 870
 */
public class Save {
    
    public ArrayList<Mobil> readm(){
        File fm = new File("./data/mobil.data");
        ArrayList<Mobil> output = new ArrayList<Mobil>();
    
        try{
            FileInputStream fis = new FileInputStream(fm);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Mobil> m = (ArrayList<Mobil>)ois.readObject();
            
            for (Mobil mobil : m){
                output.add(mobil);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return output;
    }
    
    public void writem(ArrayList<Mobil> m){
        File fm = new File("./data/mobil.data");
        try {
            if(!fm.exists()){
                fm.createNewFile();
            }else{
                FileOutputStream fos = new FileOutputStream(fm);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(m);
                oos.close();
                fos.close();
                System.out.println("sukses");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void writemtr(ArrayList<Motor> m){
        File fm = new File("./data/motor.data");
        try {
            if(!fm.exists()){
                fm.createNewFile();
            }else{
                FileOutputStream fos = new FileOutputStream(fm);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(m);
                oos.close();
                fos.close();
                System.out.println("sukses");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Motor> readmtr(){
        File fm = new File("./data/motor.data");
        ArrayList<Motor> output = new ArrayList<Motor>();
    
        try{
            FileInputStream fis = new FileInputStream(fm);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Motor> m = (ArrayList<Motor>)ois.readObject();
            
            for (Motor motor : m){
                output.add(motor);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return output;
    }
    
    public ArrayList<Transaksi> readTransaksi(){
        File fm = new File("./data/transaksi.data");
        ArrayList<Transaksi> output = new ArrayList<Transaksi>();
    
        try{
            
            FileInputStream fis = new FileInputStream(fm);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Transaksi> m = (ArrayList<Transaksi>)ois.readObject();
            
            for (Transaksi transaksi : m){
                output.add(transaksi);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return output;
    }
    
    public void writetransaksi (ArrayList<Transaksi> trs){
        File fm = new File("./data/transaksi.data");
        try {
            if(!fm.exists()){
                fm.createNewFile();
            }else{
                FileOutputStream fos = new FileOutputStream(fm);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(trs);
                oos.close();
                fos.close();
                System.out.println("sukses");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
