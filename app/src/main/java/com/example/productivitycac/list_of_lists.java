package com.example.productivitycac;

import androidx.appcompat.app.AppCompatActivity;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class list_of_lists extends AppCompatActivity {

    private Button homeworkButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_lists);

        Button homeworkButton = (Button) findViewById(R.id.hw_button);

        homeworkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toHomeworkList(v);
            }
        });
        Button backButton = (Button) findViewById(R.id.button6);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack(v);
            }
        });


    }

    public void toHomeworkList(View v)
    {

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

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "SHOW_ID");

        sequence.setConfig(config);

        sequence.addSequenceItem(homeworkButton,
                "View your specific list here", "GOT IT");


        sequence.start();
    }

}