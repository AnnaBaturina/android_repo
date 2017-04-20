package ru.baturina.anna.bakeryfrag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;


public class TopActivity extends AppCompatActivity implements View.OnClickListener {

    public static String product = "";

    public static final String BAKED = "baked";
    public static final String CONFECTIONERY = "confectionery";
    public static final String CHOCOLATE = "chocolate";
    public static final String ADDRESS = "address";

    private LinearLayout bread;
    private LinearLayout confect;
    private LinearLayout chocolate;
    private LinearLayout address;
//    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        bread = (LinearLayout) findViewById(R.id.option1);
        confect = (LinearLayout) findViewById(R.id.option2);
        chocolate = (LinearLayout) findViewById(R.id.option3);
        address = (LinearLayout) findViewById(R.id.option4);

        bread.setOnClickListener(this);
        confect.setOnClickListener(this);
        chocolate.setOnClickListener(this);
        address.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Log.d("TopActivity", "onClick: ");


        if (view.equals(bread)) {
            product = BAKED;
        }

        if (view.equals(confect)) {
            product = CONFECTIONERY;
        }

        if (view.equals(chocolate)) {
            product = CHOCOLATE;
        }
        if (view.equals(address)) {
            product = ADDRESS;
        }

        Intent intent = new Intent(this, FragmentListActivity.class);
        startActivity(intent);

    }
}

