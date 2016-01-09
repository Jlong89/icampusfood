/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.dataAccess;

import com.cs587.icampusfood.domain.business.User;
import com.cs587.icampusfood.persistence.businessMappers.FavoriteMapper;
import com.cs587.icampusfood.persistence.businessMappers.FriendsMapper;
import com.cs587.icampusfood.persistence.businessMappers.TokenMapper;
import com.cs587.icampusfood.persistence.businessMappers.UserMapper;
import com.cs587.icampusfood.persistence.dataObjects.FriendsDBDO;
import com.cs587.icampusfood.persistence.dataObjects.TokenDBDO;
import com.cs587.icampusfood.persistence.dataObjects.UserDBDO;
import com.cs587.icampusfood.util.SecureRandomGenerator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joey
 */
@Service("userService")
public class UserServiceImpl implements UserServiceInterface {

    private UserMapper userMapper;
    private TokenMapper tokenMapper;
    private FavoriteMapper favoriteMapper;
    private FriendsMapper friendsMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    @Autowired
    public void setTokenMapper(TokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper;
    }
    
    @Autowired
    public void setFavoriteMapper(FavoriteMapper favoriteMapper) {
        this.favoriteMapper = favoriteMapper;
    }
    
    @Autowired
    public void setFriendsMapper(FriendsMapper friendsMapper){
        this.friendsMapper = friendsMapper;
    }

    /**
     * @return all the users
     */
    @Override
    public List<User> getAllUsers() {
        List<UserDBDO> userDB = this.userMapper.getAllUsers();
        List<User> users = new ArrayList<>(userDB.size());
        for(UserDBDO d : userDB){
            List<Integer> favoriateLocationIdList = favoriteMapper.getFavoriteIds(d.getUserName());
            List<FriendsDBDO> friendsDBDOList = friendsMapper.getFriends(d.getUserName());
            List<String> friends = new ArrayList<String>(friendsDBDOList.size());
            for(FriendsDBDO dbdo : friendsDBDOList)friends.add(dbdo.getSlaveFriend());
            
            User user = new User(d.getUserId(), d.getUserName(),
                    d.getPassword(),favoriateLocationIdList,friends);
            users.add(user);
        }
        return users;
    }

    /**
     * @param user
     * @return the number of rows affected
     */
    @Override
    public int saveUser(User user){
        UserDBDO uDo = new UserDBDO();
        uDo.setUserId(0);
        uDo.setUserName(user.getUserName());
        uDo.setPassword(user.getPassword());
        if(this.userMapper.insertUser(uDo)==1) return this.userMapper.getMaxUserId();
        else return -1;
        //else return this.userMapper.updateUser(uDo)==1;
    }
    
    @Override
    public boolean checkLogin(String token){
        return tokenMapper.checkLogin(token)!=null;
    }
    
    @Override
    public String login(User user){
        UserDBDO userDbDo = userMapper.getUser(user.getUserName());
        int userId = userDbDo.getUserId();
        if(userDbDo==null || userDbDo.getUserId()<=0) return null;
        TokenDBDO tokenEx = tokenMapper.isUserExistInTokenTable(userId);
        SecureRandomGenerator sr = SecureRandomGenerator.getInstance();
        String newToken = sr.nextRandomToken();
        TokenDBDO tokenDbDo = new TokenDBDO();
        tokenDbDo.setUserId(userId);
        tokenDbDo.setToken(newToken);
        if(tokenEx!=null && !tokenEx.getToken().equals("")){
            tokenMapper.updateToken(tokenDbDo);
        }else{
            tokenMapper.login(tokenDbDo);
        }
        return newToken;
    }
}
