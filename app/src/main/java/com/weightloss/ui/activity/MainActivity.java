package com.weightloss.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.weightloss.R;
import com.weightloss.service.impl.UserServiceImpl;
import com.weightloss.task.Task;
import com.weightloss.task.TaskAction;
import com.weightloss.task.TaskManager;
import com.weightloss.service.IUserService;
import com.weightloss.ui.vo.UserVO;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * 主页面
 */
@EActivity(R.layout.layout_main)
public class MainActivity extends BaseActivity {
    @ViewById(R.id.iv_back)
    ImageView ivBack;
    @ViewById(R.id.tv_title)
    TextView tvTitle;
    @ViewById(R.id.btn_right)
    Button btnRight;
    @ViewById(R.id.btn_init_user)
    Button btnInitUser;

    private IUserService userService = null;

    @AfterViews
    void initData() {
        ivBack.setVisibility(ImageView.VISIBLE);
        tvTitle.setText("天天运动，天天好心情");
        btnRight.setVisibility(View.VISIBLE);
        btnRight.setText("添加记录");
        btnRight.setBackgroundColor(Color.TRANSPARENT);
        userService = new UserServiceImpl(this);
        TaskManager.pushTask(new Task(TaskAction.ACTION_GET_USER_LIST) {
            @Override
            public void run() {
                setReturnData(userService.getUserList());
            }
        }, this);
    }

    /**
     * 返回事件 2015年11月2日17:37:12
     */
    @Click(R.id.iv_back)
    void onBackClick() {

    }

    /**
     * 添加运动记录 2015年11月2日17:37:35
     */
    @Click(R.id.btn_right)
    void addSportRecord() {

    }

    /**
     * 添加用户记录 2015年11月2日17:40:38
     */
    @Click(R.id.btn_init_user)
    void addUserInfo() {
        startActivityForResult(new Intent(this, AddUserInfoActivity_.class), 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK) {

        }
    }

    @Override
    public void onTaskFail(int action, String message) {
        Log.e("============", message);
    }

    @Override
    public void onTaskSuccess(int action, Object data) {
        Log.i("============", "onTaskSuccess data:" + data);
        switch (action) {
            case TaskAction.ACTION_GET_USER_LIST:
                if (data == null) {
                    btnInitUser.setVisibility(View.VISIBLE);
                } else {
                    btnInitUser.setVisibility(View.GONE);
                }
                break;
        }
    }
}
