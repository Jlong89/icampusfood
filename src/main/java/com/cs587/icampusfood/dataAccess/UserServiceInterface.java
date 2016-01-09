/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.dataAccess;

import com.cs587.icampusfood.domain.business.User;
import java.util.List;

/**
 *
 * @author Joey
 */
public interface UserServiceInterface {
    /**
     * @return all the users
     */
    List<User> getAllUsers();
    /**
     * @param user
     * @return the number of rows affected
     */
    int saveUser(User user);
    
    boolean checkLogin(String token);
    
    String login(User user);
}
