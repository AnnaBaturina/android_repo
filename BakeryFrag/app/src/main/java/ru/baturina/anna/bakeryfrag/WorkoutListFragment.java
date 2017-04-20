package ru.baturina.anna.bakeryfrag;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class WorkoutListFragment extends ListFragment {

    private WorkoutListener listener;

    public WorkoutListFragment() {
        // Required empty public constructor
    }

    public  interface WorkoutListener{
        void onItemClicked(int id);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Массив имен
        String[]names= new String[Workout.workouts.length];
        for (int i=0; i<names.length; i++){
            names[i] = Workout.workouts[i].getName();
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (WorkoutListener) context;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (listener !=null) {
            listener.onItemClicked(position);
        }
    }
}
