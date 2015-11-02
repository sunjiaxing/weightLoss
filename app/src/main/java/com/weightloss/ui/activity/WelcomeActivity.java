package com.weightloss.ui.activity;

import android.os.Bundle;
import android.widget.TextView;


import com.weightloss.R;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.layout_welcome)
public class WelcomeActivity extends BaseActivity {
    @ViewById(R.id.tv_init)
    TextView tvInit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




    @Override
    void onTaskFail(int action, String message) {

    }

    @Override
    void onTaskSuccess(int action, Object data) {

    }


}
