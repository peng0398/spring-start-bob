package com.play.bob.userinfo.controller;

import com.play.bob.city.bean.City;
import com.play.bob.mapper.CityMapper;
import com.play.bob.userinfo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    CityMapper cityMapper;

    /**
     * 获取用户信息
     */
    @RequestMapping("/single")
    @ResponseBody
    User getUserInfo() {
        User user = new User("bob", "Wali", System.currentTimeMillis());
        List<City> cities = cityMapper.findByState("北京");
        if (cities != null && cities.size() > 0) {
            user.setCity(cities.get(0));
        }
        return user;
    }

    @RequestMapping("/list")
    @ResponseBody
    List<User> getUsersInfo() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User("bob", "Wali", System.currentTimeMillis()));
        }
        return users;
    }

    @RequestMapping("/map")
    @ResponseBody
    Map<String, String> getConfig() {
        Map<String, String> config = new HashMap<>();
        config.put("host", "10.2.3.6");
        config.put("port", "8080");
        config.put("address", "北京市");
        return config;
    }
}
