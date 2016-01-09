package com.cs587.icampusfood.controller;

import java.util.List;

import com.cs587.icampusfood.domain.business.User;
import com.cs587.icampusfood.dataAccess.UserServiceInterface;
import com.cs587.icampusfood.domain.business.YelpApi;
import com.cs587.icampusfood.domain.business.YelpBusinessEntity;
import com.cs587.icampusfood.persistence.test.domainTest.TestDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    
    @Autowired
    private UserServiceInterface userService;
    @Autowired
	private TestDB testDB;

    @RequestMapping(value = "/index")
    public ModelAndView index() {
    	ModelAndView mv = new ModelAndView();
        mv.setViewName("adminhome");
        return mv;
    }
    
    @RequestMapping(value = "/restapi")
    public ModelAndView restapi() {
    	ModelAndView mv = new ModelAndView();
        mv.setViewName("restapi");
        return mv;
    }

}

