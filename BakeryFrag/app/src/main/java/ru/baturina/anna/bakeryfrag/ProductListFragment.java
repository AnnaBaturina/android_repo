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

    public static final String BAKED = "baked";
    public static final String CONFECTIONERY = "confectionery";
    public static final String CHOCOLATE = "chocolate";
    public static final String ADDRESS = "address";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        if ((TopActivity.product).equals(BAKED)) {

//            String[] names = new String[Product.breads.length];
//            for (int i = 0; i < names.length; i++) {
//                names[i] = Product.breads[i].getName();
//           }
//            // если оставлять имена в String харкодом в Product

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.beautiful_list, getStringArray(Product.breads));
            setListAdapter(adapter);
        }

        if ((TopActivity.product).equals(CONFECTIONERY)) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.beautiful_list, getStringArray(Product.confects));
            setListAdapter(adapter);
        }

        if ((TopActivity.product).equals(CHOCOLATE)) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.beautiful_list, getStringArray(Product.chocolates));
            setListAdapter(adapter);

        } else if ((TopActivity.product).equals(ADDRESS)) {
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


//получить массив имен
    private String[] getStringArray(Product[] products) {
        int count = products.length;
        String[] array = new String[count];
        for (int i = 0; i < count; i++) {
            array[i] = getResources().getString(products[i].getName());
        }
        return array;
    }

}
