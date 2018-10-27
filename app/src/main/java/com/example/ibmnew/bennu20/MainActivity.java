package com.example.ibmnew.bennu20;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    public ImageView[] levels =  new ImageView[6];
    public Boolean[] on = new Boolean[6];
    public String mssg = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        ImageView minilogo = (ImageView)findViewById(R.id.minilogo);
        minilogo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String url = "https://2018.spaceappschallenge.org/challenges/volcanoes-icebergs-and-asteroids-oh-my/hello-bennu-osiris-rex/teams/itc-team/project";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                return false;
            }
        });

        TouchB tb = new TouchB();
       ImageView bennu =(ImageView)findViewById(R.id.bennu);
        bennu.setOnTouchListener(tb);


        InitLevels();

        if(getIntent().hasExtra("level") ==  true) {
            mssg = getIntent().getStringExtra("level");

            switch(mssg){
                case "7":
                    levels[5].setImageResource(R.drawable.level6green);
                case "6":
                    levels[4].setImageResource(R.drawable.level5green);
                    on[5] = true;
                    if(mssg.equals("6"))
                        levels[5].setImageResource(R.drawable.level6);
                    ImageView flech5 = (ImageView)findViewById(R.id.flech5);
                    flech5.setImageResource(R.drawable.fleche5green);
                case "5":
                    levels[3].setImageResource(R.drawable.level4green);
                    on[4] = true;
                    if(mssg.equals("5"))
                        levels[4].setImageResource(R.drawable.level5);
                    ImageView flech4 =(ImageView)findViewById(R.id.flech4);
                    flech4.setImageResource(R.drawable.fleche4green);
                case "4":
                    levels[2].setImageResource(R.drawable.level3green);
                    on[3] = true;
                    if(mssg.equals("4"))
                        levels[3].setImageResource(R.drawable.level4);
                    ImageView flech3 =(ImageView)findViewById(R.id.flech3);
                    flech3.setImageResource(R.drawable.fleche3green);
                case "3":
                    levels[1].setImageResource(R.drawable.level2green);
                    on[2] = true;
                    if(mssg.equals("3"))
                        levels[2].setImageResource(R.drawable.level3);
                    ImageView flech2 =(ImageView)findViewById(R.id.flech2);
                    flech2.setImageResource(R.drawable.fleche2green);
                case "2":
                    levels[0].setImageResource(R.drawable.level1green);
                    on[1] = true;
                    if(mssg.equals("2"))
                        levels[1].setImageResource(R.drawable.level2);
                    ImageView flech1 =(ImageView)findViewById(R.id.flech1);
                    flech1.setImageResource(R.drawable.fleche1green);
                break;
            }
        }

        Actions();
    }

    private void Actions() {

        levels[0].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(on[0]){
                     Intent intent = new Intent(MainActivity.this, Level1_1.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "this level is locked", Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        levels[1].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(on[1]){
                    Intent intent = new Intent(MainActivity.this, Level2_1.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "this level is locked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        levels[2].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(on[2]){
                    Intent intent = new Intent(MainActivity.this, Level3_1.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "this level is locked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        levels[3].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(on[3]){
                    Intent intent = new Intent(MainActivity.this, Level4_1.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "this level is locked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        levels[4].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(on[4]){
                    Intent intent = new Intent(MainActivity.this, Level5_1.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "this level is locked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        levels[5].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(on[5]){
                    Intent intent = new Intent(MainActivity.this, Level6_1.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "this level is locked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    public void InitLevels(){

        levels[0] = (ImageView)findViewById(R.id.level1);
        levels[1] = (ImageView)findViewById(R.id.level2);
        levels[2] = (ImageView)findViewById(R.id.level3);
        levels[3] = (ImageView)findViewById(R.id.level4);
        levels[4] = (ImageView)findViewById(R.id.level5);
        levels[5] = (ImageView)findViewById(R.id.level6);
        on[0] = true;
        for(int i = 1; i < 6; i++)
            on[i] = false;
    }

    public class TouchB implements View.OnTouchListener{
        int i = 2;
        ImageView v1 ;
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            v1 = (ImageView) v;
            if(i%2 == 0)
                v1.setImageResource(R.drawable.bennu1);
            else
                v1.setImageResource(R.drawable.bennu);
            i++;
            return false;
        }
    }


}
