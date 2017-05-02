package ru.baturina.anna.adapterpictures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {

    private LayoutInflater inflater;
    private int layout;
    private List<Exercise> exercises;

    public ExerciseAdapter(Context context, int resource, List<Exercise> exercises) {
        super(context, resource, exercises);
        this.exercises = exercises;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = (ImageView) view.findViewById(R.id.flag);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView capitalView = (TextView) view.findViewById(R.id.capital);

        Exercise exercise = exercises.get(position);

        flagView.setImageResource(exercise.getImageId());
        nameView.setText(exercise.getName());
        capitalView.setText(exercise.getDescription());

        return view;
    }
}