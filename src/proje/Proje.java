/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proje;

/**
 *
 * @author erdal
 */
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Proje {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        db.connection();
        System.out.println("************************************");
        
        PersonelFactory.getPersonel("bilgi", 250);
    
        //db.personelEkle(49, 2, "Ahmet", "Turan", 25, 15000);
        
        // PersonelSil pSil = new PersonelSil(33);
         
        //PersonelBilgi pBilgi = new PersonelBilgi(32);
        //db.personelEkle(45, 2, "Kadir", "Cetin", 20, 10000);
        

   
    }
    
}
