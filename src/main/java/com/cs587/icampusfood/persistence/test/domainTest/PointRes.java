package com.cs587.icampusfood.persistence.test.domainTest;

import org.postgis.PGgeometry;
import org.postgis.Point;
import org.postgresql.geometric.PGpoint;

import java.io.Serializable;

/**
 * Created by longpengjiao on 9/15/15.
 */
public class PointRes implements Serializable{
   // private static final long serialVersionUID = 1L;

    private String name;
    private PGgeometry location;


    public void setName(String name){
        this.name=name;
    }

    public void setLocation(Object location){
        this.location = (PGgeometry) location;
    }
    public String getName(){
        return name;
    }

    public PGgeometry getLocation() {
        return location;
    }

}

