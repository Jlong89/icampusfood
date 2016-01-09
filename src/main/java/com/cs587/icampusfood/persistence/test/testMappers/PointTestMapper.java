package com.cs587.icampusfood.persistence.test.testMappers;

import com.cs587.icampusfood.persistence.test.domainTest.PointRes;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by longpengjiao on 9/15/15.
 */
public interface PointTestMapper {

    /**
     * @return all the points
     */
    @Select("SELECT \"name\", \"location\"  FROM \"point\"")
    public List<PointRes> getAllPoints();
}
