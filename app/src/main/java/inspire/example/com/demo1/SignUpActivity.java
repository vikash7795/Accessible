package inspire.example.com.demo1;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class SignUpActivity extends AppCompatActivity {

    static EditText DateEdit;
    TextView lg;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        lg = (TextView) findViewById(R.id.login);
        lg.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View v) {

                                      Intent in = new Intent(getApplicationContext(), MainActivity.class);
                                      startActivity(in);
                                  }


                              }
        );
    }
}






