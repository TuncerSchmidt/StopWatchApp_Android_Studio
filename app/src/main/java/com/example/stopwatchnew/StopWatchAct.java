package com.example.stopwatchnew;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timerHere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        btnstart = findViewById(R.id.btnstart);
        icanchor = findViewById(R.id.icanchor);
        btnstop = findViewById(R.id.btnstop);
        timerHere = findViewById(R.id.timerHere);

        //create optional animation
        btnstop.setAlpha(0);
        //load animations
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        //import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        //customize font
        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                //start time
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });
    }
}