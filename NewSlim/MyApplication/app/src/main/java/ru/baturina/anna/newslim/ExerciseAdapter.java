package ru.baturina.anna.newslim;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ExerciseAdapter extends BaseAdapter {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imageId;

    public ExerciseAdapter(Activity context, String[] itemname, Integer [] imageId) {
        this.context = context;
        this.itemname = itemname;
        this.imageId =imageId;
    }

    @Override
    public int getCount() {
        return itemname.length;
    }

    @Override
    public Object getItem(int position) {
        return itemname[position];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View myView=inflater.inflate(R.layout.list_item_with_pic, null, true);

        ImageView flagView = (ImageView) myView.findViewById(R.id.img);
        TextView nameView = (TextView) myView.findViewById(R.id.text1);
//        TextView capitalView = (TextView) myView.findViewById(R.id.capital);


        flagView.setImageResource(imageId[position]);
        nameView.setText(itemname[position]);
//        capitalView.setText(exercise.getDescription());

        return myView;
    }


}