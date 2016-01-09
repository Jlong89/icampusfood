package com.cs587.icampusfood.persistence.test.domainTest;

import java.io.Serializable;

/**
 * Created by longpengjiao on 9/15/15.
 */
public class PointBean implements Serializable {
    private String name;
    private double x;
    private double y;

    public void setName(String name){this.name=name;}
    public void setX(double x){this.x=x;}
    public void setY(double y){this.y=y;}

    public String getName(){return name;}
    public double getX(){return x;}
    public double getY(){return y;}
}
