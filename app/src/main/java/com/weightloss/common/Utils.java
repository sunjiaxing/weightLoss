package com.weightloss.common;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
     *
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

    /**
     * 获取当前时间（年月日）毫秒值
     * 2015年11月4日14:07:29
     * @return
     */
    public static long getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.clear();
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 解析时间
     * 2015年11月4日16:57:22
     * @param time
     * @param pattern
     * @return
     */
    public static String formateTime(long time,String pattern){
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

}
