package ru.baturina.anna.newslim;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements ExercisesListFragment.ExerciseListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View fragmentContainer = findViewById(R.id.detailsFragment);
        if (fragmentContainer !=null) {
            onItemClicked(openFirstRandom(Exercises.exercises));  //открытие рандомного упражнения при перови открытии
        }


    }

    @Override
    public void onItemClicked(int id) {
        //создаем инстанс фрагмента
        DetailsFragment detailsFragment = new DetailsFragment();
        //динамически создаем фрагмент и сетим его поверх существующего:
        detailsFragment.setExerciseId(id);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.detailsFragment, detailsFragment);
        fragmentTransaction.commit();
    }



    public int openFirstRandom (Exercises [] exercises){
        return (int)(Math.random()*exercises.length);
        //рандомное число в пределах длины массива
    }


}
