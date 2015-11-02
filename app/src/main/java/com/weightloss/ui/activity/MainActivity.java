package com.weightloss.ui.activity;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.weightloss.R;
import com.weightloss.task.Task;
import com.weightloss.task.TaskAction;
import com.weightloss.task.TaskManager;
import com.weightloss.service.IUserService;
import com.weightloss.ui.vo.UserVO;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
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

    private IUserService userService = null;

    @AfterViews
    void initData() {
        TaskManager.pushTask(new Task(TaskAction.ACTION_GET_USER_LIST) {
            @Override
            public void run() {
               setReturnData(userService.getUserList());
            }
        }, this);
    }

    @Override
    public void onTaskFail(int action, String message) {

    }

    @Override
    public void onTaskSuccess(int action, Object data) {

    }
}
