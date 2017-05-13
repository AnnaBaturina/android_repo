package android_2.lesson01.app01.lib;

import android_2.lesson01.app01.R;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class DBEmpl extends DBSQLite {


    private static final String SQL_WHERE_BY_ID = BaseColumns._ID + "=?";

    public static final String DB_NAME = "DBEmpl.db";

    public static final int DB_VERSION = 2;


    public DBEmpl(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        DBSQLite.execSQL(db, TableNotes.SQL_CREATE);


        fillTNote(db);

    }


    public void fillTNote(SQLiteDatabase db) {

        String[] deps = getContext().getResources().getStringArray(
                R.array.note_items);

        ContentValues values = new ContentValues(deps.length);

        for (int i = 0; i < deps.length; i++) {

            String[] dep = deps[i].split("-");

            values.put(TableNotes.C_TIME, dep[0]);
            values.put(TableNotes.C_TITLE, dep[1]);
            values.put(TableNotes.C_NOTE, dep[2]);

            db.insert(TableNotes.T_NAME, null, values);

        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		/* Drop tables */
        DBSQLite.dropTable(db, TableNotes.T_NAME);
		
		/* Invoke onCreate method */
        this.onCreate(db);

    }


    public long addNote(String time, String title, String note) {

        ContentValues v = new ContentValues();

        v.put(TableNotes.C_TIME, time);
        v.put(TableNotes.C_TITLE, title);
        v.put(TableNotes.C_NOTE, note);

        return this.getWritableDatabase().insert(TableNotes.T_NAME, null, v);

    }


    public boolean updateDep(String name, String location, long id) {
		
		/* Create a new map of values, where column names are the keys */
        ContentValues v = new ContentValues();
		
		/* Fill values */
        v.put(TableNotes.C_TIME, name);
        v.put(TableNotes.C_TITLE, location);
        v.put(TableNotes.C_NOTE, location);

		/* Update information */
        return 1 == this.getWritableDatabase().update(TableNotes.T_NAME, v,
                SQL_WHERE_BY_ID, new String[]{String.valueOf(id)});
    }


    /**
     * Delete department from a data base.
     *
     * @param id of element that will be deleted
     * @return True, if was been deleted only one element
     */
    public boolean deleteDep(long id) {
        return 1 == this.getWritableDatabase().delete(
                TableNotes.T_NAME, SQL_WHERE_BY_ID,
                new String[]{String.valueOf(id)});
    }


    public static class TableNotes implements BaseColumns {

        /**
         * Name of this table.
         */
        public static final String T_NAME = "tDep";

        public static final String C_TIME = "TIME";

        public static final String C_TITLE = "TITLE";

        public static final String C_NOTE= "NOTE";

        /**
         * SQL query for a create this table.
         */
        public static final String SQL_CREATE = "CREATE TABLE " + T_NAME +
                " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                C_TIME + " TEXT," +
                C_TITLE + " TEXT," +
                C_NOTE + " TEXT)";
    }

}
