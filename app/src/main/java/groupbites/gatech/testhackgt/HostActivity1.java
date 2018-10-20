package groupbites.gatech.testhackgt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HostActivity1 extends AppCompatActivity {

    //this is for the Host's description of food
    Button butt;
    TextView dish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host1);
        butt = (Button) findViewById(R.id.host_button);
        dish = (TextView) findViewById(R.id.dish_name);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(dish.getText().toString(), dish.getText().toString());
            }
        });
    }

}
