package com.weightloss.dao.entity;

/**
 * 锻炼记录（每天有多条）
 * Created by admin on 2015/11/2.
 */
public class SportRecord {
    public static final String TABLE_NAME = "sport_record";

    public static final String KEY_COLUMN_USER_ID = "user_id";
    public static final String KEY_COLUMN_START_TIME = "start_time";
    public static final String KEY_COLUMN_END_TIME = "end_time";
    public static final String KEY_COLUMN_DISTANCE = "distance";
    public static final String KEY_COLUMN_CALORY = "calory";
    public static final String KEY_COLUMN_USER_WEIGHT = "user_weight";
    public static final String KEY_COLUMN_FAT_RATE = "fat_rate";
    public static final String KEY_COLUMN_DAY = "day";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( _id INTEGER PRIMARY KEY , "
            + KEY_COLUMN_USER_ID + " INTEGER , "
            + KEY_COLUMN_START_TIME + " LONG , "
            + KEY_COLUMN_END_TIME + " LONG , "
            + KEY_COLUMN_DISTANCE + " FLOAT , "
            + KEY_COLUMN_CALORY + " INTEGER , "
            + KEY_COLUMN_DAY + " LONG , "
            + KEY_COLUMN_USER_WEIGHT + " FLOAT , "
            + KEY_COLUMN_FAT_RATE + " FLOAT );";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static final String DELETE_TABLE_DATA = "DELETE FROM " + TABLE_NAME;

    private int userId;
    private long startTime;
    private long endTime;
    private float distance;
    private int calory;
    private float weight;
    private float fatRate;
    private long currentDay;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getCalory() {
        return calory;
    }

    public void setCalory(int calory) {
        this.calory = calory;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getFatRate() {
        return fatRate;
    }

    public void setFatRate(float fatRate) {
        this.fatRate = fatRate;
    }

    public long getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(long currentDay) {
        this.currentDay = currentDay;
    }
}
