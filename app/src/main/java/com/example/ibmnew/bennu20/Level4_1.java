package com.example.ibmnew.bennu20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Level4_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_level4_1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        final ImageView choice1 = (ImageView)findViewById(R.id.choice1);
        final ImageView choice2 = (ImageView)findViewById(R.id.choice2);
        final ImageView choice3 = (ImageView)findViewById(R.id.choice3);
        final ImageView choice4 = (ImageView)findViewById(R.id.choice4);

        choice1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                choice1.setImageResource(R.drawable.wrong);
                return false;
            }
        });

        choice2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                choice2.setImageResource(R.drawable.right);
                Intent intent = new Intent(Level4_1.this, Level4_2.class);
                startActivity(intent);
                return false;
            }
        });

        choice3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                choice3.setImageResource(R.drawable.wrong);
                return false;
            }
        });

        choice4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                choice4.setImageResource(R.drawable.wrong);
                return false;
            }
        });
    }
}
