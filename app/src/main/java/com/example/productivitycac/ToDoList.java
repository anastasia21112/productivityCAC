package com.example.productivitycac;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ToDoList extends AppCompatActivity {
        private ImageButton b1;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.to_do_list);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    setContentView(R.layout.createnewtask_activity);
                }
            });






        }

        public void sendMessage(View view) {
            // Do something in response to button
        }
}
