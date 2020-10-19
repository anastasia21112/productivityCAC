package com.example.productivitycac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ToDoList extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_list);

        TextView receiverName_msg = (TextView) findViewById(R.id.task10);
        Intent intentName = getIntent();
        String newtaskName = intentName.getStringExtra("taskName");
        receiverName_msg.setText(newtaskName);

        TextView receiverTime_msg = (TextView) findViewById(R.id.task10Time);
        Intent intentTime = getIntent();
        String newtaskTime = intentTime.getStringExtra("taskTime");
        receiverTime_msg.setText(newtaskTime);
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
