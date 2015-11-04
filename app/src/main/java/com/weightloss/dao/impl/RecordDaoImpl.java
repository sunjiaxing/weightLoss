package com.weightloss.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.weightloss.dao.IRecordDao;
import com.weightloss.dao.entity.SportRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/11/3.
 */
public class RecordDaoImpl extends BaseDao implements IRecordDao {

    public RecordDaoImpl(Context context) {
        super(context);
    }

    @Override
    public void insertRecord(SportRecord record) {
        ContentValues values = new ContentValues();
        values.put(SportRecord.KEY_COLUMN_USER_ID, record.getUserId());
        values.put(SportRecord.KEY_COLUMN_START_TIME, record.getStartTime());
        values.put(SportRecord.KEY_COLUMN_END_TIME, record.getEndTime());
        values.put(SportRecord.KEY_COLUMN_DISTANCE, record.getDistance());
        values.put(SportRecord.KEY_COLUMN_CALORY, record.getCalory());
        values.put(SportRecord.KEY_COLUMN_USER_WEIGHT, record.getWeight());
        values.put(SportRecord.KEY_COLUMN_FAT_RATE, record.getFatRate());
        values.put(SportRecord.KEY_COLUMN_DAY, record.getCurrentDay());

        helper.getWritableDatabase().insert(SportRecord.TABLE_NAME, null, values);
    }

    @Override
    public SportRecord getRecordByUserId(int userId) {

        return null;
    }

    @Override
    public List<SportRecord> getRecordListByUserId(int userId) {
        List<SportRecord> list = null;
        try {
            String sql = "select * from " + SportRecord.TABLE_NAME + " where " + SportRecord.KEY_COLUMN_USER_ID + " = ?";
            cursor = helper.getReadableDatabase().rawQuery(sql, new String[]{String.valueOf(userId)});
            if (cursor != null && cursor.getCount() > 0) {
                list = new ArrayList<>();
                SportRecord record = null;
                while (cursor.moveToNext()) {
                    record = new SportRecord();
                    record.setStartTime(cursor.getLong(cursor.getColumnIndex(SportRecord.KEY_COLUMN_START_TIME)));
                    record.setEndTime(cursor.getLong(cursor.getColumnIndex(SportRecord.KEY_COLUMN_END_TIME)));
                    record.setDistance(cursor.getFloat(cursor.getColumnIndex(SportRecord.KEY_COLUMN_DISTANCE)));
                    record.setCalory(cursor.getInt(cursor.getColumnIndex(SportRecord.KEY_COLUMN_CALORY)));
                    record.setCurrentDay(cursor.getLong(cursor.getColumnIndex(SportRecord.KEY_COLUMN_DAY)));
                    record.setWeight(cursor.getFloat(cursor.getColumnIndex(SportRecord.KEY_COLUMN_USER_WEIGHT)));
                    record.setFatRate(cursor.getFloat(cursor.getColumnIndex(SportRecord.KEY_COLUMN_FAT_RATE)));
                    list.add(record);
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            releaseCursor();
        }
        return list;
    }

    @Override
    public SportRecord getRecord(int userId, long currentDay) {

        return null;
    }

    @Override
    public List<SportRecord> getRecordList(int userId, long currentDay) {
        String sql = "select * from " + SportRecord.TABLE_NAME + " where "
                + SportRecord.KEY_COLUMN_USER_ID + " = ? and "
                + SportRecord.KEY_COLUMN_DAY + " = ?";
        List<SportRecord> list = null;
        try {
            cursor = helper.getReadableDatabase().rawQuery(sql, new String[]{String.valueOf(userId), String.valueOf(currentDay)});
            if (cursor != null && cursor.getCount() > 0) {
                list = new ArrayList<>();
                SportRecord record = null;
                while (cursor.moveToNext()) {
                    record = new SportRecord();
                    record.setStartTime(cursor.getLong(cursor.getColumnIndex(SportRecord.KEY_COLUMN_START_TIME)));
                    record.setEndTime(cursor.getLong(cursor.getColumnIndex(SportRecord.KEY_COLUMN_END_TIME)));
                    record.setDistance(cursor.getFloat(cursor.getColumnIndex(SportRecord.KEY_COLUMN_DISTANCE)));
                    record.setCalory(cursor.getInt(cursor.getColumnIndex(SportRecord.KEY_COLUMN_CALORY)));
                    record.setCurrentDay(cursor.getLong(cursor.getColumnIndex(SportRecord.KEY_COLUMN_DAY)));
                    record.setWeight(cursor.getFloat(cursor.getColumnIndex(SportRecord.KEY_COLUMN_USER_WEIGHT)));
                    record.setFatRate(cursor.getFloat(cursor.getColumnIndex(SportRecord.KEY_COLUMN_FAT_RATE)));
                    list.add(record);
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            releaseCursor();
        }
        return list;
    }

    @Override
    public List<Long> getSportDay(int userId) {
        String sql = "select " + SportRecord.KEY_COLUMN_DAY + " from " + SportRecord.TABLE_NAME
                + " where " + SportRecord.KEY_COLUMN_USER_ID + " = ? group by " + SportRecord.KEY_COLUMN_DAY;
        List<Long> list = null;
        try {
            cursor = helper.getReadableDatabase().rawQuery(sql, new String[]{String.valueOf(userId)});
            if (cursor != null && cursor.getCount() > 0) {
                list = new ArrayList<>();
                while (cursor.moveToNext()) {
                    list.add(cursor.getLong(cursor.getColumnIndex(SportRecord.KEY_COLUMN_DAY)));
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            releaseCursor();
        }
        return list;
    }
}
