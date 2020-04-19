package com.hqyj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.dao.ScoreMapper;
import com.hqyj.entity.Score;
import com.hqyj.service.ScoreService;
@Service
public class ScoreServiceImpl implements ScoreService{

	@Autowired
	private ScoreMapper sm;
	@Override
	public Score queryScoreById(int id) {
		
		return sm.queryScoreById(id);
	}

	@Override
	public int updateScoreById(Score score) {
		
		return sm.updateScoreById(score);
	}
}
