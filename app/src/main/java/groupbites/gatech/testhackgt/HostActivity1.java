package groupbites.gatech.testhackgt;


import android.content.Intent;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;



public class HostActivity1 extends AppCompatActivity {

    //this is for the Host's description of food
    Button butt;
    TextView descrip;
    TextView name;
    TextView catagory;
    TextView price;
    TextView people;
    TextView time;
    TextView address;
    DatabaseReference databaseHosts;



    Location location; // Location
    double latitude; // Latitude
    double longitude; // Longitude

    // Declaring a Location Manager
    protected LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legit);
        butt = (Button) findViewById(R.id.host_button);
        descrip = (TextView) findViewById(R.id.host_description);
        name = (TextView) findViewById(R.id.host_event);
        catagory = (TextView) findViewById(R.id.host_category);
        time = (TextView)findViewById(R.id.time);
        address = (TextView) findViewById(R.id.host_address);
        price = (TextView) findViewById(R.id.price);
        people = (TextView) findViewById(R.id.people);

        databaseHosts = FirebaseDatabase.getInstance().getReference("path");



        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Host h = new Host(address.getText().toString(),name.getText().toString(),catagory.getText().toString(),descrip.getText().toString(),Integer.parseInt(people.getText().toString()),Integer.parseInt(price.getText().toString()),0,0,time.getText().toString());
                String id = databaseHosts.push().getKey();
                databaseHosts.child(id).setValue(h);
            }
        });
        //butt = (Button) findViewById(R.id.guest_button);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

//        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        if (location != null) {
//            latitude = location.getLatitude();
//            longitude = location.getLongitude();
//        }
    }

}
