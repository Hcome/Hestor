package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.Score;

public interface ScoreMapper {
    
	List<Score> queryScoreAll();
	/**
	 * 通过成绩的id去查询
	 * @param id
	 * @return
	 */
	Score queryScoreById(int id);
	/**
	 * 更新成绩
	 * @param score
	 * @return
	 */
	int updateScoreById(Score score);
	
}