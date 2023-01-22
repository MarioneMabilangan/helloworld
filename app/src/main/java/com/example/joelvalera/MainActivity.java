package com.example.joelvalera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements Runnable{
    Toolbar toolbar;
    private boolean running;
    private ImageButton img1,img2,img3,img4,img5,img6, img7, img8;
    private int []values= {1,2,3,4,1,2,3,4};
    private ImageButton imgButtons [];
    private int score;
    private int valordef= -1;
    private int fail = 0;
    AnimationDrawable horanimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        score = 0;
        ImageView hora = (ImageView) findViewById(R.id.imageView);
        hora.setBackgroundResource(R.drawable.hora);
        horanimation = (AnimationDrawable) hora.getBackground();
        startGame();
        Animation in = AnimationUtils.loadAnimation(this, R.anim.uwu2);
        imgButtons = new ImageButton[] {img1,img2,img3,img4,img5,img6, img7, img8};
        random();
        addJoel();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        horanimation.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.arrow_right:
                Intent intent = new Intent(MainActivity.this, Joel1.class);
                startActivity(intent);
                return true;
            case R.id.perfil:
                Intent intent2 = new Intent(MainActivity.this, Perfil.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private Handler bridges = new Handler(){

        @Override
        public void handleMessage(Message msg){
            Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.fi_cnsuxl_question_mark);
            imgButtons[valordef].setImageBitmap(Bitmap.createScaledBitmap(bmp, 180, 180, false));
            valordef = -1;
            imgButtons[fail].setImageBitmap(Bitmap.createScaledBitmap(bmp, 180, 180, false));
        }
    };

    private void controller(int option, ImageButton img){
        Animation out = AnimationUtils.loadAnimation(this, R.anim.uwu);
        Bitmap bmp = null;
        option--;
        switch (values[option]){
            case 1: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.joelsadin); break;
            case 2: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.img_20220401_192657_removebg_preview); break;
            case 3: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.image_2023_01_12_171250508_removebg_preview); break;
            case 4: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.image_2023_01_12_172158210_removebg_preview); break;
        }
        if (valordef == -1){
            valordef = option;
            img.startAnimation(out);
            img.setImageBitmap(Bitmap.createScaledBitmap(bmp, 180, 180, false));
        }
        else{
            if(values[valordef] == values[option]){
                score++;
                img.startAnimation(out);
                img.setImageBitmap(Bitmap.createScaledBitmap(bmp, 180, 180, false));
                valordef = -1;
                if(score == 4){
                    Toast.makeText(this, "Fi del joc", Toast.LENGTH_SHORT).show();
                }
            } else{
                fail = option;
                img.startAnimation(out);
                img.setImageBitmap(Bitmap.createScaledBitmap(bmp, 180, 180, false));
                Thread thread = new Thread(this);
                thread.start();
            }
        }
    }

    public void startGame(){
        img1 = (ImageButton) findViewById(R.id.imageButton);
        img2 = (ImageButton) findViewById(R.id.imageButton2);
        img3 = (ImageButton) findViewById(R.id.imageButton3);
        img4 = (ImageButton) findViewById(R.id.imageButton4);
        img5 = (ImageButton) findViewById(R.id.imageButton5);
        img6 = (ImageButton) findViewById(R.id.imageButton6);
        img7 = (ImageButton) findViewById(R.id.imageButton7);
        img8 = (ImageButton) findViewById(R.id.imageButton8);
    }

    private void random(){
        Random random = new Random();
        int as, bs;

        for(int i=0; i<values.length; i++){
            as=values[i];
            bs = random.nextInt(2);

            values[i] = values[bs];
            values[bs] = as;
        }
    }

    public void addJoel(){
        Animation out = AnimationUtils.loadAnimation(this, R.anim.uwu);
        Animation in = AnimationUtils.loadAnimation(this, R.anim.uwu2);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller(1, img1);
                img1.startAnimation(out);


            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller(2, img2);
                img2.startAnimation(out);

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller(3, img3);
                img3.startAnimation(out);

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller(4, img4);
                img4.startAnimation(out);

            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller(5, img5);
                img5.startAnimation(out);

            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller(6, img6);
                img6.startAnimation(out);

            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller(7, img7);
                img7.startAnimation(out);

            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller(8, img8);
                img8.startAnimation(out);

            }
        });
    }

    @Override
    public void run() {
        SystemClock.sleep(150);
        Message msg = new Message();
        msg.obj = 10;
        bridges.sendMessage(msg);
    }
}