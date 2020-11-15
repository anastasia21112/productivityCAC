package com.example.productivitycac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TableRow;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
public class ToDoList extends AppCompatActivity {

    //TODO: try to get todo list to save to a global arraylist: https://stackoverflow.com/questions/36069886/how-to-create-an-arraylist-that-is-accessible-by-different-classes-in-android
    protected static TableLayout tableLayout;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_list);
        tableLayout = (TableLayout) findViewById(R.id.table);

    }

    public void addRow(String text)
    {
        //tableLayout = new TableLayout(this.getApplicationContext());


        TableRow row = new TableRow(this.getApplicationContext());

        tableLayout.addView(row);
        Button button = new Button(this);
        button.setText(text);

        row.addView(button);
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
            }

        }
    }

}
