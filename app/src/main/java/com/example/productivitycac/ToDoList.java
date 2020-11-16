package com.example.productivitycac;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
public class ToDoList extends AppCompatActivity {

    //TODO: try to get todo list to save to a global arraylist: https://stackoverflow.com/questions/36069886/how-to-create-an-arraylist-that-is-accessible-by-different-classes-in-android
    protected static TableLayout tableLayout;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_list);
        //tableLayout = (TableLayout) findViewById(R.id.table);
        //extractData();
        init();
    }

    public void init() {
        TableLayout stk = (TableLayout) findViewById(R.id.table);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText(" Sl.No ");
        tv0.setTextColor(Color.WHITE);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(" Product ");
        tv1.setTextColor(Color.WHITE);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(" Unit Price ");
        tv2.setTextColor(Color.WHITE);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText(" Stock Remaining ");
        tv3.setTextColor(Color.WHITE);
        tbrow0.addView(tv3);
        stk.addView(tbrow0);
        for (int i = 0; i < 25; i++) {
            TableRow tbrow = new TableRow(this);
            TextView t1v = new TextView(this);
            t1v.setText("" + i);
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            TextView t2v = new TextView(this);
            t2v.setText("Product " + i);
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            TextView t3v = new TextView(this);
            t3v.setText("Rs." + i);
            t3v.setTextColor(Color.WHITE);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            TextView t4v = new TextView(this);
            t4v.setText("" + i * 15 / 32 * 10);
            t4v.setTextColor(Color.WHITE);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);
            stk.addView(tbrow);
        }

    }

    public void addRow(String name, Double time, int rowNum)
    {
        TableRow row = new TableRow(this);

        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(name);

        TextView taskTime = new TextView(this);
        String timeString = time + "";
        taskTime.setText(timeString);

        row.addView(checkBox);
        row.addView(taskTime);
        tableLayout.addView(row);
        tableLayout.setVisibility(View.VISIBLE);
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
        Map allLists = ListManager.listManager;

        Iterator iterator = allLists.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry list = (Map.Entry)iterator.next();

            String listName = (String) list.getKey();
            ArrayList<Object> listTasks = (ArrayList<Object>) list.getValue();

            for(int i = 0; i < listTasks.size(); i++)
            {
                ArrayList<Object> task =  (ArrayList<Object>) listTasks.get(i);
                String taskName = (String) task.get(0);
                Double taskDuration = (Double) task.get(1);
                Log.i("task name: ", taskName);
                Log.i("task duration: ", "" + taskDuration);
                addRow(taskName, taskDuration, i);
            }

        }
    }


}
