/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs587.icampusfood.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author Joey
 */
public class SecureRandomGenerator {
    private static SecureRandomGenerator instance = null;
    private SecureRandom random = null;
    
    private SecureRandomGenerator(){
        this.random = new SecureRandom();
    }
    
    public static SecureRandomGenerator getInstance() {
        if (instance == null) {
            instance = new SecureRandomGenerator();
        }
        return instance;
    }
    
    public String nextRandomToken() {
        return new BigInteger(130, random).toString(32);
    }
}
