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
public class PersonelSil extends Personel{
    
    Database db = new Database();
    private Connection c;
    private Statement st;
    private String query;
    private int id;
    
    public PersonelSil(int id){
        this.id = id;
        
        try {
           this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
           this.st = this.c.createStatement();
           ResultSet rsDelete = db.search(id);
           this.query = "delete from Calisan where calisan_id='"+rsDelete.getInt("calisan_id")+"'";
           int rs = st.executeUpdate(query);
            System.out.println("Bulunan kayit silindi...");
           
        } catch (Exception e) {
            System.out.println("Kayit silinemedi !!!");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int getId() {
       return this.id;
    }
    
}
