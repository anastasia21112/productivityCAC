package com.example.productivitycac;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dashboard);
    }


    public void toListList(View v)
    {
        setContentView(R.layout.activity_list_of_lists);
    }


//    @Override
//    public boolean onKeyUp(int keyCode, KeyEvent objEvent) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            onBackPressed();
//            return true;
//        }
//        return super.onKeyUp(keyCode, objEvent);
//    }
//
//    @Override
//    public void onBackPressed() {
//        finish();
//    }
//
//    @Override
//    public void finish() {
//
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("Are you sure you want to logout?");
//        builder.setTitle("ALERT");
//        builder.setCancelable(false);
//
//        builder
//                .setPositiveButton(
//                        "Yes",
//                        new DialogInterface
//                                .OnClickListener() {
//
//                            @Override
//                            public void onClick(DialogInterface dialog,
//                                                int which)
//                            {
//
//                                setContentView(R.layout.activity_login);
//                            }
//                        });
//
//        builder
//                .setNegativeButton(
//                        "No",
//                        new DialogInterface
//                                .OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog,
//                                                int which)
//                            {
//                                finish();
//                            }
//                        }
//                );
//
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//
//
//
//
//    }








    }


