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
    private ArrayList<Item> Uniques;
    private String UniqueName;
    private float[][] ModRanges;
    private Item BestItem;
    private float[] BestValues;
    private float Perfection;
    private Image ItemImage;
    private ArrayList<String> RegexList;
    
    
    public void setUniques(ArrayList<Item> UniquesIn){
        Uniques = UniquesIn;
    }
    public ArrayList<Item> getUniques(){
        return Uniques;
    }
    
    public void setUniqueName(String NameIn){
        UniqueName = NameIn;
    }
    public String getUniqueName(){
        return UniqueName;
    }
    
    public void setModRanger(float[][] ModRangesIn){
        ModRanges = ModRangesIn;
    }
    public float[][] getModRanges(){
        return ModRanges;
    }
    
    public void setBestItem(Item BestItemIn){
        BestItem = BestItemIn;
    }
    public Item getBestItem(){
        return BestItem;
    }
    
    public void setBestValues(float[] BestValuesIn){
        BestValues = BestValuesIn;
    }
    public float[] getBestValues(){
        return BestValues;
    }
    
    public void setPerfection(float PerfectionIn){
        Perfection = PerfectionIn;
    }
    public float getPerfection(){
        return Perfection;
    }
    
    public void setItemImage(Image ItemImageIn){
        ItemImage = ItemImageIn;
    }
    public Image getItemImage(){
        return ItemImage;
    }
    
    public void setRegexList(ArrayList<String> RegexListIn){
        RegexList = RegexListIn;
    }
    public ArrayList<String> getRegexList(){
        return RegexList;
    }
    
    
    
    
    
    
    
    public UniqueCollection(String uniqueNameIn, float[][] modRangesIn){
        Uniques = new ArrayList<Item>();
        BestItem = null;
        BestValues = new float[modRangesIn.length];
        Perfection = 0f;
        
        UniqueName = uniqueNameIn;
        ModRanges = modRangesIn;
        
        getRegexList(UniqueName);
        
    }
    
    public void addItem(String itemText){
        float[] modValues = extractModValues(itemText);

        Item itemIn = new Item(UniqueName,"1.0",modValues);

        //add unique
        Uniques.add(itemIn);
        //calculate perfection of item
        itemIn.setItemPerfection(perfection(itemIn));
        //calculate new perfection of uniquecollection
        compareBest(itemIn);
        
                
    }
    
    
    public void compareBest(Item itemToCompare){
        
        //if there is no best item yet (i.e., is first item)
        if (BestItem==null){
            BestItem = itemToCompare;
            BestValues = itemToCompare.getModValues();
            Perfection = itemToCompare.getItemPerfection();
        }
        //if new item is better than old best item
        else if (itemToCompare.getItemPerfection() > BestItem.getItemPerfection()){
            BestItem = itemToCompare;
            BestValues = itemToCompare.getModValues();
            Perfection = itemToCompare.getItemPerfection();
        }
                   
        
    }
    
    public float perfection(Item ItemIn){
        float[] ItemMods = ItemIn.getModValues();
        float[] Percents = new float[ItemMods.length];
        float Percentsum = 0f;
        
        for (int i=0;i<ItemMods.length;i++){
            Percents[i] = (ItemMods[i]-ModRanges[i][0])/(ModRanges[i][1]-ModRanges[i][0]);
            Percentsum+=Percents[i];
            //System.out.print(String.valueOf(percentsum));
        }
        return Percentsum/Percents.length;
        
        
    }
    
    
    public void getRegexList(String uniqueName){
        RegexList = new ArrayList<String>();
        
        BufferedReader in = null;
                   
        try {
            in = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\suppfiles\\"+uniqueName+".txt"));
        } catch (FileNotFoundException ex) {
            System.out.print("Unique regex file for "+uniqueName+" not found! Check your spelling!");
            return;
        }
        
        String line;
        try {
            while((line = in.readLine()) != null){
                System.out.println(line);
                RegexList.add(line);
            }
        } catch (IOException ex) {
            
        }
        try {
            in.close();
        } catch (IOException ex) {
            
        }
        
    }
    
    
    public float[] extractModValues(String itemTextIn){
        float[] modValues = new float[RegexList.size()];
        int j = 0;
        for (int i=0; i<RegexList.size(); i++){
            String regexStr = RegexList.get(i);
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
