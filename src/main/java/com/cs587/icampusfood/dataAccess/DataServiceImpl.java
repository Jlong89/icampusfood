package com.cs587.icampusfood.dataAccess;

import com.cs587.icampusfood.domain.business.CrowdData;
import com.cs587.icampusfood.persistence.businessMappers.FoodLocationMapper;
import com.cs587.icampusfood.persistence.businessMappers.ProfileMapper;
import com.cs587.icampusfood.persistence.businessMappers.WeekCrowdednessMapper;
import com.cs587.icampusfood.persistence.dataObjects.WeekCrowdednessDBDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joey on 11/24/15.
 */
@Service("dataService")
public class DataServiceImpl implements DataServiceInterface{

    private WeekCrowdednessMapper weekCrowdednessMapper;

    @Autowired
    public void setFoodLocationMapper(WeekCrowdednessMapper weekCrowdednessMapper) {
        this.weekCrowdednessMapper = weekCrowdednessMapper;
    }

    @Override
    public List<CrowdData> getWeeklyCrowdData(int locationId){
        List<WeekCrowdednessDBDO> list = weekCrowdednessMapper.getWeekCrowdedness(locationId);
        List<CrowdData> ret = new ArrayList<>(list.size());
        for(WeekCrowdednessDBDO x : list){
            ret.add(new CrowdData(x));
        }

        return ret;
    }
}
