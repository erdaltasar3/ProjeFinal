
package com.mycompany.proje;



import java.sql.ResultSet;


public class DatabaseFacade {
    
    private NesneProje database;
    
    public DatabaseFacade(NesneProje database){
        this.database = database;
    }
    
    public ResultSet CalisanAra(int id){
        return database.search(id);
    }
    
    public void CalisanEkle(int id, int departman_no, String ad, String soyad, int yas, int maas){
        database.personelEkle(id, departman_no, ad, soyad, yas, maas);
    }
    
    public void CalisanSil(int id){
        database.personelSil(id);
    }
    
    public void CalisanBilgi(int id){
        database.personelBilgi(id);
    }
    
    public void CalisanMaaslar(){
        database.personelMaaslar();
    }
    
    public void maasGuncelle(int id, int yeniMaas){
        database.maasGuncelle(id, yeniMaas);
    }
    
    public void yasGuncelle(int id, int yeniYas){
        database.yasGuncelle(id, yeniYas);
    }
    
    public void departmanEkle(int departman_no, String departman_adi){
        database.departmanEkle(departman_no, departman_adi);
    }
    
    public void PazarlamaEkle(String pazarlama_alani){
        database.pazarlamaEkle(pazarlama_alani);
    }
    
    public void argeEkle(String Projeler){
        database.argeEkle(Projeler);
    }
    
    public void uretimEkle(String uretimYeri){
        database.uretimEkle(uretimYeri);
    }
    
    public void enYuksekMaaslar(){
        database.enYuksekMaaslar();
    }
    
    
}

