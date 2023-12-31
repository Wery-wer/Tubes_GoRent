/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tubes_gorentt;

//import Data.JDBC;
//import Data.Save;
//import Model.Mobil;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Holanta
 */
public class Tubes_GoRentt {

    public static void main(String[] args) throws SQLException{
//        Save s = new Save();
//        
////        Mobil m = new Mobil(1,"m",10,true,"sada","manual");
////        ArrayList<Mobil> arr = new ArrayList<Mobil>();
////        arr.add(m);
////        
////        m = new Mobil(1,"m",10,true,"sasadsa","manual");
////        arr.add(m);
////        m = new Mobil(1,"m",10,true,"fgdfgfd","manual");
////        arr.add(m);
////        s.writem(arr);
//
//        Mobil m = new Mobil(1,"m",10,true,"sada","manual");
////        ArrayList<Mobil> arr = new ArrayList<Mobil>();
////        arr.add(m);
////        s.writem(arr);
//        
//        ArrayList<Mobil> hasil = new ArrayList<Mobil>();
//        hasil = s.readm();
//        
//        //System.out.println(hasil.getFirst().getMerek());
//        System.out.println("adsadas");
//        System.out.println(hasil.contains(m));

          LocalDate dat = LocalDate.parse("2023-12-23");
           LocalDate dat1 = LocalDate.now();
           
           int h = dat1.compareTo(dat);
           System.out.println(h);
        
    }
}
