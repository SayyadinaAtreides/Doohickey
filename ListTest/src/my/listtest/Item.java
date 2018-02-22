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
    String itemName;
    String version;
    float[] modValues;
    float itemPerfection;
    
    public Item(String itemNameIn, String versionIn, float[] modValuesIn){
        itemName = itemNameIn;
        version = versionIn;
        modValues = modValuesIn;
    }        
}
