package com.weightloss.dao;

import com.weightloss.dao.entity.SportRecord;

/**
 * Created by admin on 2015/11/2.
 */
public interface ISportRecord {
    /**
     * 插入记录
     * @param record
     */
    void insertRecord(SportRecord record);

    /**
     * 通过用户id获取记录
     * @param userId
     * @return
     */
    SportRecord getRecordByUserId(int userId);

    SportRecord getRecord(int userId,long currentDay);


}
