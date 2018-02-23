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
    private String Name;
    private String League;
    private String Version;
    private float Perfection;
    private int CollectionSize;
    private int MaxCollectionSize;
    private ArrayList<UniqueCollection> UniquesList;
    private boolean IncludeLegacy;
    private boolean IncludeRare;
    
    
    public void setName(String NameIn){
        Name = NameIn;
    }
    public String getName(){
        return Name;
    }
    
    public void setLeague(String LeagueIn){
        League = LeagueIn;
    }
    public String getLeague(){
        return League;
    }
    
    public void setVersion(String VersionIn){
        Version = VersionIn;
    }
    public String getVersion(){
        return Version;
    }
    
    public void setPerfection(float PerfectionIn){
        Perfection = PerfectionIn;
    }
    public float getPerfection(){
        return Perfection;
    }
    
    public void setCollectionSize(int SizeIn){
        CollectionSize = SizeIn;
    }
    public int getCollectionSize(){
        return CollectionSize;
    }
    
    public void setMaxCollectionSize(int MaxSize){
        MaxCollectionSize = MaxSize;
    }
    public int getMaxCollectionSize(){
        return MaxCollectionSize;
    }
    
    public void setUniquesList(ArrayList<UniqueCollection> UniquesListIn){
        UniquesList = UniquesListIn;
    }
    public ArrayList<UniqueCollection> getUniquesList(){
        return UniquesList;
    }
    
    public void setIncludeLegacy(boolean IncludeLegacyIn){
        IncludeLegacy = IncludeLegacyIn;
    }
    public boolean getIncludeLegacy(){
        return IncludeLegacy;
    }
    
    public void setIncludeRare(boolean IncludeRareIn){
        IncludeRare = IncludeRareIn;
    }
    public boolean getIncludeRare(){
        return IncludeRare;
    }
    
    
    
    
    public Collection(String NameIn, String LeagueIn, String VersionIn){
        
        Name = NameIn;
        League = LeagueIn;
        Version = VersionIn;
        
        InitializeCollection();
        
        
        
        
        
    }
    
    
    
    
    
    
    private void InitializeCollection(){
        
    }
    
}
