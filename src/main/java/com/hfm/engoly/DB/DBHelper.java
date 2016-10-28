package com.hfm.engoly.DB;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hosein on 10/27/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="EngolyDB";
    public static final String TABLE_NAME="chats";
    public static final String TABLE_COLUMN_ID="id";
    public static final String TABLE_COLUMN_NAME="name";
    public static final String TABLE_COLUMN_JSON="json";
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
