package com.example.productivitycac;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TableRow;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import com.google.gson.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class CreateNewTaskActivity extends AppCompatActivity {
    private Button createButton, b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new ListManager(this.getApplicationContext(), "listManager.json");
        Log.i("TODO", "NEW TASK CREATED");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createnewtask_activity);


        createButton = (Button) findViewById(R.id.createTaskButton);

        String jsonString = "";
        try
        {
            InputStream is = this.getApplicationContext().getAssets().open("allTasks.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");

            JSONObject obj = new JSONObject(jsonString);
//
//            String task1 = obj.getJSONObject("listName").getString("task1");
//            Log.i("List Manager", "LM: TASK1: " + task1);
//
//            String task1Details = obj.getJSONObject("listName").getJSONObject("task1").getString("taskName");
//            Log.i("List Manager", "LM: TASK1NAME: " + task1Details);

            Map allTasks = new HashMap<String, ArrayList<Double>>();


            JSONArray taskListArray = obj.getJSONArray("tasks");

            for (int i = 0; i < taskListArray.length(); i++)
            {
                JSONObject listObj =  (JSONObject) taskListArray.get(i);
                JSONArray jsonDurations = listObj.getJSONArray("taskDuration");

                Log.i("List Manager", "listName: " + listObj.get("taskName"));
                ArrayList<Object> durations = new ArrayList<Object>();


                for(int j = 0; j < jsonDurations.length(); j++)
                {
                    Integer jsonTask =  (Integer)jsonDurations.get(j);
                    durations.add(jsonTask.doubleValue());
                }

                allTasks.put(listObj.get("taskName"), durations);
                Log.i("List Manager", "Durations in : " + listObj.get("taskName") + ": " + durations);

            }
            Log.i("List Manager", "entire all tasks : " + allTasks);


        }

        catch(FileNotFoundException e)
        {
            Log.i("List Manager", "LM: UNABLE TO FIND FILE");
        } catch (IOException e)
        {
            Log.i("List Manager", "LM: IO Exception");
        } catch (JSONException e) {
            Log.i("List Manager", "LM: JSON Exception " + e.getMessage());
        }
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
        Log.i("TODO", "TRIED TO GO TO TO DO LIST");
        EditText taskName = findViewById(R.id.taskNameInput);
        EditText taskTime = findViewById(R.id.taskTimeInput);

        String taskNameStr = taskName.getText().toString();
        String taskTimeString = taskTime.getText().toString();

        ToDoList list = new ToDoList();
        Intent intent = new Intent(this, ToDoList.class);
        startActivity(intent);

        list.addRow(taskNameStr);
    }

    public void sendNewTask(View v) {
        EditText taskName = findViewById(R.id.taskNameInput);
        EditText taskTime = findViewById(R.id.taskTimeInput);

        String taskNameString = taskName.getText().toString();
        String taskTimeString = taskTime.getText().toString();

        Intent nameIntent = new Intent(this, ToDoList.class);
        nameIntent.putExtra("taskName", taskNameString);
        startActivity(nameIntent);

        Intent timeIntent = new Intent(this, ToDoList.class);
        timeIntent.putExtra("taskTime", taskTimeString);
        startActivity(timeIntent);
    }
}
