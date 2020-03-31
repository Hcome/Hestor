package com.hqyj.dao;

import com.hqyj.entity.Specialty;

public interface SpecialtyMapper {
    int deleteByPrimaryKey(Integer specialtyId);

    Specialty selectByPrimaryKey(Integer specialtyId);

    int updateByPrimaryKeySelective(Specialty record);

    int updateByPrimaryKey(Specialty record);
}