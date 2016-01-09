package com.cs587.icampusfood.persistence.businessMappers;

import com.cs587.icampusfood.persistence.dataObjects.PostDBDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * Created by longpengjiao on 10/25/15.
 */
public interface PostMapper {

    /**
     * @param locationId
     * @return posts for location at specified locationId
     */
    @Select("SELECT * from \"Posts\" where \"locationId\"=#{locationId}")
    List<PostDBDO> getPosts(int locationId);

    /**
     * @param postDBDO
     * @return number of rows inserted into Friends table
     */
    @Insert("INSERT into \"Posts\" (\"postId\", \"locationId\", \"foodRating\", \"serviceRating\", \"crowdedness\", \"postTime\")" +
            " VALUES(#{postId}, #{locationId},#{foodRating}, #{serviceRating}, #{crowdedness}, #{postTime} )")
    @SelectKey(statement="SELECT nextVal('postid_seq')", keyProperty="postId", before=true, resultType=int.class)
    int insertPost(PostDBDO postDBDO);

}
