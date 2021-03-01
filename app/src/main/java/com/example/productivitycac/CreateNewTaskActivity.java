package com.example.productivitycac;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CreateNewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MasterTaskManager masterTaskManager = new MasterTaskManager();
//        Button taskCreated = (Button) findViewById(R.id.createTaskButton);
//
//        taskCreated.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // once add button is clicked, the values in the fields are added to the taskManager
//                EditText nameOfTask = (EditText) findViewById(R.id.taskNameInput);
//                EditText estimatedTime = (EditText) findViewById(R.id.taskTimeInput);
//
//                masterTaskManager.addTask(nameOfTask.getText().toString(), Double.parseDouble(estimatedTime.getText().toString()), "homework");
//
//                Log.i("Create new task ", masterTaskManager.toString());
//            }
//        });

    }

    public void createTask(View v) {
        Intent intent = new Intent(this, ToDoList.class);
        startActivity(intent);
    }


    /*public void addNewTask(View v){
         TableRow layout = (TableRow) findViewById(R.id.tableRow10);
         //layout.setVisibility(v.INVISIBLE);

         TextView receiverName_msg = (TextView) findViewById(R.id.task10);
         Intent intentName = getIntent();
         String newTaskName = intentName.getStringExtra("taskName");
         receiverName_msg.setText(newTaskName);


         TextView receiverTime_msg = (TextView) findViewById(R.id.task10Time);
         Intent intentTime = getIntent();
         String newTaskTime = intentTime.getStringExtra("taskTime");
         receiverTime_msg.setText(newTaskTime);

         //layout.setVisibility(v.VISIBLE);
     }*/

    public void goToToDoList(View v) {
//        Log.i("TODO", "TRIED TO GO TO TO DO LIST");
//        EditText taskName = findViewById(R.id.taskNameInput);
//        EditText taskTime = findViewById(R.id.taskTimeInput);
//
//        String taskNameStr = taskName.getText().toString();
//        String taskTimeString = taskTime.getText().toString();
//
//        ToDoList list = new ToDoList();
        Intent intent = new Intent(this, ToDoList.class);
        startActivity(intent);

        //list.addRow(taskNameStr);
    }

//    public void sendNewTask(View v) {
//        EditText taskName = findViewById(R.id.taskNameInput);
//        EditText taskTime = findViewById(R.id.taskTimeInput);
//
//        String taskNameString = taskName.getText().toString();
//        String taskTimeString = taskTime.getText().toString();
//
//        Intent nameIntent = new Intent(this, ToDoList.class);
//        nameIntent.putExtra("taskName", taskNameString);
//        startActivity(nameIntent);
//
//        Intent timeIntent = new Intent(this, ToDoList.class);
//        timeIntent.putExtra("taskTime", taskTimeString);
//        startActivity(timeIntent);
//    }
}
