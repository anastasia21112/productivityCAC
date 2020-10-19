package com.example.productivitycac;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

                EditText taskName = findViewById(R.id.taskNameInput);
                EditText taskTime = findViewById(R.id.taskTimeInput);

                String taskNameString = taskName.getText().toString();
                String taskTimeString = taskTime.getText().toString();

                Intent nameIntent = new Intent(getApplicationContext(), ToDoList.class);
                nameIntent.putExtra("taskName", taskNameString);
                startActivity(nameIntent);

                //Log.i("Task Name", taskName.toString());
                //Log.i("Task Time", taskTime.toString());
            }
        });

     }

     public void createTask(View v) {
        Intent intent = new Intent(this, ToDoList.class);
        startActivity(intent);
     }

}