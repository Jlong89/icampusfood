/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.dataAccess;

import com.cs587.icampusfood.dataObjects.PostDo;
import java.util.List;


/**
 *
 * @author Joey
 */
public interface PostServiceInterface {
    
    List<PostDo> getPosts(int locationId);
    
    int insertPost(PostDo postDo);
}
