package ru.baturina.anna.bakeryfrag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FragmentListActivity extends AppCompatActivity implements ProductListFragment.ProductListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//            onItemClicked(0);  //открытие по умолчанию 1-го элемента списка


    }

    @Override
    public void onItemClicked(int id) {

        View fragmentContainer = findViewById(R.id.detailsFragment);
        if (fragmentContainer !=null) {

            DetailsFragment detailsFragment = new DetailsFragment();
            detailsFragment.setProductID(id);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.detailsFragment, detailsFragment);
            fragmentTransaction.commit(); // надувание в контейнере
           
        } else {
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.putExtra(DetailsActivity.PRODUCT_ID, id);
        startActivity(intent);
    }

    }
}


