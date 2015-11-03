package com.weightloss.service.impl;

import android.content.Context;
import android.content.Intent;

import com.weightloss.dao.IRecordDao;
import com.weightloss.dao.entity.SportRecord;
import com.weightloss.dao.impl.RecordDaoImpl;
import com.weightloss.service.IRecordService;
import com.weightloss.ui.vo.SportRecordVO;

import java.util.List;

/**
 * Created by admin on 2015/11/3.
 */
public class RecordServiceImpl extends BaseService implements IRecordService {
    private IRecordDao recordDao = null;
    public RecordServiceImpl(Context context) {
        super(context);
        recordDao = new RecordDaoImpl(context);
    }

    @Override
    @Deprecated
    public void addRecord(long startTime, long endTime, float distance, float calory, float weight) {

    }

    @Override
    public void addRecord(int userId, long startTime, long endTime, String distance, String calory, String weight, String fatRate) {
        SportRecord record = new SportRecord();
        record.setUserId(userId);
        record.setStartTime(startTime);
        record.setEndTime(endTime);
        // TODO 数据非空 待验证
        record.setDistance(Float.parseFloat(distance));
        record.setCalory(Integer.parseInt(calory));

        
        recordDao.insertRecord(record);

    }

    @Override
    public List<SportRecordVO> getRecordList(int userId) {
        recordDao.getRecordListByUserId(userId);
        return null;
    }
}
