package ru.baturina.anna.adapterpictures;


import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Exercise> exercises = new ArrayList();

    ListView exercisesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        exercisesList = (ListView) findViewById(R.id.countriesList);
        // создаем адаптер
        ExerciseAdapter stateAdapter = new ExerciseAdapter(this, R.layout.list_item, exercises);
        // устанавливаем адаптер
        exercisesList.setAdapter(stateAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                Exercise selectedExercise = (Exercise) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedExercise.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        exercisesList.setOnItemClickListener(itemListener);
    }
    private void setInitialData(){

        exercises.add(new Exercise(R.string.riverting, R.string.riverting_descr, R.drawable.riveting));
        exercises.add(new Exercise(R.string.kickback,R.string.kicjback_descr, R.drawable.kikbek));
        exercises.add(new Exercise(R.string.squat, R.string.squat_descr, R.drawable.squat));
        exercises.add(new Exercise(R.string.twists, R.string.twists_descr, R.drawable.twists));
        exercises.add( new Exercise(R.string.jumping, R.string.jumping_descr, R.drawable.jumping));
        exercises.add(new Exercise(R.string.boat, R.string.boat_descr, R.drawable.boat));
        exercises.add(new Exercise(R.string.twisting, R.string.twisting_descr, R.drawable.twisting));


    }
}