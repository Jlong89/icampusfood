package com.cs587.icampusfood.persistence.businessMappers;

import com.cs587.icampusfood.persistence.dataObjects.WeekCrowdednessDBDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by longpengjiao on 11/24/15.
 */
public interface WeekCrowdednessMapper {

    /**
     * @param locationId
     * @return a week's crowdedness for location that matches location Id
     */
    public List<WeekCrowdednessDBDO> getWeekCrowdedness(@Param("locationId") int locationId);
}
