package ru.baturina.anna.newslim;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class TopActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        final Button button = (Button) findViewById(R.id.begin);
        button.setOnClickListener(this);


        ImageView mandala1 = (ImageView) findViewById(R.id.mandala1);
        ImageView mandala2 = (ImageView) findViewById(R.id.mandala2);
        ImageView mandala3 = (ImageView) findViewById(R.id.mandala3);
        ImageView mandala4 = (ImageView) findViewById(R.id.mandala4);
        ImageView mandala5 = (ImageView) findViewById(R.id.mandala5);
        ImageView mandala6 = (ImageView) findViewById(R.id.mandala6);



        //
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(160, 46, 63)));
        getSupportActionBar().setTitle(R.string.exercisesforlist);
//        getSupportActionBar().hide();


        final Animation animationRotateCenter = AnimationUtils.loadAnimation(
                this, R.anim.rotate_center);
        final Animation animationRotateCenterBackwards = AnimationUtils.loadAnimation(
                this, R.anim.rotate_center_backwards);
       mandala1.startAnimation(animationRotateCenter);
       mandala2.startAnimation(animationRotateCenterBackwards);
       mandala3.startAnimation(animationRotateCenter);
       mandala4.startAnimation(animationRotateCenter);
       mandala5.startAnimation(animationRotateCenterBackwards);
       mandala6.startAnimation(animationRotateCenterBackwards);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.begin) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
