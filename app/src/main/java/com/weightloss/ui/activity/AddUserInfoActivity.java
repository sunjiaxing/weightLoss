package com.weightloss.ui.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.weightloss.R;
import com.weightloss.service.IUserService;
import com.weightloss.service.impl.UserServiceImpl;
import com.weightloss.task.Task;
import com.weightloss.task.TaskAction;
import com.weightloss.task.TaskManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by admin on 2015/11/2.
 */
@EActivity(R.layout.layout_add_user_info)
public class AddUserInfoActivity extends BaseActivity {

    @ViewById(R.id.iv_back)
    ImageView ivBack;
    @ViewById(R.id.tv_title)
    TextView tvTitle;
    @ViewById(R.id.btn_right)
    Button btnRight;
    @ViewById(R.id.edit_user_name)
    EditText editName;
    @ViewById(R.id.edit_height)
    EditText editHeight;
    @ViewById(R.id.edit_weight)
    EditText editWeight;
    @ViewById(R.id.edit_fat)
    EditText editFatRate;


    IUserService userService;

    @AfterViews
    void init() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("添加用户信息");
        btnRight.setVisibility(View.VISIBLE);
        btnRight.setText("保存");
        btnRight.setBackgroundColor(Color.TRANSPARENT);
    }

    @Click(R.id.btn_right)
    void saveUser() {
        userService = new UserServiceImpl(this);
        TaskManager.pushTask(new Task(TaskAction.ACTION_SAVE_USER) {
            @Override
            public void run() {
                userService.initUserInfo(editName.getText().toString(),
                        Float.parseFloat(editHeight.getText().toString()),
                        Float.parseFloat(editWeight.getText().toString()),
                        Float.parseFloat(editFatRate.getText().toString()), 0);
            }
        }, this);
    }

    /**
     * 返回事件 2015年11月2日17:37:12
     */
    @Click(R.id.iv_back)
    void onBackClick() {
        finish();
    }

    @Override
    public void onTaskFail(int action, String message) {
        showToast(message);
    }

    @Override
    public void onTaskSuccess(int action, Object data) {
        switch (action){
            case TaskAction.ACTION_SAVE_USER:
                showToast("添加成功！");
                setResult(RESULT_OK);
                finish();
                break;
        }
    }
}
