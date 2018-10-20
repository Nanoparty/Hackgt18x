package groupbites.gatech.testhackgt;

import java.util.ArrayList;

/**
 * Created by nfoot on 10/20/2018.
 */

public class Host {
    static ArrayList<Host> hostList = new ArrayList<>();
    private String Location;
    private String Name;
    private String Cuisine;
    private String Description;

    public Host(String a, String b, String c, String d){
        Location = a;
        Name = b;
        Cuisine = c;
        Description = d;
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


}
