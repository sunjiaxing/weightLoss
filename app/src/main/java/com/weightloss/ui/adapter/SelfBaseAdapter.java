package com.weightloss.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

/**
 * Created by admin on 2015/11/4.
 */
public abstract class SelfBaseAdapter extends BaseAdapter {
    protected Context mContext;
    protected LayoutInflater inflater;

    public SelfBaseAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(context);
    }
}
