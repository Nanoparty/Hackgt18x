package groupbites.gatech.testhackgt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GuestActivity extends AppCompatActivity {

    DatabaseReference databaseHosts;
    ArrayList<Host> hostList;
    ListView listView;
    List list = new ArrayList<>();
    ArrayAdapter adapter;
    Button butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
//        //Two methods below are to hide preset navigation bar/action bar/status bar
//        getSupportActionBar().hide();
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        listView = (ListView) findViewById(R.id.list1);




        databaseHosts = FirebaseDatabase.getInstance().getReference("path");
        String id = databaseHosts.push().getKey();

        hostList = new ArrayList<>();

        databaseHosts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                hostList.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Host host = postSnapshot.getValue(Host.class);
                    //adding artist to the list
                    hostList.add(host);
                    list.add(host.getName().toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseHosts.child(id).setValue(new Host("1","2","3","4"));

        list.add("orange");
        for(Host h: hostList){
            list.add(h.getName().toString());
        }

        adapter = new ArrayAdapter(GuestActivity.this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

    }

//    /*
//    Method to fully hide entire android phone bars
//     */
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus) {
//            getWindow().getDecorView().setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }
}
