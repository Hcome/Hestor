package com.hqyj.service;

import com.hqyj.entity.Score;

public interface ScoreService {
	
	Score queryScoreById(int id);
	
	int updateScoreById(Score score);

	int insertScore(Score score);
	
	Integer selectScoreByUserName(String userName);
}
