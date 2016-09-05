package inspire.example.com.demo1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView textview;
    ScrollView myScrollView;
    SharedPreferences prefs = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("com.inspire.example.demo1", MODE_PRIVATE);

        textview = (TextView) findViewById(R.id.signup);
        //set a onclick listener for when the button gets clicked
        textview.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(mainIntent);
            }
        });
        final Button button = (Button) findViewById(R.id.btnRegister);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainAppActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        if (prefs.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false
            Intent intent = new Intent(this, MyIntro.class);
            startActivity(intent);
            // using the following line to edit/commit prefs
            prefs.edit().putBoolean("firstrun", false).apply();
        }
    }
//calling the function when click on signin button
    /*public void slidetheapp()
    {
        Intent intent = new Intent(this, MainAppActivity.class);
        startActivity(intent);
    }*/

}
