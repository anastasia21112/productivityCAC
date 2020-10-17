package com.example.productivitycac;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ToDoList extends AppCompatActivity {
        Button b1;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.to_do_list);

            b1 = (Button)findViewById(R.id.add_task);

        }

        public void sendMessage(View view) {
            // Do something in response to button
        }
}
