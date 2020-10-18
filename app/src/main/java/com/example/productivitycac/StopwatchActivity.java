package com.example.productivitycac;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StopwatchActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    private ImageButton b1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stopwatch_activity_main);

        chronometer = findViewById(R.id.chronometer);

        b1 = (ImageButton) findViewById(R.id.stopwatch_backbutton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.user_dashboard);
            }
        });
    }

    public void nextActivity(View v)
    {
        setContentView(R.layout.createnewtask_activity);
    }
    public void startChronometer(View v)
    {
        if(!running)
        {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View v)
    {
        if(running)
        {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void resetChronometer(View v)
    {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    /*public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        }

    }*/
}
