package ru.baturina.anna.bakeryfrag;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsFragment extends Fragment {

    private int workoutID =1;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Context context = getActivity();
        //контекст возвращает фрагмент активити, в которой он ращмещается
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();
        if (view !=null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            TextView decription = (TextView) view.findViewById(R.id.textDescription);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageWorkout);

            Workout workout = Workout.workouts[workoutID];
            title.setText(workout.getName());
            decription.setText(workout.getDescription());
            imageView.setImageResource(workout.getImageResourceId());
        }
    }


    public void setWorkoutID(int id){
        workoutID = id;
    }

}
