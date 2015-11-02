package com.weightloss.task;

import com.weightloss.ui.activity.BaseActivity;


/**
 * Created by admin on 2015/11/2.
 */
public abstract class Task {
    private BaseActivity callBack;
    private int mAction;
    private Object returnData;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getReturnData() {
        return returnData;
    }

    public void setReturnData(Object returnData) {
        this.returnData = returnData;
    }

    public BaseActivity getCallBack() {
        return callBack;
    }

    public void setCallBack(BaseActivity callBack) {
        this.callBack = callBack;
    }

    public int getmAction() {
        return mAction;
    }

    public Task(int action) {
        this.mAction = action;
    }

    public abstract void run();
}
