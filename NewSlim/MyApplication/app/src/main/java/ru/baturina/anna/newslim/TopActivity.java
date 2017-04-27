package ru.baturina.anna.newslim;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TopActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        Button button = (Button) findViewById(R.id.begin);
button.setOnClickListener(this);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
        getSupportActionBar().setTitle(R.string.exercisesforlist);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.begin) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
