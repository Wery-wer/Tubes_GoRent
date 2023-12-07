/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.Mobil;
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
        File fm = new File("E:/PBO/test/Tubes_GoRent/Tubes_GoRentt/data/mobil.data");
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
        File fm = new File("E:/PBO/test/Tubes_GoRent/Tubes_GoRentt/data/mobil.data");
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
}
