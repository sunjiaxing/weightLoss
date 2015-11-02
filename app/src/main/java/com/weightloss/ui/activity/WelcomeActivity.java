package com.weightloss.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.TextView;


import com.weightloss.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * 欢迎页面Activity
 */
@EActivity(R.layout.layout_welcome)
public class WelcomeActivity extends BaseActivity {
    @ViewById(R.id.tv_init)
    TextView tvInit;
    private Handler handler;

    @AfterViews
    void init() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                        handler.removeMessages(0);
                        handler.removeMessages(1);
                        handler.removeMessages(2);
                        handler.removeMessages(3);
                        handler.removeMessages(4);
                        startActivity(new Intent(WelcomeActivity.this,MainActivity_.class));
                        finish();
                        break;
                    case 1:
                        tvInit.setText("加载中。");
                        handler.sendEmptyMessageDelayed(2, 300);
                        break;
                    case 2:
                        tvInit.setText("加载中。。");
                        handler.sendEmptyMessageDelayed(3, 300);
                        break;
                    case 3:
                        tvInit.setText("加载中。。。");
                        handler.sendEmptyMessageDelayed(4, 300);
                        break;
                    case 4:
                        tvInit.setText("加载中");
                        handler.sendEmptyMessageDelayed(1, 300);
                        break;
                }
            }
        };
        handler.sendEmptyMessageDelayed(1, 50);
        handler.sendEmptyMessageDelayed(0, 5000);
    }


    @Override
    public void onTaskFail(int action, String message) {

    }

    @Override
    public void onTaskSuccess(int action, Object data) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true ;
        }
        return super.onKeyDown(keyCode, event);
    }
}
