package com.cs587.icampusfood.dataAccess;

import com.cs587.icampusfood.domain.business.CrowdData;

import java.util.List;

/**
 * Created by Joey on 11/24/15.
 */
public interface DataServiceInterface {

    List<CrowdData> getWeeklyCrowdData(int locationId);
}
