package com.weightloss.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by admin on 2015/11/2.
 */
public abstract class BaseActivity extends Activity {

    private Toast mToast;

    /**
     * 执行任务失败 调用的方法
     *
     * @param action  任务类型
     * @param message 失败提示
     */
    public abstract void onTaskFail(int action, String message);

    /**
     * 执行任务成功 调用的方法
     *
     * @param action 任务类型
     * @param data   成功之后的数据
     */
    public abstract void onTaskSuccess(int action, Object data);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * toast提示
     * @param message
     */
    public void showToast(String message) {
        if (mToast != null) {
            mToast.setText(message);
        } else {
            mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("==============","ondestory " + this);
    }
}
