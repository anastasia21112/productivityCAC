package com.example.productivitycac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ToDoList extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_list);


    }

//    public void addNewListItem(View view)
//    {
//        TextView receiverName_msg = (TextView) findViewById(R.id.task10);
//        Intent intentName = getIntent();
//        String newTaskName = intentName.getStringExtra("taskName");
//        receiverName_msg.setText(newTaskName);
//
//        TextView receiverTime_msg = (TextView) findViewById(R.id.task10Time);
//        Intent intentTime = getIntent();
//        String newTaskTime = intentTime.getStringExtra("taskTime");
//        receiverTime_msg.setText(newTaskTime);
//
//        TableRow layout = (TableRow) findViewById(R.id.tableRow10);
//        layout.setVisibility(View.VISIBLE);
//    }

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
