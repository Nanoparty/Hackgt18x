package groupbites.gatech.testhackgt;

/**
 * Created by nfoot on 10/20/2018.
 */

public class Host {
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

    public String getLoc(){
        return Location;
    }
    public String getName(){
        return Name;
    }
    public String getCuisine(){
        return Cuisine;
    }
    public String getDesc(){
        return Description;
    }


}
