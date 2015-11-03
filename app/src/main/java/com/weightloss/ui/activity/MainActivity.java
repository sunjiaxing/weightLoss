package com.weightloss.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.weightloss.R;
import com.weightloss.common.Utils;
import com.weightloss.service.IRecordService;
import com.weightloss.service.impl.RecordServiceImpl;
import com.weightloss.service.impl.UserServiceImpl;
import com.weightloss.task.Task;
import com.weightloss.task.TaskAction;
import com.weightloss.task.TaskManager;
import com.weightloss.service.IUserService;
import com.weightloss.ui.vo.UserVO;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

import java.util.List;

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
    @ViewById(R.id.btn_select_user)
    Button btnSelectUser;

    private IUserService userService = null;
    private IRecordService recordService = null;
    private List<UserVO> userList;
    private UserVO selectedUser;

    @AfterViews
    void initData() {
        ivBack.setVisibility(ImageView.VISIBLE);
        tvTitle.setText("天天运动，天天好心情");
        btnRight.setVisibility(View.VISIBLE);
        btnRight.setText("添加记录");
        btnRight.setBackgroundColor(Color.TRANSPARENT);
        userService = new UserServiceImpl(this);
        recordService = new RecordServiceImpl(this);
        getUserList();
    }

    /**
     * 获取用户信息列表
     * 2015年11月3日09:43:10
     */
    void getUserList() {
        TaskManager.pushTask(new Task(TaskAction.ACTION_GET_USER_LIST) {
            @Override
            public void run() {
                setReturnData(userService.getUserList());
            }
        }, this);
    }

    @Click(R.id.btn_select_user)
    void selectUser() {
        // 判断是否存在用户列表
        if (!Utils.isEmpty(userList)) {
            String[] items = new String[userList.size()];
            for (int i = 0; i < userList.size(); i++) {
                items[i] = userList.get(i).getUserName();
            }
            new AlertDialog.Builder(this).setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.i("==============", "which : " + which);
                    selectedUser = userList.get(which);
                    btnSelectUser.setText(selectedUser.getUserName() + "(切换)");
                }
            }).show();
        }
    }

    /**
     * 返回事件 2015年11月2日17:37:12
     */
    @Click(R.id.iv_back)
    void onBackClick() {
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackClick();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 添加运动记录 2015年11月2日17:37:35
     */
    @Click(R.id.btn_right)
    void addSportRecord() {
        if (selectedUser == null) {
            showToast("请先选择用户！");
        } else {
            // 启动Activity
            AddRecordActivity_.intent(this).userId(selectedUser.getUserId()).startForResult(124);
        }
    }

    /**
     * 添加用户记录 2015年11月2日17:40:38
     */
    @Click(R.id.btn_init_user)
    void addUserInfo() {
        startActivityForResult(new Intent(this, AddUserInfoActivity_.class), 123);
    }

    /**
     * 初始化用户结束
     *
     * @param resultCode
     */
    @OnActivityResult(123)
    void afterInitUser(int resultCode) {
        if (resultCode == RESULT_OK) {
            getUserList();
        }
    }

    /**
     * 添加记录返回事件
     * 2015年11月3日18:18:17
     *
     * @param resultCode
     */
    @OnActivityResult(124)
    void afterAddRecord(int resultCode) {
        if (resultCode == RESULT_OK) {
            getSportRecordList();
        }
    }

    /**
     * 获取运动记录列表
     */
    void getSportRecordList() {
        TaskManager.pushTask(new Task(TaskAction.ACTION_GET_RECORD_LIST) {
            @Override
            public void run() {
                setReturnData(recordService.getRecordList(selectedUser.getUserId()));
            }
        }, this);
    }

    @Override
    public void onTaskFail(int action, String message) {
        Log.e("=============", action + "********" + message);
        showToast(message);
    }

    @Override
    public void onTaskSuccess(int action, Object data) {
        Log.i("============", "onTaskSuccess data:" + data);
        switch (action) {
            case TaskAction.ACTION_GET_USER_LIST:
                if (data != null) {
                    userList = (List<UserVO>) data;
                }
                break;
            case TaskAction.ACTION_GET_RECORD_LIST:
                if (data != null) {

                }
                break;
        }
    }
}
