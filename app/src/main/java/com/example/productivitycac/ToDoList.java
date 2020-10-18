package com.example.productivitycac;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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

    public void backToUserDashboard(View v)
    {
        setContentView(R.layout.user_dashboard);
    }

    public void toCreateNewTask(View v)
    {
        setContentView(R.layout.createnewtask_activity);
    }

    public void toTimer(View v)
    {
        setContentView(R.layout.stopwatch_activity_main);
    }
}
