package com.weightloss.service.impl;

import android.content.Context;
import com.weightloss.common.Utils;
import com.weightloss.dao.IRecordDao;
import com.weightloss.dao.entity.SportRecord;
import com.weightloss.dao.impl.RecordDaoImpl;
import com.weightloss.exception.AppException;
import com.weightloss.service.IRecordService;
import com.weightloss.ui.vo.SportDateVO;
import com.weightloss.ui.vo.SportRecordVO;

import java.util.ArrayList;
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
        // 数据非空 验证
        if (!Utils.isEmpty(distance)) {
            record.setDistance(Float.parseFloat(distance));
        } else {
            throw new AppException("distance can not be null");
        }
        if (!Utils.isEmpty(calory)) {
            record.setCalory(Integer.parseInt(calory));
        } else {
            throw new AppException("calory can not be null");
        }

        if (!Utils.isEmpty(weight)) {
            record.setWeight(Float.parseFloat(weight));
        }
        if (!Utils.isEmpty(fatRate)) {
            record.setFatRate(Float.parseFloat(fatRate));
        }
        record.setCurrentDay(Utils.getCurrentDay());
        recordDao.insertRecord(record);
    }

    @Override
    public List<SportRecordVO> getRecordList(int userId) {
        List<SportRecord> list = recordDao.getRecordListByUserId(userId);
        List<SportRecordVO> showData = null;
        if (!Utils.isEmpty(list)) {
            showData = new ArrayList<>();
            SportRecordVO vo = null;
            for (SportRecord rec : list) {
                vo = new SportRecordVO();
                vo.setStartTime(rec.getStartTime());
                vo.setEndTime(rec.getEndTime());
                vo.setKilometers(rec.getDistance());
                vo.setCalory(rec.getCalory());
                showData.add(vo);
            }
        }
        return showData;
    }

    @Override
    public List<SportDateVO> getDateList(int userId) {
        List<SportDateVO> showData = null;
        List<Long> list = recordDao.getSportDay(userId);
        if (!Utils.isEmpty(list)) {
            showData = new ArrayList<>();
            SportDateVO vo = null;
            String pattern = "yyyy年MM月dd日";
            for (Long day : list) {
                vo = new SportDateVO();
                vo.setDateTime(day);
                vo.setDate(Utils.formateTime(day, pattern));
                showData.add(vo);
            }
        }
        return showData;
    }
}
