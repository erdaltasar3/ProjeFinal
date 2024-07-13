package com.mycompany.proje;


public abstract class Personel {
    
    public abstract int getId();
    
    @Override
    public String toString(){
        return "id : "+this.getId();
    }
    
}
