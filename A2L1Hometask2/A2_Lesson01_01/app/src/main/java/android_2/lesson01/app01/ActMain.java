package android_2.lesson01.app01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import android_2.lesson01.app01.lib.DBEmpl;

public class ActMain extends Activity implements View.OnClickListener{

    EditText nrToDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("ActMain", "onCreate");
        setContentView(R.layout.act_main);
		

        TextView tvDept = (TextView) findViewById(R.id.tvDept);
      nrToDel = (EditText) findViewById(R.id.nrtodelete);
        Button btnAdd = (Button) findViewById(R.id.addnewnote);
Button btnDelete = (Button) findViewById(R.id.deletenote);

        btnAdd.setOnClickListener(this);
btnDelete.setOnClickListener(this);

        Cursor cr = MyApp.getDB().getReadableCursor(DBEmpl.TableNotes.T_NAME);

        StringBuilder sBuilder = new StringBuilder();

        if (cr.moveToFirst()) {

            int col_id = cr.getColumnIndex(DBEmpl.TableNotes._ID);
            int col_time = cr.getColumnIndex(DBEmpl.TableNotes.C_TIME);
            int col_title = cr.getColumnIndex(DBEmpl.TableNotes.C_TITLE);
            int col_note = cr.getColumnIndex(DBEmpl.TableNotes.C_NOTE);

            do {

                sBuilder.append(cr.getString(col_id) + ". " + cr.getString(col_time) +"\n" + cr.getString(col_title) +"\n"  + cr.getString(col_note) + "\n\n");

            } while (cr.moveToNext());

            tvDept.setText(sBuilder.toString());

        }

        cr.close();

    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addnewnote) {
            Intent intent = new Intent(this, AddNoteActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.deletenote) {
            MyApp.getDB().deleteDep(Long.parseLong(nrToDel.getText().toString()));
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.act_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:

                Intent intent = new Intent(this, AddNoteActivity.class);
                startActivity(intent);
//                MyApp.getDB().addDep("Department 1", "Location 1");

                return true;
            case R.id.action_delete:


                AlertDialog.Builder builder = new AlertDialog.Builder(ActMain.this);
                builder.setTitle("Важное сообщение!")
                        .setMessage("Покормите кота!")
                        .setIcon(R.drawable.ic_action_dontlike)
                        .setCancelable(true)
                        .setNegativeButton("ОК, иду на кухню",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();


//                MyApp.getDB().deleteDep(4);
                return true;
            case R.id.action_settings:
                //
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}