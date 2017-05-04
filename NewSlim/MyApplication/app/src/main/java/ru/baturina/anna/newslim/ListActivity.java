package ru.baturina.anna.newslim;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, Object>> mCatList;
    private static final String TITLE = "catname"; // Верхний текст
    private static final String DESCRIPTION = "description"; // ниже главного
    private static final String ICON = "icon";  // будущая картинка


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_activity);

        ListView listView = (ListView) findViewById(R.id.listView);

        // создаем массив списков
        mCatList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hm;

        hm = new HashMap<>();
        hm.put(TITLE, "Рыжик"); // Название
        hm.put(DESCRIPTION, "Рыжий и хитрый"); // Описание
        hm.put(ICON, R.drawable.boat); // Картинка
        mCatList.add(hm);

        hm = new HashMap<>();
        hm.put(TITLE, "Васька");
        hm.put(DESCRIPTION, "Слушает да ест");
        hm.put(ICON, R.drawable.kikbek);
        mCatList.add(hm);

        hm = new HashMap<>();
        hm.put(TITLE, "Мурзик");
        hm.put(DESCRIPTION, "Спит и мурлыкает");
        hm.put(ICON, R.drawable.squat);
        mCatList.add(hm);

        hm = new HashMap<>();
        hm.put(TITLE, "Барсик");
        hm.put(DESCRIPTION, "Болеет за Барселону");
        hm.put(ICON, R.drawable.riveting);
        mCatList.add(hm);

        SimpleAdapter adapter = new SimpleAdapter(this, mCatList,
                R.layout.list_item_with_pic, new String[]{TITLE, DESCRIPTION, ICON},
                new int[]{R.id.text1, R.id.text2, R.id.img});

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(itemClickListener);
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            HashMap<String, Object> itemHashMap = (HashMap <String, Object>) parent.getItemAtPosition(position);
            String titleItem = itemHashMap.get(TITLE).toString();
            String descriptionItem = itemHashMap.get(DESCRIPTION).toString();
            int imageItem = (int)itemHashMap.get(ICON);
            Toast.makeText(getApplicationContext(),
                    "Вы выбрали " + titleItem + ". Он " + descriptionItem, Toast.LENGTH_SHORT).show();
        }
    };
}