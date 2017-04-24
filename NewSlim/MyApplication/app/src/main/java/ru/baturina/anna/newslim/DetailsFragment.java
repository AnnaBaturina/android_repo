package ru.baturina.anna.newslim;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    private int exerciseID;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//  Inflate the layout for this fragment:
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
//  TextView textView = rootView.findViewById(R.)  //поиск элемента через rootView

        Context context = getActivity();   //контекст активити, в которой он размещен
        return rootView;
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

public  void setExerciseId(int id){
    exerciseID = id;
}

}
