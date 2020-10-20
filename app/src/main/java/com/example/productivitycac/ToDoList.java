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
