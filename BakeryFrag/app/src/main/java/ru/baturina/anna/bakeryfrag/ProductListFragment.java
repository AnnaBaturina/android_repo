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

    private ProductListener listener;

    public ProductListFragment() {
        // Required empty public constructor
    }

    public interface ProductListener {
        void onItemClicked(int id);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Массив имен

        if ((TopActivity.product).equals("baked")) {
//            String[] names = new String[Product.breads.length];
//            for (int i = 0; i < names.length; i++) {
//                names[i] = Product.breads[i].getName();
//           }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.beautiful_list, getStringArray(Product.breads));
            setListAdapter(adapter);
        }

        if ((TopActivity.product).equals("confectionery")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.beautiful_list, getStringArray(Product.confects));
            setListAdapter(adapter);
        }

        if ((TopActivity.product).equals("chocolate")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.beautiful_list, getStringArray(Product.chocolates));
            setListAdapter(adapter);

        } else if ((TopActivity.product).equals("address")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.beautiful_list, getStringArray(Product.addresses));
            setListAdapter(adapter);
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (ProductListener) context;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (listener != null) {
            listener.onItemClicked(position);
        }
    }



    private String[] getStringArray(Product[] products) {
        int count = products.length;
        String[] array = new String[count];
        for (int i = 0; i < count; i++) {
            array[i] = getResources().getString(products[i].getName());
        }
        return array;
    }

}
