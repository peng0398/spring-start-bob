package com.play.bob.userinfo.controller;

import com.play.bob.userinfo.bean.City;
import com.play.bob.mapper.CityMapper;
import com.play.bob.userinfo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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

    @RequestMapping("/addcity")
    @ResponseBody
    String addCity() {
        City city = new City();
        city.setCountry("中国");
        city.setState("北京");
        city.setName("北京市");
        boolean result = cityMapper.addCity(city.getName(), city.getState(), city.getCountry());
        if (result) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }
}
