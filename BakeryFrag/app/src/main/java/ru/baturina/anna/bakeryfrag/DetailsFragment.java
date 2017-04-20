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

    private int productID = 0;

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
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            TextView decription = (TextView) view.findViewById(R.id.textDescription);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageProduct);


            if((TopActivity.product).equals("baked")) {
                Product product = Product.breads[productID];

                title.setText(product.getName());
                decription.setText(product.getDescription());
                imageView.setImageResource(product.getImageResourceId());
            }

            if((TopActivity.product).equals("confectionery")) {
                Product product = Product.confects[productID];

                title.setText(product.getName());
                decription.setText(product.getDescription());
                imageView.setImageResource(product.getImageResourceId());
            }

            if((TopActivity.product).equals("chocolate")) {
                Product product = Product.chocolates[productID];

                title.setText(product.getName());
                decription.setText(product.getDescription());
                imageView.setImageResource(product.getImageResourceId());
            }

            if((TopActivity.product).equals("address")) {
                Product product = Product.addresses[productID];

                title.setText(product.getName());
                decription.setText(product.getDescription());
                imageView.setImageResource(product.getImageResourceId());
            }

    }

}


    public void setProductID(int id) {
        productID = id;
    }

}




//            if((TopActivity.product).equals("baked")){
//            ArrayAdapter<Product> listAdapter=new ArrayAdapter<>(this,R.layout.beautiful_list,Product.breads);
//        listProducts.setAdapter(listAdapter);
//        }
//
//        if((TopActivity.product).equals("confect")){
//        ArrayAdapter<Product> listAdapter=new ArrayAdapter<>(this,R.layout.beautiful_list,Product.confects);
//        listProducts.setAdapter(listAdapter);
//        }
//
//        if((TopActivity.product).equals("chocolate")){
//        ArrayAdapter<Product> listAdapter=new ArrayAdapter<>(this,R.layout.beautiful_list,Product.chocolates);
//        listProducts.setAdapter(listAdapter);
//        }
//
//        if((TopActivity.product).equals("address")){
//        ArrayAdapter<Product> listAdapter=new ArrayAdapter<>(this,R.layout.beautiful_list,Product.addresses);
//        listProducts.setAdapter(listAdapter);
//        }
//
//