package com.cs587.icampusfood.persistence.businessMappers;

import com.cs587.icampusfood.persistence.dataObjects.ProfileDBDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by longpengjiao on 11/17/15.
 */
public interface ProfileMapper {
    /**
     *
     * @param longitude
     * @param latitude
     * @param radius
     * @return profile object describing the best foodType within range specified based on foodRating
     */
    ProfileDBDO getProfile(@Param("longitude") double longitude, @Param("latitude")double latitude, @Param("radius") double radius);
}
