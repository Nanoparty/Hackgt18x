package groupbites.gatech.testhackgt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Button;

public class HostActivity1 extends AppCompatActivity {
    private Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host1);
        nextButton = (Button) findViewById(R.id.descriptionNextHost);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HostActivity2.class);
                startActivity(intent);
            }
        });
    }
}
