package org.talcrafts.digigyan.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.talcrafts.digigyan.DGEnvironment;
import org.talcrafts.digigyan.model.User;

/**
 * Created by ashwaghm on 19-Jan-17.
 */

public class DGDBHelper extends SQLiteOpenHelper {

    public static final String CREATE_USER ="CREATE TABLE "+User.TABLE_NAME+"("
    +User.COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT";

    public static final String CREATE_ENDPOINT="";
    public DGDBHelper(Context context) {
        super(context, DGEnvironment.DB_NAME, null, DGEnvironment.dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
