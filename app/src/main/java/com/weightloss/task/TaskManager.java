package com.weightloss.task;

import android.content.Intent;

import com.weightloss.common.Utils;
import com.weightloss.ui.MyApplication;
import com.weightloss.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务管理
 * Created by admin on 2015/11/2.
 */
public class TaskManager {
    /**
     * 任务列表
     */
    private static List<Task> taskList = new ArrayList<>();

    /**
     * 获取任务列表
     *
     * @return
     */
    public static List<Task> getTaskList() {
        return taskList;
    }

    /**
     * 添加任务到队列中
     *
     * @param task
     * @param callBack
     */
    public static void pushTask(Task task, BaseActivity callBack) {
        task.setCallBack(callBack);
        taskList.add(task);
        if (!Utils.isServiceRunning(TaskService.class.getName(), callBack)) {
            callBack.startService(new Intent(callBack, TaskService.class));
        }
    }

    /**
     * 获取下一个要执行的任务
     *
     * @return
     */
    public static Task getNext() {
        if (Utils.isEmpty(taskList)) {
            return null;
        }
        return taskList.remove(0);
    }

}
