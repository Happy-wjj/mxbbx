package com.gxwz.medical.dao;

import com.gxwz.medical.entity.Group;

import java.util.List;

public interface GroupMapper {
    public List<Group> getAreaByGroupId(String id);
}
