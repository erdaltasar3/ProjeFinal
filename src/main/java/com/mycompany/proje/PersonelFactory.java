package com.mycompany.proje;



public class PersonelFactory {
    
    
    public static Personel getPersonel(String type,int id){
        if("sil".equalsIgnoreCase(type)){
            return new PersonelSil(id);
        }
        else if("bilgi".equalsIgnoreCase(type)){
            return new PersonelBilgi(id);
        }else{
            return null;
        }
    }
    
    
    
    
}
