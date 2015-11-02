package com.weightloss.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.weightloss.dao.IUserDao;
import com.weightloss.dao.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/11/2.
 */
public class UserDaoImpl extends BaseDao implements IUserDao {

    public UserDaoImpl(Context context) {
        super(context);
    }

    @Override
    public void updateUser(User user) {
        ContentValues values = new ContentValues();
        values.put(User.KEY_COLUMN_USER_NAME,user.getUserName());
        values.put(User.KEY_COLUMN_USER_HEIGHT,user.getHeight());
        values.put(User.KEY_COLUMN_USER_WEIGHT,user.getWeight());
        values.put(User.KEY_COLUMN_USER_SEX,user.getSex());
        values.put(User.KEY_COLUMN_FAT_RATE,user.getFatRate());

        helper.getWritableDatabase().insert(User.TABLE_NAME,null,values);
    }

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public User getUserByName(String userName) {
        return null;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = null;
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from " + User.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null && cursor.getCount() > 0) {
            userList = new ArrayList<>();
            User user = null;
            while(cursor.moveToNext()){
                user = new User();
                user.setUserId(cursor.getInt(cursor.getColumnIndex(User.KEY_COLUMN_USER_ID)));
                user.setUserName(cursor.getString(cursor.getColumnIndex(User.KEY_COLUMN_USER_NAME)));
                user.setSex(cursor.getInt(cursor.getColumnIndex(User.KEY_COLUMN_USER_SEX)));
                user.setHeight(cursor.getFloat(cursor.getColumnIndex(User.KEY_COLUMN_USER_HEIGHT)));
                user.setWeight(cursor.getFloat(cursor.getColumnIndex(User.KEY_COLUMN_USER_WEIGHT)));
                user.setFatRate(cursor.getFloat(cursor.getColumnIndex(User.KEY_COLUMN_FAT_RATE)));
                userList.add(user);
            }
        }
        return userList;
    }
}
