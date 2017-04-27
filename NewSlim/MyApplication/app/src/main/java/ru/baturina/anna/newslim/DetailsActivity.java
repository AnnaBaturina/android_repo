package ru.baturina.anna.newslim;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    public static final String EXERCISE_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.details_fragment);
        detailsFragment.setExerciseId(getIntent().getIntExtra(EXERCISE_ID, 0));

////Actionbar

        getSupportActionBar().setTitle(Exercises.exercises[getIntent().getIntExtra(EXERCISE_ID, 0)].getName());
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));



    }
}
