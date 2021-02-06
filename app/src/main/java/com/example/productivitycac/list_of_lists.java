package com.example.productivitycac;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
=======

import androidx.appcompat.app.AppCompatActivity;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;
>>>>>>> cf7d646ecd4c20c191fd11d8b8af4fae8b6141ca

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class list_of_lists extends AppCompatActivity {

    private Button homeworkButton;
    protected static TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_lists);

        Button homeworkButton = (Button) findViewById(R.id.hw_button);
        Button backButton = (Button) findViewById(R.id.button6);
        //listTutorial()
        homeworkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toHomeworkList(v);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack(v);
            }
        });
    }

    public void toHomeworkList(View v)
    {
        //extractData();
        Intent intent = new Intent(this, ToDoList.class);
        startActivity(intent);
    }

    public void goBack(View v)
    {
        Intent intent = new Intent(this, UserDashboard.class);
        startActivity(intent);
    }

    public void listTutorial() {
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "SHOW2_ID");

        sequence.setConfig(config);

        sequence.addSequenceItem(homeworkButton,
                "View your specific list here", "GOT IT");


        sequence.start();
    }


}