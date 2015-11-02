package com.weightloss.dao.entity;

/**
 * 用户数据库实体
 * Created by admin on 2015/11/2.
 */
public class User {
    public static final String TABLE_NAME = "users";

    public static final String KEY_COLUMN_USER_ID = "user_id";
    public static final String KEY_COLUMN_USER_NAME = "user_name";
    public static final String KEY_COLUMN_USER_SEX = "user_sex";
    public static final String KEY_COLUMN_USER_HEIGHT = "user_height";
    public static final String KEY_COLUMN_USER_WEIGHT = "user_weight";
    public static final String KEY_COLUMN_FAT_RATE = "fat_rate";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( _id INTEGER PRIMARY KEY , "
            + KEY_COLUMN_USER_ID + " INTEGER , "
            + KEY_COLUMN_USER_NAME + " TEXT , "
            + KEY_COLUMN_USER_SEX + " INTEGER , "
            + KEY_COLUMN_USER_HEIGHT + " FLOAT , "
            + KEY_COLUMN_USER_WEIGHT + " FLOAT , "
            + KEY_COLUMN_FAT_RATE + " FLOAT );";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static final String DELETE_TABLE_DATA = "DELETE FROM " + TABLE_NAME;

    private int userId;
    private String userName;
    private int sex;
    private float height;
    private float weight;
    private float fatRate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
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
}
