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
public class Collection {
    private String myName;
    private String myLeague;
    private String myVersion;
    private float myPerfection;
    private int myMaxSize;
    private ArrayList<UniqueCollection> myUniques;
    private boolean includeLegacy;
    private boolean includeDifficult;
    
              
    public Collection(String name, String league, String version){
        
        myName = name;
        myLeague = league;
        myVersion = version;
        
        initializeCollection();       
        
    }
    
    public void setName(String name){
        myName = name;
    }
    public String getName(){
        return myName;
    }
    
    public void setLeague(String league){
        myLeague = league;
    }
    public String getLeague(){
        return myLeague;
    }
    
    public void setVersion(String version){
        myVersion = version;
    }
    public String getVersion(){
        return myVersion;
    }
    
    public float getPerfection(){
        return myPerfection;
    }
        
    public void setMaxCollectionSize(int maxSize){
        myMaxSize = maxSize;
    }
    public int getMaxCollectionSize(){
        return myMaxSize;
    }
    
    public void setUniquesList(ArrayList<UniqueCollection> uniques){
        myUniques = uniques;
    }
    public ArrayList<UniqueCollection> getUniquesList(){
        return myUniques;
    }
    
    public void setIncludeLegacy(boolean incLegacy){
        includeLegacy = incLegacy;
    }
    public boolean getIncludeLegacy(){
        return includeLegacy;
    }
    
    public void setIncludeDifficult(boolean incDifficult){
        includeDifficult = incDifficult;
    }
    public boolean getIncludeRare(){
        return includeDifficult;
    }   
    
    private void initializeCollection(){
        
    }
    
}
