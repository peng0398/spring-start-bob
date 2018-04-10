package com.play.bob.mapper;


import com.play.bob.city.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author baobo.peng
 */
@Mapper
public interface CityMapper {

    @Select("SELECT id, name, state, country FROM city WHERE state = #{state}")
    List<City> findByState(String state);

    @Select("SELECT * FROM city")
    List<City> findAll();

    @Insert("INSERT INTO city (name, state, country) VALUES (#{name}, #{state}, #{country})")
    boolean addCity(@Param("name") String name, @Param("state") String state, @Param("country") String country);
}