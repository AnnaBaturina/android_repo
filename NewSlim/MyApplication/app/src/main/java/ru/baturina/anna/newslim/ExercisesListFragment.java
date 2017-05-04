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


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.list_item, getStringArray(Exercises.exercises));
        setListAdapter(adapter);

//вызываем супер-метод OnCreateView
        return super.onCreateView(inflater,container,savedInstanceState);
    }

//для списка
    private String[] getStringArray(Exercises[] exercises) {

        String[] array = new String[exercises.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = getResources().getString(exercises[i].getName());
        }
        return array;
    }

//для списка с картинками
    private Integer[] getImageId(Exercises[]exercises) {
        int count = exercises.length;
        Integer[] array = new Integer[count];
        for (int i = 0; i < count; i++) {
            array[i] = exercises[i].getImageId();
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
