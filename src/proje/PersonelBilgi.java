/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author erdal
 */
public class PersonelBilgi extends Personel{
    
    private Connection c;
    private Statement st;
    private String query;
    private int id;
    
    public PersonelBilgi(int id){
        this.id = id;
        
        try {
            int t = 1;
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.query = "select*from Calisan";
            this.st = this.c.createStatement();
            ResultSet rs = this.st.executeQuery(query);
            
            while (rs.next()) {                
                if (rs.getInt("calisan_id") == id) {
                    System.out.println("Personel id : "+rs.getInt("calisan_id")+"\nPersonel departman no : "+rs.getInt("departman_no")+"\nAd : "+rs.getString("ad")+"\nSoyad : "+rs.getString("soyad")+"\nYas : "+rs.getInt("yas")+"\nMaas : "+rs.getInt("maas"));                                                                                                                                             
                    t = 0;
                    break;
                }
            }
            
            if (t==1) {
                System.out.println("girilen id numarali personel bulunamadi..");
            }
        } catch (Exception e) {
                       
        }  
    }

    @Override
    public int getId() {
        return this.id;
    }
    
    
    
}
