/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje;

/**
 *
 * @author erdal
 */
public class PersonelFactory {
    
    
    public static Personel getPersonel(String type, int id){
        
        if ("sil".equalsIgnoreCase(type)){
            return new PersonelSil(id);
        }
        
        else if("bilgi".equalsIgnoreCase(type)){
            return new PersonelBilgi(id);
        }else{
            return null;
        }
        
        
        
    }
    
}
