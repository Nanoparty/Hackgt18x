package groupbites.gatech.testhackgt;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by nfoot on 10/20/2018.
 */

public class Host {
    static ArrayList<Host> hostList = new ArrayList<>();
    static String selectedName = "";
    private String Location; //ADDRESS
    private String Name;   //NAME OF EVENT
    private String Cuisine; //TYPE
    private String Description;
    private int MaxGuests;
    private int Price;
    private double lattitute;
    private double longitude;
    private String EventTime;
    private int currentPeople;
    private int pendingPeople;
    private int state;

    public Host(String loc, String name, String cuis, String desc, int mg, int price, double lat, double lon, String time){
        Location = loc;
        Name = name;
        Cuisine = cuis;
        Description = desc;
        MaxGuests = mg;
        Price = price;
        lattitute = lat;
        longitude = lon;
        EventTime = time;
    }

    public Host(){

    }

    public String getLocation(){
        return Location;
    }
    public String getName(){
        return Name;
    }
    public String getCuisine(){
        return Cuisine;
    }
    public String getDescription(){
        return Description;
    }
    public int getMaxGuests(){
        return MaxGuests;
    }
    public int getPrice(){
        return Price;
    }
    public double getLattitute(){
        return lattitute;
    }
    public double getLongitude(){
        return longitude;
    }
    public String getEventTime(){
        return EventTime;
    }
    public int getState(){return state;}
    public int getCurrentPeople(){return currentPeople;}
    public int getPendingPeople(){return pendingPeople;}

    public void setName(String i){
        Name = i;
    }
    public void setDescription(String i){
        Description = i;
    }
    public void setLocation(String i){
        Location = i;
    }
    public void setCuisine(String i){
        Cuisine = i;
    }
    public void setMaxGuests(int i){
        MaxGuests = i;
    }
    public void setPrice(int i){
        Price = i;
    }
    public void setLattitute(double d){
        lattitute = d;
    }
    public void setLongitude(double d){
        longitude = d;
    }
    public void setEventTime(String t){
        EventTime = t;
    }
    public void setState(int i){state = i;}
    public void setPendingPeople(int i){pendingPeople=i;}


}
