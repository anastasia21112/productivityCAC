package com.example.productivitycac;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class CreateNewTaskActivity extends AppCompatActivity
{
    private Button createButton,b1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createnewtask_activity);

        createButton = (Button)findViewById(R.id.create);
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                TableRow layout = (TableRow) findViewById(R.id.tableRow10);
                layout.setVisibility(View.INVISIBLE);

                EditText taskName = findViewById(R.id.taskNameInput);
                EditText taskTime = findViewById(R.id.taskTimeInput);

                String taskNameString = taskName.getText().toString();
                String taskTimeString = taskTime.getText().toString();

                Intent nameIntent = new Intent(getApplicationContext(), ToDoList.class);
                nameIntent.putExtra("taskName", taskNameString);
                startActivity(nameIntent);

                Intent timeIntent = new Intent(getApplicationContext(), ToDoList.class);
                timeIntent.putExtra("taskTime", taskTimeString);
                startActivity(timeIntent);

                TextView receiverName_msg = (TextView) findViewById(R.id.task10);
                Intent intentName = getIntent();
                String newTaskName = intentName.getStringExtra("taskName");
                receiverName_msg.setText(newTaskName);

                TextView receiverTime_msg = (TextView) findViewById(R.id.task10Time);
                Intent intentTime = getIntent();
                String newTaskTime = intentTime.getStringExtra("taskTime");
                receiverTime_msg.setText(newTaskTime);

                layout.setVisibility(View.VISIBLE);

            }
        });

     }

     public void createTask(View v) {
        Intent intent = new Intent(this, ToDoList.class);
        startActivity(intent);
     }

}