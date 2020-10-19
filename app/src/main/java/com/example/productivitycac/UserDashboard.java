package com.example.productivitycac;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class UserDashboard extends AppCompatActivity {

    private Button viewList, getHelp;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        viewList = (Button) findViewById(R.id.view_list_button);
        getHelp = (Button) findViewById(R.id.button);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dashboard);
        userTutorial();
    }


    public void toListList(View v)
    {
        Intent intent = new Intent(this, list_of_lists.class);
        startActivity(intent);
    }

    public void userTutorial()
    {
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "SHOW1_ID");

        sequence.setConfig(config);

        sequence.addSequenceItem(viewList,
                "View your to-do lists here", "GOT IT");
        sequence.addSequenceItem(getHelp, "View extended tutorials here", "GOT IT");

        sequence.start();
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


