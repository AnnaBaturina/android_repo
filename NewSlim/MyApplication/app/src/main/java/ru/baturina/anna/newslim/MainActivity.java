package ru.baturina.anna.newslim;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;

import java.util.Random;

import static ru.baturina.anna.newslim.DetailsActivity.EXERCISE_ID;

public class MainActivity extends AppCompatActivity implements ExercisesListFragment.ExerciseListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View fragmentContainer = findViewById(R.id.detailsFragment);
        if (fragmentContainer !=null) {
            onItemClicked(openFirstRandom(Exercises.exercises));  //открытие рандомного упражнения при перови открытии
        }

        //цвет
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
        getSupportActionBar().setTitle(R.string.exercisesforlist);
    }

    @Override
    public void onItemClicked(int id) {
        View fragmentContainer = findViewById(R.id.detailsFragment);
        if (fragmentContainer != null) {
            //создаем инстанс фрагмента
            DetailsFragment detailsFragment = new DetailsFragment();
            //динамически создаем фрагмент и сетим его поверх существующего:
            detailsFragment.setExerciseId(id);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.detailsFragment, detailsFragment);
            fragmentTransaction.commit();
        } else {
            Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
            intent.putExtra(DetailsActivity.EXERCISE_ID, id);
            startActivity(intent);

        }

    }



    public int openFirstRandom (Exercises [] exercises){
        return (int)(Math.random()*exercises.length);
        //рандомное число в пределах длины массива
    }


}
