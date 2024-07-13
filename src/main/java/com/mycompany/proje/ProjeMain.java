package com.mycompany.proje;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjeMain {
    public static void main(String[] args) throws SQLException {
        NesneProje db = new NesneProje();
        db.connection();
        
        db.sirketDepartmanlari();
    
        
        
        
        
        // PersonelSil pSil = new PersonelSil(33);
         
        //PersonelBilgi pBilgi = new PersonelBilgi(32);
        //PersonelFactory.getPersonel("bilgi", 1);
        
        NesneProje nesneProje = new NesneProje();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calisan eklemek istediginiz departmani secin:");
        System.out.println("1. Pazarlama");
        System.out.println("2. ARGE");
        System.out.println("3. Uretim");

        int departmanSecimi = scanner.nextInt();
        scanner.nextLine(); // Satır sonu karakterini temizle

        switch (departmanSecimi) {
            case 1:
                nesneProje.setCalisanEkleStrategy(new PazarlamaCalisanEkle());
                break;
            case 2:
                nesneProje.setCalisanEkleStrategy(new ArgeCalisanEkle());
                break;
            case 3:
                nesneProje.setCalisanEkleStrategy(new UretimCalisanEkle());
                break;
            default:
                System.out.println("Gecersiz secim.");
                return;
        }

        System.out.println("Calisan ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Satır sonu karakterini temizle

        System.out.println("Calisan Adi:");
        String ad = scanner.nextLine();

        System.out.println("Calisan Soyadi:");
        String soyad = scanner.nextLine();

        System.out.println("Calisan Yasi:");
        int yas = scanner.nextInt();

        System.out.println("Calisan Maasi:");
        int maas = scanner.nextInt();

        nesneProje.calisanEkle(id, ad, soyad, yas, maas);
    }
}
        
        
        
        
        
        
        
        
      
        
        
        
    
    

