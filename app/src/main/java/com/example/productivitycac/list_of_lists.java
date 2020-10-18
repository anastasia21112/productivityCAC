package com.example.productivitycac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class list_of_lists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_lists);
    }

    public void toHomeworkList(View v)
    {
        setContentView(R.layout.to_do_list);
    }
}