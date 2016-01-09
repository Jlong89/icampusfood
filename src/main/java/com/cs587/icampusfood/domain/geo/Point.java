package com.cs587.icampusfood.domain.geo;

/**
 * Created by longpengjiao on 9/16/15.
 */
public class Point {
    private double xcoord;
    private double ycoord;

    public void setXcoord(double xcoord){
        this.xcoord= xcoord;
    }

    public void setYcoord(double ycoord){
        this.ycoord= ycoord;
    }

    public double getXcoord(){
        return xcoord;
    }

    public double getYcoord(){
        return ycoord;
    }
}
