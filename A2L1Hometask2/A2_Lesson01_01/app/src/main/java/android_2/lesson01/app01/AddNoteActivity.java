package android_2.lesson01.app01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android_2.lesson01.app01.lib.DBEmpl;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android_2.lesson01.app01.R;
import android_2.lesson01.app01.lib.DBSQLite;


public class AddNoteActivity extends Activity implements View.OnClickListener {

    EditText noteTitle;
    EditText noteText;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note_layout);

        noteTitle = (EditText) findViewById(R.id.note_title);
        noteText = (EditText) findViewById(R.id.note_text);
        btnSave = (Button) findViewById(R.id.btn_save);

        btnSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_save) {


            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String time = df.format(calendar.getTime());

            String title = noteTitle.getText().toString();
            String text = noteText.getText().toString();
            MyApp.getDB().addNote(time, title, text);

            if (!title.equals("") || !text.equals("")) {
                Intent intent = new Intent(this, ActMain.class);
                startActivity(intent);
            }
        }
    }

}
