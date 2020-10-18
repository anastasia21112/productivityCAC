package com.example.productivitycac;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserDashboard extends AppCompatActivity {

    private Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dashboard);

        b1 = (Button) findViewById(R.id.addtaskbutton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.createnewtask_activity);
            }
        });

        b2 = (Button) findViewById(R.id.viewlistbutton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.to_do_list);
            }
        });

        b3 = (Button) findViewById(R.id.stopwatch_button);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.stopwatch_activity_main);
            }
        });
    }
}

