
package proje;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Database {
    
    Scanner s = new Scanner(System.in);
    
    private Connection c;
    private Statement st;
    private String query;
    
    public void connection(){
        try {
            Class.forName("org.postgresql.Driver");
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            System.out.println("baglanti basarili..");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ResultSet search(int id){
        int t = 1;
        
        try {
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.query = "select*from Calisan";
            this.st = this.c.createStatement();
            ResultSet rs = this.st.executeQuery(query);
            
            while (rs.next()) {                
                if (rs.getInt("calisan_id") == id) {
                    System.out.print("Kayit bulundu, Bilgileri goruntulemek icin lutfen 0 'a basiniz : ");
                    int cevap = s.nextInt();
                    if (cevap == 0) {
                        personelBilgi(id);
                    }
                    t=0;
                    break;
                }
            }
            
            if (t == 1) {
                System.out.println("Aradiginiz id bulunamadi...");
                return null;
            }
            
            return rs;
            
        } catch (Exception e) {
            ResultSet rs1 = null;
            return rs1;
        }
    }
    
    public void personelEkle(int id, int departman_no, String ad, String soyad, int yas, int maas){
        try {
            Class.forName("org.postgresql.Driver");
            this.query = "insert into Calisan(calisan_id,departman_no,ad,soyad,yas,maas) values('"+id+"','"+departman_no+"','"+ad+"','"+soyad+"','"+yas+"','"+maas+"')";
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.st = this.c.createStatement();
            int rs = st.executeUpdate(query);
            if (rs == 1){
                System.out.println("Calisan basariyla eklendi");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        Date now = new Date();

        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String tarih = formatter.format(now);
        
        CalisirEkle(id, departman_no, tarih);
    }
    
    public void personelSil(int id){
        try {
           this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
           this.st = this.c.createStatement();
           ResultSet rsDelete = search(id);
           this.query = "delete from Calisan where calisan_id='"+rsDelete.getInt("calisan_id")+"'";
           int rs = st.executeUpdate(query);
            System.out.println("Bulunan kayit silindi...");
           
        } catch (Exception e) {
            System.out.println("Kayit silinemedi !!!");
            System.out.println(e.getMessage());
        }
    }
    
    public void personelBilgi(int id){ 
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
    
    public void personelMaaslar(){
        try {
            this.query = "select * from Calisan";
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.st = this.c.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {                
                System.out.println(rs.getInt("calisan_id")+" id numarali calisan personelin maasi : "+rs.getInt("maas"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void maasGuncelle(int id, int yeniMaas){
        try {
            
            ResultSet rsUpdate = search(id);
            this.query = "update Calisan set maas='"+yeniMaas+"' where calisan_id='"+id+"'";
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.st = this.c.createStatement();
            int rs = this.st.executeUpdate(query);
            
            System.out.println(rsUpdate.getInt("calisan_id")+" numarali personelin eski maasi : "+rsUpdate.getInt("maas"));
            System.out.println(rsUpdate.getInt("calisan_id")+" numarali personelin yeni maasi : "+(yeniMaas)+"\n maas verisi basariyla guncellenmistir..");
         
        } catch (Exception e) {
        }

    }
    
    public void yasGuncelle(int id, int yeniYas){
        try {
            ResultSet rsUpdate = search(id);
            this.query = "update Calisan set yas='"+yeniYas+"' where calisan_id='"+id+"'";
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.st = this.c.createStatement();
            int rs = this.st.executeUpdate(query);
            
            System.out.println(rsUpdate.getInt("calisan_id")+" numarali personelin eski yasi : "+rsUpdate.getInt("yas"));
            System.out.println(rsUpdate.getInt("calisan_id")+" numarali personelin yeni yasi : "+(yeniYas)+"\n yas verisi basariyla guncellenmistir..");
        } catch (Exception e) {
        }
    }
    
    
    
    public void departmanEkle(int departman_no, String departman_adi){
        try {
            Class.forName("org.postgresql.Driver");
            this.query = "insert into Departman(departman_no, departman_adi) values('"+departman_no+"','"+departman_adi+"')";
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.st = this.c.createStatement();
            int rs = st.executeUpdate(query);
            if (rs == 1){
                System.out.println("departman basariyla eklendi");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void CalisirEkle(int id, int departman_no, String baslama_tarihi){
        try {
            Class.forName("org.postgresql.Driver");
            this.query = "insert into Calisir(calisan_id, departman_no, baslama_tarihi) values('"+id+"','"+departman_no+"','"+baslama_tarihi+"')";
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.st = this.c.createStatement();
            int rs = st.executeUpdate(query);
            if (rs == 1){
                System.out.println("Calisir basariyla eklendi");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void pazarlamaEkle(String pazarlama_alani){
        try {
            int departman_no = 1;
            String departman_adi = "Pazarlama";
            Class.forName("org.postgresql.Driver");
            this.query = "insert into Pazarlama(departman_no,departman_adi,pazarlama_alani) values ('"+departman_no+"','"+departman_adi+"','"+pazarlama_alani+"')";
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.st = this.c.createStatement();
            int rs = st.executeUpdate(query);
            if (rs == 1){
                System.out.println("pazarlama tablosuna basariyla veri eklendi");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void argeEkle(String projeler){
        try {
            int departman_no = 2;
            String departman_adi = "ARGE";
            Class.forName("org.postgresql.Driver");
            this.query = "insert into ARGE(departman_no, departman_adi, projeler) values('"+departman_no+"','"+departman_adi+"','"+projeler+"')";
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.st = this.c.createStatement();
            int rs = st.executeUpdate(query);
            if (rs == 1){
                System.out.println("arge tablosuna basariyla veri eklendi");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void uretimEkle(String uretim_yeri){
        try {
            int departman_no = 3;
            String departman_adi = "Üretim";
            Class.forName("org.postgresql.Driver");
            this.query = "insert into Uretim(departman_no, departman_adi, uretim_yeri) values('"+departman_no+"','"+departman_adi+"','"+uretim_yeri+"')";
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.st = this.c.createStatement();
            int rs = st.executeUpdate(query);
            if (rs == 1){
                System.out.println("uretim tablosuna basariyla veri eklendi");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sirketDepartmanlari(){
        try {
            
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.query = "select*from Departman";
            this.st = this.c.createStatement();
            
            ResultSet rs = this.st.executeQuery(query);
            
            while (rs.next()){
                System.out.println("departman no : "+rs.getInt("departman_no")+", Departman Adi : "+rs.getString("departman_adi"));
            }
            
        } catch (Exception e) {
        }
    }
        
    public  void enYuksekMaaslar(){
        try {
            this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjeDatabase","postgres","123");
            this.query = "select * from Calisan order by maas desc limit 3";
            this.st = this.c.createStatement();
            ResultSet rs = this.st.executeQuery(query);
            
            while(rs.next()){
                personelBilgi(rs.getInt("calisan_id"));
                System.out.println("---------------------------------------------------");
            }
        } catch (Exception e) {
        }
    }
    
}
