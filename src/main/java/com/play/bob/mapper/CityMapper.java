package com.play.bob.mapper;


import com.play.bob.userinfo.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {

    @Select("SELECT id, name, state, country FROM city WHERE state = #{state}")
    List<City> findByState(String state);

    @Insert("INSERT INTO city (name, state, country) VALUES (#{name}, #{state}, #{country})")
    boolean addCity(@Param("name") String name, @Param("state") String state, @Param("country") String country);
}