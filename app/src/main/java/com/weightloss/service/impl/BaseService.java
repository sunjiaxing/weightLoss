package com.weightloss.service.impl;

import android.content.Context;

/**
 * Created by admin on 2015/11/2.
 */
public abstract class BaseService {
    protected Context mContext;

    BaseService(Context context){
        this.mContext = context;
    }
}
