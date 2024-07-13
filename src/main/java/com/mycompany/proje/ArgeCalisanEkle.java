
package com.mycompany.proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ArgeCalisanEkle implements CalisanEkleStrategy {
    @Override
    public void calisanEkle(int id, String ad, String soyad, int yas, int maas) {
        try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proje", "postgres", "kadir1253");
            Statement st = c.createStatement();
            String query = "INSERT INTO Calisan (calisan_id, departman_no, ad, soyad, yas, maas) VALUES (" + id + ", 2, '" + ad + "', '" + soyad + "', " + yas + ", " + maas + ")";
            st.executeUpdate(query);
            System.out.println("ARGE departmanina calisan eklendi: " + ad + " " + soyad);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

