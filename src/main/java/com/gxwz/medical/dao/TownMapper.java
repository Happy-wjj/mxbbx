package com.gxwz.medical.dao;

import com.gxwz.medical.entity.Town;

import java.util.List;

public interface TownMapper extends BaseMapper<Town>{
    public List<Town> getAreaByCityId(String id);
}
