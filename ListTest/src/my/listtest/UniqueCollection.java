/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.listtest;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gebruiker
 */
public class UniqueCollection {
    ArrayList<Item> uniques;
    String uniqueName;
    float[][] modRanges;
    Item bestItem;
    float[] bestValues;
    float perfection;
    Image itemImage;
    ArrayList<String> regexList;
    
    
    
    
    
    
    
    public UniqueCollection(String uniqueNameIn, float[][] modRangesIn){
        uniques = new ArrayList<Item>();
        bestItem = null;
        bestValues = new float[modRangesIn.length];
        perfection = 0f;
        
        uniqueName = uniqueNameIn;
        modRanges = modRangesIn;
        
        getRegexList(uniqueName);
        
    }
    
    public void addItem(String itemText){
        float[] modValues = extractModValues(itemText);

        Item itemIn = new Item(uniqueName,"1.0",modValues);

        //add unique
        uniques.add(itemIn);
        //calculate perfection of item
        itemIn.itemPerfection = perfection(itemIn);
        //calculate new perfection of uniquecollection
        compareBest(itemIn);
        
                
    }
    
    
    public void compareBest(Item itemToCompare){
        
        //if there is no best item yet (i.e., is first item)
        if (bestItem==null){
            bestItem = itemToCompare;
            bestValues = itemToCompare.modValues;
            perfection = itemToCompare.itemPerfection;
        }
        //if new item is better than old best item
        else if (itemToCompare.itemPerfection > bestItem.itemPerfection){
            bestItem = itemToCompare;
            bestValues = itemToCompare.modValues;
            perfection = itemToCompare.itemPerfection;
        }
                   
        
    }
    
    public float perfection(Item itemIn){
        float[] itemMods = itemIn.modValues;
        float[] percents = new float[itemMods.length];
        float percentsum = 0f;
        
        for (int i=0;i<itemMods.length;i++){
            percents[i] = (itemMods[i]-modRanges[i][0])/(modRanges[i][1]-modRanges[i][0]);
            percentsum+=percents[i];
            //System.out.print(String.valueOf(percentsum));
        }
        return percentsum/percents.length;
        
        
    }
    
    
    public void getRegexList(String uniqueName){
        regexList = new ArrayList<String>();
        
        BufferedReader in = null;
                   
        try {
            in = new BufferedReader(new FileReader("D:\\Users\\Pim\\Mijn Documenten\\PoE Unique Database\\Test Stuff\\"+uniqueName+".txt"));
        } catch (FileNotFoundException ex) {
            System.out.print("Unique regex file not found! "+uniqueName);
            return;
        }
        
        String line;
        try {
            while((line = in.readLine()) != null){
                System.out.println(line);
                regexList.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(UniqueCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(UniqueCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public float[] extractModValues(String itemTextIn){
        float[] modValues = new float[regexList.size()];
        int j = 0;
        for (int i=0; i<regexList.size(); i++){
            String regexStr = regexList.get(i);
            if (regexStr.equals("")){
                continue;
            }
            //System.out.print(regexStr+"\n");
            Pattern regex = Pattern.compile(regexStr);
            Matcher m = regex.matcher(itemTextIn);
            if (m.find()){
                
                //jTextArea3.append(m.group(1));
                
                modValues[j] = Float.parseFloat(m.group(1));
                //System.out.print(String.valueOf(modValues[j]));
                j++;
                
                if (m.groupCount()==2){
                    //jTextArea3.append(" to "+m.group(2));
                }
                //jTextArea3.append("\n");
                //jTextArea4.append(regexStr+"\n");
            }
        }
        
        
        return modValues;
    }
    
    
}
