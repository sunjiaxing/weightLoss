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
        String sql = "select * from " + SportRecord.TABLE_NAME + " where " + SportRecord.KEY_COLUMN_USER_ID + " = ?";
        Cursor cursor = helper.getReadableDatabase().rawQuery(sql, new String[]{String.valueOf(userId)});
        if (cursor != null && cursor.getCount() > 0) {
            list = new ArrayList<>();
            SportRecord record = null;
            while (cursor.moveToNext()) {
                record = new SportRecord();
                record.setStartTime(cursor.getLong(cursor.getColumnIndex(SportRecord.KEY_COLUMN_START_TIME)));
                record.setEndTime(cursor.getLong(cursor.getColumnIndex(SportRecord.KEY_COLUMN_END_TIME)));
                // TODO 赋值 待完善

                list.add(record);
            }
        }
        return list;
    }

    @Override
    public SportRecord getRecord(int userId, long currentDay) {

        return null;
    }
}
