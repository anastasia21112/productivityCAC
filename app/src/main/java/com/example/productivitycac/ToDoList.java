package com.example.productivitycac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TableRow;
import android.widget.Button;

public class ToDoList extends AppCompatActivity {

    TableLayout tableLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_list);

        //tableLayout = new TableLayout(this.getApplicationContext());
        tableLayout = (TableLayout) findViewById(R.id.table);

        TableRow row = new TableRow(this);

        tableLayout.addView(row);
        Button button = new Button(this);
        button.setText("hello");

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
