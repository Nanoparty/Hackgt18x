package groupbites.gatech.testhackgt;


import android.content.Intent;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Time;

public class HostActivity1 extends AppCompatActivity {

    //this is for the Host's description of food
    Button butt;
    TextView descrip;
    TextView name;
    TextView catagory;
    SeekBar price;
    SeekBar people;
    Time time;
    Address address;



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
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i(dish.getText().toString(), dish.getText().toString());
            }
        });

//        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        if (location != null) {
//            latitude = location.getLatitude();
//            longitude = location.getLongitude();
//        }
    }

}
