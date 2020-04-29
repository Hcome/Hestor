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
	/**
	 * 在学生完成考试之后，会进行对成绩表的更新
	 * @param score
	 * @return
	 */
	int insertScore(Score score);
	/**
	 * 根据用户名去查询用户是学生的成绩信息
	 * @param userName
	 * @return
	 */
	Integer selectScoreByUserName(String userName);
	
}