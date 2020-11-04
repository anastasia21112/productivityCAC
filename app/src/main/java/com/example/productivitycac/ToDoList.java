package com.example.productivitycac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TableRow;
import android.widget.Button;

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

}
