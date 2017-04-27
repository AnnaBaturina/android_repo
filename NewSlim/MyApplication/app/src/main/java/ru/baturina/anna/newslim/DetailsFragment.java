package ru.baturina.anna.newslim;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    private int exerciseID;
    private final String STOPWATCH_FRAME_TAG = "7a1d5f70-93a0-4bc4-b5fc-3dbd041a2413";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentManager fragmentManager = getChildFragmentManager();
        StopwatchFragment stopwatchFragment = (StopwatchFragment) fragmentManager.findFragmentByTag(STOPWATCH_FRAME_TAG);
        if (stopwatchFragment == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            stopwatchFragment = new StopwatchFragment();
            fragmentTransaction.replace(R.id.stopwatch_container, stopwatchFragment, STOPWATCH_FRAME_TAG);
            fragmentTransaction.commit();

        }

//  Inflate the layout for this fragment:


        Context context = getActivity();   //контекст активити, в которой он размещен

        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        return rootView;

        // //  поиск элемента через rootView
        // //  TextView textView = rootView.findViewById(R.)
        // //можно сразу:
        // // return inflater.inflate(R.layout.fragment_details, container, false);

    }


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();

        if (view != null) {
            //это тот самый rootView из метода onCreateView
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            ImageView image = (ImageView) view.findViewById(R.id.imageExercise);

            //достаем информацию из класса Exercises (exersiseID = 0 элемент массива)
            Exercises exercise = Exercises.exercises[exerciseID];
            title.setText(exercise.getName());
            description.setText(exercise.getDescription());
            image.setImageResource(exercise.getImageId());



        }
    }

    public void setExerciseId(int id) {
        exerciseID = id;

    }


}
