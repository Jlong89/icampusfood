package com.cs587.icampusfood.persistence.businessMappers;

import com.cs587.icampusfood.persistence.dataObjects.FavoriteDBDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by longpengjiao on 10/4/15.
 */
public interface FavoriteMapper {

    /**
     * @param userName
     * @return locationIds of the user's favorite locations
     */
    @Select("SELECT \"locationId\" from \"Favorites\" where \"userName\"= #{userName}")
    List<Integer> getFavoriteIds(String userName);

    /**
     * @param favoriteDBDO
     * @return number of inserted rows into Favorites table
     */
    @Insert("INSERT into \"Favorites\" (\"favoriteId\", \"locationId\", \"userName\") values(#{favoriteId}, #{locationId}, #{userName})")
    @SelectKey(statement="SELECT nextVal('favoriteid_seq')", keyProperty="favoriteId", before=true, resultType=int.class)
    int insertNewFavorite(FavoriteDBDO favoriteDBDO);

}
