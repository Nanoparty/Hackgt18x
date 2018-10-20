package groupbites.gatech.testhackgt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GuestActivity extends AppCompatActivity {


    ArrayList<Host> hostList;
    ListView listView;
    List list = new ArrayList<>();
    ArrayAdapter adapter;
    Button butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        //Two methods below are to hide preset navigation bar/action bar/status bar
        //getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        listView = (ListView) findViewById(R.id.list1);

        HashMap<String, String> nameAddresses = new HashMap<>();
        for(Host h: Host.hostList){
            nameAddresses.put(h.getName()+" $" + h.getCuisine(), h.getLocation()+"");
        }
//        nameAddresses.put("Diana", "3214 Broadway Avenue");
//        nameAddresses.put("Tyga", "343 Rack City Drive");
//        nameAddresses.put("Rich Homie Quan", "111 Everything Gold Way");
//        nameAddresses.put("Donna", "789 Escort St");
//        nameAddresses.put("Bartholomew", "332 Dunkin St");
//        nameAddresses.put("Eden", "421 Angelic Blvd");

        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_item,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.text1, R.id.text2});


        Iterator it = nameAddresses.entrySet().iterator();
        while (it.hasNext())
        {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }

        listView.setAdapter(adapter);






        hostList = new ArrayList<>();





        //adapter = new ArrayAdapter(GuestActivity.this,android.R.layout.simple_list_item_1,list);
        //listView.setAdapter(adapter);

    }

    /*
    Method to fully hide entire android phone bars
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
