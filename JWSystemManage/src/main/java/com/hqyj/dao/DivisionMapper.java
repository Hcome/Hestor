package com.hqyj.dao;

import com.hqyj.entity.Division;

public interface DivisionMapper {
    int deleteByPrimaryKey(Integer universityDivisionId);

    Division selectByPrimaryKey(Integer universityDivisionId);

    int updateByPrimaryKeySelective(Division record);

    int updateByPrimaryKey(Division record);
}