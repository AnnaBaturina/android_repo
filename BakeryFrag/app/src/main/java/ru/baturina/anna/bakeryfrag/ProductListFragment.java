package ru.baturina.anna.bakeryfrag;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ProductListFragment extends ListFragment {

    private WorkoutListener listener;

    public ProductListFragment() {
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

        if((TopActivity.product).equals("baked")) {
            String[] names = new String[Product.breads.length];
            for (int i = 0; i < names.length; i++) {
                names[i] = Product.breads[i].getName();
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.beautiful_list, names);
            setListAdapter(adapter);
        }

        if((TopActivity.product).equals("confectionery")) {
            String[] names = new String[Product.confects.length];
            for (int i = 0; i < names.length; i++) {
                names[i] = Product.confects[i].getName();
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.beautiful_list, names);
            setListAdapter(adapter);
        }

        if((TopActivity.product).equals("chocolate")) {
            String[] names = new String[Product.chocolates.length];
            for (int i = 0; i < names.length; i++) {
                names[i] = Product.chocolates[i].getName();
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.beautiful_list, names);
            setListAdapter(adapter);
        } else if((TopActivity.product).equals("address")) {
            String[] names = new String[Product.addresses.length];
            for (int i = 0; i < names.length; i++) {
                names[i] = Product.addresses[i].getName();
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.beautiful_list, names);
            setListAdapter(adapter);
        }




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
