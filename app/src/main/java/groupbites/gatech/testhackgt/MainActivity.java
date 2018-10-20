package groupbites.gatech.testhackgt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView text;

    private Button guestButton;
    private Button hostButton;
    DatabaseReference databaseHosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        text = (TextView) findViewById(R.id.text);


        // Write a message to the database
        databaseHosts = FirebaseDatabase.getInstance().getReference("path");

        databaseHosts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                Host.hostList.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Host host = postSnapshot.getValue(Host.class);
                    //adding artist to the list
                    Host.hostList.add(host);

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //String id = databaseHosts.push().getKey();
        //Host testhost = new Host("locaiton","name","cusine","descirption");


        //databaseHosts.child(id).setValue(testhost);
//
//        guestButton = (Button) findViewById(R.id.guest_button);
//        guestButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                DatabaseReference mDatabase;
//                mDatabase = FirebaseDatabase.getInstance().getReference("path");
//                String id = mDatabase.push().getKey();
//                Host artist = new Host("loc", "name", "cusine","desc");
//                mDatabase.child(id).setValue(artist);
//
//                Intent intent = new Intent(getApplicationContext(), GuestActivity.class);
//                startActivity(intent);
//            }
//        });
//

        //Two methods below are to hide preset navigation bar/action bar/status bar
        guestButton = (Button) findViewById(R.id.guest_button);
        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GuestActivity.class);
                startActivity(intent);
            }
        });
        hostButton = (Button) findViewById(R.id.host_button);
        hostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HostActivity1.class);
                startActivity(intent);
            }
        });



//        getSupportActionBar().hide();
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

    }

//    /*
//    Method to fully hide entire android phone bars
//     */
//
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
