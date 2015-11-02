package com.weightloss.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.weightloss.dao.entity.SportRecord;
import com.weightloss.dao.entity.User;

/**
 * Created by admin on 2015/11/2.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper instance = null;
    private static final String DB_NAME = "weightloss.db";
    private static final int DB_VERSION = 1;

    private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static synchronized DBHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (context) {
                instance = new DBHelper(context, DB_NAME, null, DB_VERSION);
            }
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(User.CREATE_TABLE);
        db.execSQL(SportRecord.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
