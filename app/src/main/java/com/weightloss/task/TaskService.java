package com.weightloss.task;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

import com.weightloss.exception.AppException;

public class TaskService extends Service {

    public static boolean isRunning = false;
    private Handler handler;
    private static final int TASK_RUN_SUCCESS = 1;
    private static final int TASK_RUN_ERROR = 2;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        isRunning = true;
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case TASK_RUN_SUCCESS:
                        Task task = (Task) msg.obj;
                        task.getCallBack().onTaskSuccess(task.getmAction(),task.getReturnData());
                        break;
                    case TASK_RUN_ERROR:

                        break;
                }
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread() {
            @Override
            public void run() {
                while (isRunning) {
                    Task task = TaskManager.getNext();
                    if (task != null) {
                        Message msg = null;
                        try {
                            task.run();
                            msg = handler.obtainMessage(TASK_RUN_SUCCESS,task);
                        } catch (Exception e) {
                            task.setErrorMessage(e.getMessage());
                            msg = handler.obtainMessage(TASK_RUN_ERROR, task);
                        }
                        handler.sendMessage(msg);
                    } else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }
}
