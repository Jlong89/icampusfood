/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.dataAccess;

import com.cs587.icampusfood.dataObjects.PostDo;
import com.cs587.icampusfood.persistence.businessMappers.PostMapper;
import com.cs587.icampusfood.persistence.dataObjects.PostDBDO;
import com.cs587.icampusfood.util.DateTimeUtil;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joey
 */
@Service("postService")
public class PostServiceImpl implements PostServiceInterface{
    private PostMapper postMapper;
    @Autowired
    public void setUserMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }
    
    @Override
    public List<PostDo> getPosts(int locationId){
        List<PostDBDO> dbLists = postMapper.getPosts(locationId);
        List<PostDo> ret = new ArrayList<>(dbLists.size());
        for(PostDBDO dbdo : dbLists){
            PostDo x = new PostDo(dbdo);
            ret.add(x);
        }
        return ret;
    }
    
    @Override
    public int insertPost(PostDo postDo){
        PostDBDO dbdo = new PostDBDO();
        dbdo.setPostId(postDo.getPostId());
        dbdo.setLocationId(postDo.getLocationId());
        dbdo.setFoodRating(postDo.getFoodRating());
        dbdo.setServiceRating(postDo.getServiceRating());
        dbdo.setCrowdedness(postDo.getCrowdedness());
        Calendar calendar = Calendar.getInstance();
        calendar.set(DateTimeUtil.getYearFromDateString(postDo.getPostDate()),//year
                DateTimeUtil.getMonthFromDateString(postDo.getPostDate()),//month
                DateTimeUtil.getDayFromDateString(postDo.getPostDate()),//day
                DateTimeUtil.getHourFromTimeString(postDo.getPostTime()),//hour
                DateTimeUtil.getMinFromTimeString(postDo.getPostTime()));//min
        dbdo.setPostTime(new Timestamp(calendar.getTimeInMillis()));
        return postMapper.insertPost(dbdo);
    }
}
