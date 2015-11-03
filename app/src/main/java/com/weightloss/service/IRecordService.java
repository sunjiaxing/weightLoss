package com.weightloss.service;

/**
 * Created by admin on 2015/11/3.
 */
public interface IRecordService {
    /**
     * 添加运动记录
     * @param startTime
     * @param endTime
     * @param distance
     * @param calory
     * @param weight
     */
    void addRecord(long startTime,long endTime,float distance,float calory,float weight);
}
