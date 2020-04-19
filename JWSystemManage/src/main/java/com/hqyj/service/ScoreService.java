package com.hqyj.service;

import com.hqyj.entity.Score;

public interface ScoreService {
	
	Score queryScoreById(int id);
	
	int updateScoreById(Score score);

}
