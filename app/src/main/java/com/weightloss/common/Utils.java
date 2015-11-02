package com.weightloss.common;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import java.util.List;

/**
 * Created by admin on 2015/11/2.
 */
public class Utils {
    /**
     * 非空判断
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    /**
     * 非空判断
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> boolean isEmpty(List<T> t) {
        if (t != null && t.size() > 0) {
            return false;
        }
        return true;
    }

    /**
     * 判断服务是否正在运行
     * @param serviceClassName
     * @param context
     * @return
     */
    public static boolean isServiceRunning(String serviceClassName, Context context) {
        final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE);

        for (ActivityManager.RunningServiceInfo runningServiceInfo : services) {
            if (runningServiceInfo.service.getClassName().equals(serviceClassName)) {
                return true;
            }
        }
        return false;
    }

}
