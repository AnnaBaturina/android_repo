package ru.baturina.anna.newslim;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static ru.baturina.anna.newslim.DetailsActivity.EXERCISE_ID;

public class ExercisesListFragment extends ListFragment {

    private ExerciseListener listener;

    public interface ExerciseListener {
        void onItemClicked(int id);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, getStringArray(Exercises.exercises));
        setListAdapter(adapter);

//вызываем супер-метод OnCreateView
        return super.onCreateView(inflater,container,savedInstanceState);
    }


    private String[] getStringArray(Exercises[] exercises) {

        String[] array = new String[exercises.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = getResources().getString(exercises[i].getName());
        }
        return array;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (ExerciseListener) context;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    if (listener !=null) {
        listener.onItemClicked(position);

    }
    }

}
