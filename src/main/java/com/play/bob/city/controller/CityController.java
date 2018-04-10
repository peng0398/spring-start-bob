package com.play.bob.city.controller;

import com.play.bob.base.BaseResult;
import com.play.bob.city.bean.City;
import com.play.bob.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author baobo.peng
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityMapper cityMapper;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    String addCity(@RequestParam(value = "name") String name, @RequestParam(value = "state") String state, @RequestParam(value = "country") String country) {
        if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(state) && !StringUtils.isEmpty(country)) {
            City city = new City();
            city.setCountry(name);
            city.setState(state);
            city.setName(country);
            boolean result = cityMapper.addCity(city.getName(), city.getState(), city.getCountry());
            if (result) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return "参数有误，请重试";
        }
    }

    @RequestMapping(value = "/getAll")
    @ResponseBody
    BaseResult<List<City>> getAllCities() {
        BaseResult<List<City>> result = new BaseResult<>();
        result.setCode(200);
        result.setMsg("success");
        result.setData(cityMapper.findAll());
        return result;
    }
}
