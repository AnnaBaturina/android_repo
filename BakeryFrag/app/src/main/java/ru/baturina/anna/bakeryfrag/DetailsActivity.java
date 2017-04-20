package ru.baturina.anna.bakeryfrag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    public static final  String WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_details);

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        detailsFragment.setWorkoutID(getIntent().getIntExtra(WORKOUT_ID,0));

    }
}
