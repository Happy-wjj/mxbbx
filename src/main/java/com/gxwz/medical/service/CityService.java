package com.gxwz.medical.service;

import com.gxwz.medical.dao.CityMapper;
import com.gxwz.medical.dao.GroupMapper;
import com.gxwz.medical.dao.ProvinceMapper;
import com.gxwz.medical.dao.TownMapper;
import com.gxwz.medical.entity.Group;
import com.gxwz.medical.entity.Town;
import com.gxwz.medical.entity.City;
import com.gxwz.medical.entity.Province;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


/**
 * Created with Intellij IDEA.
 * User: wesley
 * Date: 2015/4/16
 * Time: 18:03
 * 有关城市区的服务层
 */
@Service
public class CityService {

    @Inject
    private CityMapper cityMapper;
    @Inject
    private ProvinceMapper provinceMapper;
    @Inject
    private TownMapper townMapper;
    @Inject
    private GroupMapper groupMapper;

    public List<Province> getAllProvince() { return provinceMapper.list(); }

    public List<City> getCityByProvinceId(String id) {
        return cityMapper.getCityByProvinceId(id);
    }

    public List<Town> getAreaByCityId(String id) {
        return townMapper.getAreaByCityId(id);
    }

    public List<Group> getAreaByGroupId(String id) { return groupMapper.getAreaByGroupId(id); }
}
