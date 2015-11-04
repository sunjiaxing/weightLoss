package com.weightloss.ui.vo;

import java.util.List;

/**
 * Created by admin on 2015/11/3.
 */
public class SportDateVO {
    private String date;
    private long dateTime;
    private List<SportRecordVO> recordList;

    public List<SportRecordVO> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<SportRecordVO> recordList) {
        this.recordList = recordList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }
}
