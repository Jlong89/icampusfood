package com.cs587.icampusfood.persistence.businessMappers;

import com.cs587.icampusfood.persistence.dataObjects.FoodLocationDBDO;
import com.cs587.icampusfood.persistence.dataObjects.TokenDBDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by longpengjiao on 9/28/15.
 */
public interface FoodLocationMapper {

    /**
     *
     * @param k
     * @param longitude
     * @param latitude
     * @param radius
     * @param time
     * @return location within radius that are currently open at time of query, ordered by distance
     */
    List<FoodLocationDBDO> getLocsWithinRangeTime(@Param("k") int k, @Param("longitude") double longitude, @Param("latitude") double latitude,
                                                  @Param("radius") double radius, @Param("time") String time);

    /**
     * @param userName
     * @param locationId
     * @return true if locationId belongs to the favorites of one of userName's friends
     */
    boolean isFriendFavorite(@Param("userName") String userName, @Param("locationId") int locationId);

    /**
     * @param point
     * @param radius
     * @return list of foodlocations that are within the specified radius to the query point
     */
    List<FoodLocationDBDO> getLocsWithinRange(@Param("point") String point, @Param("radius") double radius);

    /**
     * @param longitude
     * @param latitude
     * @param radius
     * @param category
     * @return best restaurant within range of foodType and based on category: avgFoodRating, avgServiceRating, avgCrowdedness
     */
    List<FoodLocationDBDO> getKBestWithinRange(@Param("k") int k, @Param("longitude") double longitude, @Param("latitude") double latitude,
                                        @Param("radius") double radius, @Param("foodType") int foodType, @Param("category") String category);
    /**
     *
     * @param k
     * @param longitude
     * @param latitude
     * @return k nearest neighbors ordered by distance from query point
     */

    List<FoodLocationDBDO> getKnn(@Param("k") int k, @Param("longitude") double longitude, @Param("latitude") double latitude,
                                    @Param("radius") double radius);



    /**
     * @param foodLocationDBDO new location to be inserted
     * @return number of rows affected by insert
     */
    @Insert("INSERT INTO \"FoodLocation\" (\"locationId\",\"name\",\"foodType\",\"avgFoodRating\",\"avgServiceRating\"," +
            "\"openTime\",\"closeTime\",\"startDate\",\"endDate\",\"avgCrowdedness\",\"location\")" +
            " values(#{locationId}, "
            +"#{name},"
            +"#{foodType},"
            +"#{avgFoodRating},"
            +"#{avgServiceRating},"
            +"#{openTime},"
            +"#{closeTime},"
            +"#{startDate},"
            +"#{endDate},"
            +"#{avgCrowdedness},"
            +"#{location})"
            )
    @SelectKey(statement="SELECT nextVal('locationid_seq')", keyProperty="locationId", before=true, resultType=int.class)
    int insertNewFoodLocation(FoodLocationDBDO foodLocationDBDO);

    /**
     * @param name
     * @return foodlocation that matches the name
     */
    @Select("SELECT * from \"FoodLocation\" where \"name\"=#{name}")
    List<FoodLocationDBDO> getFoodLocation(String name);

}
