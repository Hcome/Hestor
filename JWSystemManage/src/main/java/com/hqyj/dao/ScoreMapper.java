package com.hqyj.dao;

import com.hqyj.entity.Score;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer scoreId);

    Score selectByPrimaryKey(Integer scoreId);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}