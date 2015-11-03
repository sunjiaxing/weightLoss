package com.weightloss.ui.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.weightloss.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.layout_add_record)
public class AddRecordActivity extends Activity {

    @ViewById(R.id.iv_back)
    ImageView ivBack;
    @ViewById(R.id.tv_title)
    TextView tvTitle;
    @ViewById(R.id.btn_right)
    Button btnRight;
    @ViewById(R.id.btn_time)
    Button btnTime;
    @ViewById(R.id.edit_distance)
    EditText editDistance;
    @ViewById(R.id.edit_calory)
    EditText editCalory;
    @ViewById(R.id.edit_weight)
    EditText editWeight;

    private long startTime = 0;
    private long endTime = 0;
    private int time;
    private boolean isRunning = false;
    private Handler handler;

    @AfterViews
    void init() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("添加运动记录");
        btnRight.setBackgroundColor(Color.TRANSPARENT);
        btnRight.setText("保存");
        btnRight.setVisibility(View.VISIBLE);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    time++;
                    btnTime.setText("点击结束(" + time + "s)");
                    handler.sendEmptyMessageDelayed(1, 1000);
                }
            }
        };
    }

    @Click(R.id.btn_time)
    void clickTime() {
        if (isRunning) {
            // 结束
            endTime = System.currentTimeMillis();
            handler.removeMessages(1);
            btnTime.setText(getString(R.string.start_run));
            isRunning = false;
        } else {
            // 开始
            isRunning = true;
            startTime = System.currentTimeMillis();
            btnTime.setText("点击结束(" + time + "s)");
            handler.sendEmptyMessageDelayed(1, 1000);
        }
    }
}
