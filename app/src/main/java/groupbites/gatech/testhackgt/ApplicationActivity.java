package groupbites.gatech.testhackgt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ApplicationActivity extends AppCompatActivity {

    Host host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String search = Host.selectedName;
        int index=0;
        for(int i = 0; i < search.length();i++){
            if(search.charAt(i) == '$')
                index = i;
        }
        search = search.substring(0,index-1);
        host = null;
        for(Host h:Host.hostList){
            if(h.getName().toString().equals(search)){

                host = h;
            }
        }

        TextView name = (TextView) findViewById(R.id.name);
        TextView catagory = (TextView) findViewById(R.id.catagory);
        TextView price = (TextView) findViewById(R.id.price);
        TextView people = (TextView) findViewById(R.id.people);
        TextView time = (TextView) findViewById(R.id.time);
        TextView description = (TextView) findViewById(R.id.description);
        TextView address = (TextView) findViewById(R.id.address);

        name.setText(host.getName());
        catagory.setText(host.getCuisine());
        price.setText(String.valueOf(host.getPrice()));
        people.setText(String.valueOf(host.getMaxGuests()));
        time.setText(host.getEventTime());
        description.setText(host.getDescription());
        address.setText(host.getLocation());

        Button apply = (Button) findViewById(R.id.button2);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(host.getCurrentPeople()>= host.getMaxGuests()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Event already full", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    host.setPendingPeople(host.getPendingPeople()+1);
                    host.setPending();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
