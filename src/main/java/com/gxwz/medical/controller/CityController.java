package com.gxwz.medical.controller;

import com.gxwz.medical.entity.City;
import com.gxwz.medical.entity.Group;
import com.gxwz.medical.entity.Town;
import com.gxwz.medical.service.CityService;
import com.gxwz.medical.util.Json;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/area")
public class CityController {


    @Inject
    private CityService cityService;

    /**
     * 首先获取全部的省份、村组
     * @param map
     * @return
     */
    @RequestMapping(value="/toAdd")
    public String allProvince(ModelMap map){
        map.addAttribute("provinceList", cityService.getAllProvince());
        return "Area/AreaAdd";
    }

    /**
     * 根据省份获取城市
     * @param id
     * @return
     */
    @RequestMapping(value = "/getCityByProvinceId/{id}")
    @ResponseBody
    public Json getCityByProvinceId(@PathVariable("id") String id){
        List<City> cityList = cityService.getCityByProvinceId(id);
        if (cityList!=null){
            return new Json(true,"success",cityList);
        } else {
            return new Json(false,"fail",null);
        }
    }

    /**
     * 根据城市获取区域
     * @param id
     * @return
     */
    @RequestMapping(value = "/getAreaByCityId/{id}")
    @ResponseBody
    public Json getAreaByCityId(@PathVariable("id") String id){
        List<Town> areaList = cityService.getAreaByCityId(id);
        if (areaList!=null){
            return new Json(true,"success",areaList);
        } else {
            return new Json(false,"fail",null);
        }
    }

    /**
     * 根据城市获取区域
     * @param id
     * @return
     */
    @RequestMapping(value = "/getAreaByGroupId/{id}")
    @ResponseBody
    public Json getAreaByGroupId(@PathVariable("id") String id){
        List<Group> groupList = cityService.getAreaByGroupId(id);
        if (groupList!=null){
            return new Json(true,"success",groupList);
        } else {
            return new Json(false,"fail",null);
        }
    }

}
