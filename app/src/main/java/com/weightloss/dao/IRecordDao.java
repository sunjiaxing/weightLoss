package com.weightloss.dao;

import com.weightloss.dao.entity.SportRecord;

import java.util.List;

/**
 * Created by admin on 2015/11/2.
 */
public interface IRecordDao {
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

    /**
     * 通过userId获取记录列表
     * 2015年11月3日18:22:58
     * @param userId
     * @return
     */
    List<SportRecord> getRecordListByUserId(int userId);

    SportRecord getRecord(int userId,long currentDay);


}
