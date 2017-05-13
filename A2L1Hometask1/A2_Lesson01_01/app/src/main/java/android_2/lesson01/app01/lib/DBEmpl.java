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

        DBSQLite.execSQL(db, TableEmpl.SQL_CREATE);
        DBSQLite.execSQL(db, TableDep.SQL_CREATE);


        fillTDept(db);
        fillTEmpl(db);

    }


    public void fillTDept(SQLiteDatabase db) {

        String[] deps = getContext().getResources().getStringArray(
                R.array.dep_items);

        ContentValues values = new ContentValues(deps.length);

        for (int i = 0; i < deps.length; i++) {

            String[] dep = deps[i].split("-");

            values.put(TableDep.C_NAME, dep[0]);
            values.put(TableDep.C_LOCA, dep[1]);


            db.insert(TableDep.T_NAME, null, values);

        }
    }


    public void fillTEmpl(SQLiteDatabase db) {

        String[] emps = getContext().getResources().getStringArray(
                R.array.empl_items);

        ContentValues values = new ContentValues(emps.length);

        for (int i = 0; i < emps.length; i++) {

            String[] emp = emps[i].split("-");

            values.put(TableEmpl.C_NAME, emp[0]);
            values.put(TableEmpl.C_INFO, emp[1]);
            values.put(TableEmpl.C_DEP_ID, emp[2]);

            db.insert(TableEmpl.T_NAME, null, values);

        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		/* Drop tables */
        DBSQLite.dropTable(db, TableEmpl.T_NAME);
        DBSQLite.dropTable(db, TableDep.T_NAME);
		
		/* Invoke onCreate method */
        this.onCreate(db);

    }


    public long addDep(String name, String location) {

        ContentValues v = new ContentValues();

        v.put(TableDep.C_NAME, name);
        v.put(TableDep.C_LOCA, location);

        return this.getWritableDatabase().insert(TableDep.T_NAME, null, v);

    }


    public boolean updateDep(String name, String location, long id) {
		
		/* Create a new map of values, where column names are the keys */
        ContentValues v = new ContentValues();
		
		/* Fill values */
        v.put(TableDep.C_NAME, name);
        v.put(TableDep.C_LOCA, location);
		
		/* Update information */
        return 1 == this.getWritableDatabase().update(TableDep.T_NAME, v,
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
                TableDep.T_NAME, SQL_WHERE_BY_ID,
                new String[]{String.valueOf(id)});
    }

    /**
     * Public static class that contains information about table tEmpl
     */
    public static class TableEmpl implements BaseColumns {

        /**
         * Name of this table.
         */
        public static final String T_NAME = "tEmpl";


        public static final String C_NAME = "NAME";


        public static final String C_INFO = "INFO";


        public static final String C_DEP_ID = "DEP_ID";

        /**
         * SQL query for a create this table.
         */
        public static final String SQL_CREATE = "CREATE TABLE " + T_NAME +
                " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                C_NAME + " TEXT," +
                C_INFO + " TEXT," +
                C_DEP_ID + " INTEGER)";
    }

    /**
     * Public static class that contains information about table tDep
     */
    public static class TableDep implements BaseColumns {

        /**
         * Name of this table.
         */
        public static final String T_NAME = "tDep";

        public static final String C_NAME = "NAME";

        public static final String C_LOCA = "LOCATION";

        public static final String C_DEPT = "DEPARTMENT";

        /**
         * SQL query for a create this table.
         */
        public static final String SQL_CREATE = "CREATE TABLE " + T_NAME +
                " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                C_NAME + " TEXT," +
                C_LOCA + " TEXT," +
                C_DEPT + " TEXT)";
    }

}
