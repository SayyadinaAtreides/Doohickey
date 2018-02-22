/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.listtest;

import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public class Item {
    String ItemName;
    String Version;
    float[] ModValues;
    float ItemPerfection;
    
   public void setItemName(String ItemNameIn){
        ItemName = ItemNameIn;
    }
    public String getItemName(){
        return ItemName;
    }
    
    public void setVersion(String VersionIn){
        Version = VersionIn;
    }
    public String getVersion(){
        return Version;
    }
    
    public void setModValues(float[] ModValuesIn){
        ModValues = ModValuesIn;
    }
    public float[] getModValues(){
        return ModValues;
    }
    
    public void setItemPerfection(float ItemPerfectionIn){
        ItemPerfection = ItemPerfectionIn;
    }
    public float getItemPerfection(){
        return ItemPerfection;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Item(String itemNameIn, String versionIn, float[] modValuesIn){
        ItemName = itemNameIn;
        Version = versionIn;
        ModValues = modValuesIn;
    }        
}
