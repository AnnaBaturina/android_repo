package android_2.lesson01.app01;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import android_2.lesson01.app01.R;
import android_2.lesson01.app01.lib.DBEmpl;

public class ActMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
				
		/* Invoke a parent method */
		super.onCreate(savedInstanceState);
		Log.d("ActMain", "onCreate");
		/* Load user interface */
		setContentView(R.layout.act_main);
		
		/* Initialize UI components */
		TextView tvDept = (TextView) findViewById(R.id.tvDept);
		TextView tvEmpl = (TextView) findViewById(R.id.tvEmpl);
		ListView lvList = (ListView) findViewById(R.id.lvList);

		/**
		 * Example 1
		 * */

		/* Create Cursor for read a data from data base */
		Cursor cr = MyApp.getDB().getReadableCursor(DBEmpl.TableDep.T_NAME);


//		Cursor cr3 = MyApp.getDB().getReadableCursorWithSelectedData(DBEmpl.TableDep.T_NAME, new String[]{"NAME", "LOCATION"});

		/* Create a StringBuilder object */
		StringBuilder sBuilder = new StringBuilder();

		/* Read a data from tDept*/

		if (cr.moveToFirst()) {

			/* Calculate indexes of columns */
			int col_id = cr.getColumnIndex(DBEmpl.TableDep._ID);
			int col_name = cr.getColumnIndex(DBEmpl.TableDep.C_NAME);
			int col_info = cr.getColumnIndex(DBEmpl.TableDep.C_LOCA);
			int col_dep = cr.getColumnIndex(DBEmpl.TableDep.C_DEPT);


			/* Read data */
			do {

				sBuilder.append(cr.getString(col_id) + " " +
						cr.getString(col_name) +  " - " + cr.getString(col_info) +"\n");

			} while (cr.moveToNext());



			/* Show data */
			tvDept.setText(sBuilder.toString());

		}

		cr.close();


		/* Read a data from tEmpl*/

		Cursor cr2 = MyApp.getDB().getReadableCursor(DBEmpl.TableEmpl.T_NAME);
		StringBuilder sBuilder2 = new StringBuilder();
		if (cr2.moveToFirst()) {

			/* Calculate indexes of columns */
			int col_id = cr2.getColumnIndex(DBEmpl.TableEmpl._ID);
			int col_name = cr2.getColumnIndex(DBEmpl.TableEmpl.C_NAME);
			int col_info = cr2.getColumnIndex(DBEmpl.TableEmpl.C_INFO);
			int col_dept = cr2.getColumnIndex(DBEmpl.TableEmpl.C_DEP_ID);

			do {
				sBuilder2.append(cr2.getString(col_id) + " - " +cr2.getString(col_name) + " - " +
						cr2.getString(col_info) +  " - " + cr2.getString(col_dept) + "\n");

			} while (cr2.moveToNext());



			/* Show data */
			tvEmpl.setText(sBuilder2.toString());

		}


		cr2.close();



		/* Add new department *//*
		MyApp.getDB().addDep("Department 1", "Location 1");*/

		/* Delete department */
		//MyApp.getDB().deleteDep(5);
		/*
		*//**
		 * Example 2
		 * *//*

		*//* Get a Cursor *//*
		Cursor c = MyApp.getDB().getReadableCursor(DBEmpl.TableDep.T_NAME);
		
		*//* Create arrays of columns and UI elements *//*
		String[] from = {DBEmpl.TableDep.C_NAME, DBEmpl.TableDep.C_LOCA};
		int[] to = {R.id.tvName, R.id.tvLocation};

		*//* Create simple Cursor adapter *//*
		SimpleCursorAdapter lvAdapter = new SimpleCursorAdapter(this, 
				R.layout.list_item, c, from, to, 1);

		*//* setting up adapter to list view  *//*
		lvList.setAdapter(lvAdapter);*/

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_main, menu);
		return true;
	}

}
