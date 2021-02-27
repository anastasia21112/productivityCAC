package com.example.productivitycac;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import android.widget.LinearLayout;
public class ToDoList extends AppCompatActivity {

    //TODO: try to get todo list to save to a global arraylist: https://stackoverflow.com/questions/36069886/how-to-create-an-arraylist-that-is-accessible-by-different-classes-in-android
    protected static TableLayout tableLayout;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_list);
        tableLayout = (TableLayout) findViewById(R.id.table);
        //extractData();
    }

    public void addRow(TableLayout table, String name, Double time, int rowNum)
    {
        TableRow row = new TableRow(this);
        row.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        row.setWeightSum(1.0f);

        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(name);
        checkBox.setTextColor(Color.WHITE);
        checkBox.setGravity(Gravity.LEFT);

        TextView taskTime = new TextView(this);
        String timeString = time + "";
        taskTime.setText(timeString);
        taskTime.setTextColor(Color.WHITE);
        taskTime.setGravity(Gravity.RIGHT);

        //row.setGravity(Gravity.LEFT);
        taskTime.setGravity(Gravity.RIGHT);



        row.addView(checkBox);

        row.addView(taskTime);
        table.addView(row);

        row.setMinimumWidth(checkBox.getWidth() + taskTime.getWidth());

        table.setVisibility(View.VISIBLE);
    }
    public void sendMessage(View view) {
        // Do something in response to button
    }

    public void backToListOfLists(View v)
    {
        Intent intent = new Intent(this, list_of_lists.class);
        startActivity(intent);
    }

    public void toCreateNewTask(View v)
    {

        Intent intent = new Intent(this, CreateNewTaskActivity.class);
        startActivity(intent);
    }

    public void toTimer(View v)
    {
        Intent intent = new Intent(this, StopwatchActivity.class);
        startActivity(intent);
    }

    public void extractData()
    {
        Log.i("we are here?", "next....");
        Map allLists = ListManager.listManager;

        Log.i("here", "the size is " + allLists.size());
        for (Object keys : allLists.keySet())
        {
            Log.i("da keys", "this is the key: " + keys);

        }

        Iterator iterator = allLists.entrySet().iterator();
        Log.i("we are here?", "next...." + iterator.hasNext());


        while(iterator.hasNext())
        {
            Log.i("WE ARE HERE: ", "hereeeee NOW ");
            Map.Entry list = (Map.Entry)iterator.next();

            String listName = (String) list.getKey();
            ArrayList<Object> listTasks = (ArrayList<Object>) list.getValue();
            Log.i("size: ", "" + listTasks.size());
            for(int i = 0; i < listTasks.size(); i++)
            {
                ArrayList<Object> task =  (ArrayList<Object>) listTasks.get(i);
                String taskName = (String) task.get(0);
                Double taskDuration = Double.parseDouble(task.get(1) + "");
                Log.i("task name: ", taskName);
                Log.i("task duration: ", "" + taskDuration);
                addRow(tableLayout, taskName, taskDuration, i);

            }

        }
    }


}
