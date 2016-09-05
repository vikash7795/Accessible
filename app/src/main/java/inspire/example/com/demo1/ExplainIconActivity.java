package inspire.example.com.demo1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

import inspire.example.com.demo1.CustomList;
import inspire.example.com.demo1.R;

public class ExplainIconActivity extends Activity {
    ListView list;
    String[] web = {
            "Braille Accessible",
            "Elevator Available",
            "Hearing Info ",
            "Elderly Friendly",

            "Large Print",
            "Sign Language",


            "Wheel Chair Accessible"

    } ;
    Integer[] imageId = {
            R.drawable.braille4,
            R.drawable.elevator4,
            R.drawable.hearing4,
            R.drawable.mobility4,
            R.drawable.print4,
            R.drawable.sign4,
            R.drawable.wheel4,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explainicon);

        CustomList adapter = new
                CustomList(this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

    }

}