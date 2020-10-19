package com.example.productivitycac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class MainActivity extends AppCompatActivity {



    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1 = (Button)findViewById(R.id.btn1);
        ed1 = (EditText)findViewById(R.id.editText1);
        ed2 = (EditText)findViewById(R.id.editText2);

        b2 = (Button)findViewById(R.id.btn2);
        // tx1 = (TextView)findViewById(R.id.textView3);
        // tx1.setVisibility(View.GONE);

        loginTutorial();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("Anastasia") &&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    goToDashboard(v);


                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                    //        tx1.setVisibility(View.VISIBLE);
                    // tx1.setBackgroundColor(Color.RED);
                    counter--;
                    // tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void goToDashboard(View v) {
        Intent intent = new Intent(this, UserDashboard.class);
        startActivity(intent);
    }


    public void loginTutorial() {
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "ID");

        sequence.setConfig(config);

//        sequence.addSequenceItem(ed1,
//                "Enter a username", "GOT IT");
//
//        sequence.addSequenceItem(ed2,
//                "Enter a password", "GOT IT");

        sequence.addSequenceItem(b1,
                "Press this to login", "GOT IT");
        sequence.addSequenceItem(b2, "Press this to cancel your login information", "GOT IT");

        sequence.start();
    }


}

