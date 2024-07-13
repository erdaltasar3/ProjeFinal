/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proje;

/**
 *
 * @author erdal
 */
public abstract class Personel {
    
    public abstract int getId();
    
    
    @Override
    public String toString(){
        return "id : "+this.getId();
    }
    
}
