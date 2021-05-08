package com.gxwz.medical.dao;

import com.gxwz.medical.entity.Province;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProvinceMapper {
    List<Province> list();
}
