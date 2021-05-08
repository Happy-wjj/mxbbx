package com.gxwz.medical.dao;

import com.gxwz.medical.entity.City;

import java.util.List;

public interface CityMapper {

    public List<City> getCityByProvinceId(String id);
}
