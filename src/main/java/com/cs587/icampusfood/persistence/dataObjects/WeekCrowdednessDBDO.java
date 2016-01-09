package com.cs587.icampusfood.persistence.dataObjects;

/**
 * Created by longpengjiao on 11/24/15.
 */
public class WeekCrowdednessDBDO {
    private int rowNo;
    private double crowdedness;
    private int dow;
    private int hour;

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
