package com.example.productivitycac;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LoginActivity  extends AppCompatActivity {

    EditText username = (EditText) findViewById(R.id.editText1);
    EditText password = (EditText) findViewById(R.id.editText2);

    public void login(View view) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {

            //correcct password
        } else {
            //wrong password
        }
    }
}

