package com.weightloss.dao.impl;

import android.content.Context;

import com.weightloss.dao.DBHelper;

/**
 * Created by admin on 2015/11/2.
 */
public class BaseDao {
    private Context mContext;
    protected final DBHelper helper;

    public BaseDao(Context context) {
        this.mContext = context;
        helper = DBHelper.getInstance(context);
    }
}
