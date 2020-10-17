package com.example.productivitycac;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class CreateNewTaskActivity extends AppCompatActivity
{

    public void clickFunction(View v)
    {
        EditText taskName = findViewById(R.id.taskNameInput);
        EditText taskTime = findViewById(R.id.taskTimeInput);

        Log.i("Task Name", taskName.toString());
        Log.i("Task Time", taskTime.toString());

        Spinner spinner = (Spinner) findViewById(R.id.listOptions);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        //spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        List<String> categories = new ArrayList<String>();
        categories.add("List 1");
        categories.add("List 2");
        categories.add("List 3");
        categories.add("List 4");
        categories.add("List 5");
        categories.add("New List");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createnewtask_activity);
    }
}