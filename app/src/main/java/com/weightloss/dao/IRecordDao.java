package com.weightloss.dao;

import com.weightloss.dao.entity.SportRecord;

import java.util.List;

/**
 * Created by admin on 2015/11/2.
 */
public interface IRecordDao {
    /**
     * 插入记录
     *
     * @param record
     */
    void insertRecord(SportRecord record);

    /**
     * 通过用户id获取记录
     *
     * @param userId
     * @return
     */
    SportRecord getRecordByUserId(int userId);

    /**
     * 通过userId获取记录列表
     *
     * @param userId
     * @return
     */
    List<SportRecord> getRecordListByUserId(int userId);

    SportRecord getRecord(int userId, long currentDay);

    /**
     * 获取某一天详细记录
     *
     * @param userId
     * @param currentDay
     * @return
     */
    List<SportRecord> getRecordList(int userId, long currentDay);

    /**
     * 获取运动天 记录列表
     *
     * @param userId
     * @return
     */
    List<Long> getSportDay(int userId);


}
