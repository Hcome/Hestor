package com.hqyj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.entity.Score;
import com.hqyj.service.ScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {
	
	@Autowired
	private ScoreService ss;
	
	@RequestMapping(value = "/selectScoreById")
	public String selectScoreById(int id,HttpServletRequest request) {
		Score score = ss.queryScoreById(id);
		request.getSession().setAttribute("score", score);
		return "updateScore";
	}
	@RequestMapping("/updateScoreById")
	public String updateScoreByid(Score score,HttpServletRequest request) {
		Score score2 = (Score) request.getSession().getAttribute("score");
		score.setScoreId(score2.getScoreId());
		int num = ss.updateScoreById(score);
		System.out.println("影响的行数"+num);
		return "scoreList";
		
	}
}
