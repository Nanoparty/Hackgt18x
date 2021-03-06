package groupbites.gatech.testhackgt;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReviewActivity extends AppCompatActivity {

    ArrayList<Host> hostList;
    ListView listView;
    List list = new ArrayList<>();
    ArrayAdapter adapter;
    Host host;
    DatabaseReference databaseHosts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        databaseHosts = FirebaseDatabase.getInstance().getReference("path");

        String search = Host.selectedName;

        host = null;
        for(Host h:Host.hostList){
            if(h.getName().toString().equals(search)){

                host = h;

            }
        }

        listView = (ListView) findViewById(R.id.list1);





        HashMap<String, String> nameAddresses = new HashMap<>();
        for(int i = 0; i < host.getPendingPeople();i++){
            nameAddresses.put("George P Burdell" + i, "Rating: 100%");
        }



        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_item,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.title, R.id.text2});


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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // selected item
                String selected = ((TextView) view.findViewById(R.id.title)).getText().toString();

                Toast toast = Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT);
                //toast.show();

                Host.selectedName = selected;
                Intent intent = new Intent(getApplicationContext(), ApplicationActivity.class);
                //startActivity(intent);

                AlertDialog.Builder altdial = new AlertDialog.Builder(ReviewActivity.this);
                altdial.setMessage("Do you want to Approve this user?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                host.setAccepted();
                                host.setPendingPeople(host.getPendingPeople()-1);
                                String id = databaseHosts.push().getKey();
                                databaseHosts.child(id).setValue(host);
                                Intent intent = new Intent(getApplicationContext(), HostManagerActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                host.setRejected();
                                host.setPendingPeople(host.getPendingPeople()-1);
                                String id = databaseHosts.push().getKey();
                                databaseHosts.child(id).setValue(host);
                                Intent intent = new Intent(getApplicationContext(), HostManagerActivity.class);
                                startActivity(intent);
                            }
                        });

                AlertDialog alert = altdial.create();
                alert.setTitle("Application Approval");
                alert.show();
            }
        });
    }
}
