package com.weightloss.dao.impl;

import android.content.Context;
import android.database.Cursor;

import com.weightloss.dao.DBHelper;

/**
 * Created by admin on 2015/11/2.
 */
public class BaseDao {
    private Context mContext;
    protected Cursor cursor = null;
    protected final DBHelper helper;

    public BaseDao(Context context) {
        this.mContext = context;
        helper = DBHelper.getInstance(context);
    }

    /**
     * 释放 cursor
     * 2015年11月4日16:47:09
     */
    protected void releaseCursor(){
        if (cursor != null) {
            cursor.close();
            cursor = null;
        }
    }
}
