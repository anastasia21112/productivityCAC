package com.example.productivitycac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ToDoList1 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_list1);

    }


    public void toTimer(View v)
    {

        Intent intent = new Intent(this, StopwatchActivity.class);
        startActivity(intent);
    }

}