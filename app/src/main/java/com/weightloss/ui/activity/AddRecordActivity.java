package com.weightloss.ui.activity;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weightloss.R;
import com.weightloss.common.Utils;
import com.weightloss.service.IRecordService;
import com.weightloss.service.impl.RecordServiceImpl;
import com.weightloss.task.Task;
import com.weightloss.task.TaskAction;
import com.weightloss.task.TaskManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.layout_add_record)
public class AddRecordActivity extends BaseActivity {

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
    @ViewById(R.id.edit_fat_rate)
    EditText editFatRate;
    @ViewById(R.id.tv_time)
    TextView tvTime;
    @ViewById(R.id.layout_input)
    LinearLayout layoutInput;

    private long startTime = 0;
    private long endTime = 0;
    private int time;
    private boolean isRunning = false;
    private Handler handler;
    private IRecordService recordService;
    @Extra
    int userId;

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
        recordService = new RecordServiceImpl(this);
    }

    @Click(R.id.btn_time)
    void clickTime() {
        if (isRunning) {
            // 结束
            endTime = System.currentTimeMillis();
            handler.removeMessages(1);
            btnTime.setText(getString(R.string.start_run));
            isRunning = false;
            tvTime.setVisibility(View.VISIBLE);
            tvTime.setText("本次用时 " + (endTime - startTime) / 1000 + "秒");
            layoutInput.setVisibility(View.VISIBLE);
        } else {
            // 开始
            isRunning = true;
            startTime = System.currentTimeMillis();
            btnTime.setText("点击结束(" + time + "s)");
            tvTime.setVisibility(View.GONE);
            layoutInput.setVisibility(View.GONE);
            handler.sendEmptyMessageDelayed(1, 1000);
        }
    }

    @Click(R.id.iv_back)
    void onBack() {
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Click(R.id.btn_right)
    void saveRecord() {
        TaskManager.pushTask(new Task(TaskAction.ACTION_SAVE_RECORD) {
            @Override
            public void run() {
                // 数据非空验证
                if (Utils.isEmpty(editDistance.getText().toString())) {
                    showToast("请输入跑步距离");
                    editDistance.requestFocus();
                } else if (Utils.isEmpty(editCalory.getText().toString())) {
                    showToast("请输入消耗的卡路里");
                    editCalory.requestFocus();
                }
                recordService.addRecord(userId, startTime, endTime,
                        editDistance.getText().toString(), editCalory.getText().toString(),
                        editWeight.getText().toString(), editFatRate.getText().toString());
            }
        }, this);
    }

    @Override
    public void onTaskFail(int action, String message) {
        Log.e("===============", "action:" + action + "******* message:" + message);
        showToast(message);
    }

    @Override
    public void onTaskSuccess(int action, Object data) {
        switch (action) {
            case TaskAction.ACTION_SAVE_RECORD:// 添加记录成功
                setResult(RESULT_OK);
                finish();
                break;
        }
    }
}
