package com.example.productivitycac;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;


public class CreateNewTaskActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createnewtask_activity);

        EditText taskName = findViewById(R.id.taskNameInput);
        EditText taskTime = findViewById(R.id.taskTimeInput);

        Log.i("Task Name", taskName.toString());
        Log.i("Task Time", taskTime.toString());



     }

     public void createTask(View v) {
        Intent intent = new Intent(this, ToDoList.class);
        startActivity(intent);
     }

}