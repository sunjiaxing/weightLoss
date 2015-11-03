package com.weightloss.service;

import com.weightloss.ui.vo.SportRecordVO;

import java.util.List;

/**
 * Created by admin on 2015/11/3.
 */
public interface IRecordService {
    /**
     * 添加运动记录
     *
     * @param startTime
     * @param endTime
     * @param distance
     * @param calory
     * @param weight
     */
    void addRecord(long startTime, long endTime, float distance, float calory, float weight);

    /**
     * 添加运动记录
     *
     * @param userId
     * @param startTime
     * @param endTime
     * @param distance
     * @param calory
     * @param weight
     * @param fatRate
     */
    void addRecord(int userId, long startTime, long endTime, String distance, String calory, String weight, String fatRate);

    /**
     * 获取记录列表
     *
     * @param userId
     * @return
     */
    List<SportRecordVO> getRecordList(int userId);
}
