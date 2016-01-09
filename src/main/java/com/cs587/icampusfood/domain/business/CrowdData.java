package com.cs587.icampusfood.domain.business;

import com.cs587.icampusfood.persistence.dataObjects.WeekCrowdednessDBDO;

/**
 */
public class CrowdData {
    private int rowNo;
    private double crowdedness;
    private int dow;
    private int hour;

    public CrowdData(WeekCrowdednessDBDO dbdo) {
        this.rowNo = dbdo.getRowNo();
        this.crowdedness = dbdo.getCrowdedness();
        this.dow = dbdo.getDow();
        this.hour = dbdo.getHour();
    }

    public CrowdData() {
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public double getCrowdedness() {
        return crowdedness;
    }

    public void setCrowdedness(double crowdedness) {
        this.crowdedness = crowdedness;
    }

    public int getDow() {
        return dow;
    }

    public void setDow(int dow) {
        this.dow = dow;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
