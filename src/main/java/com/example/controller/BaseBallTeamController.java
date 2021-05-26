package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BaseBallTeam;
import com.example.service.BaseBallTeamService;

/**
 * 野球チームを操作するコントローラークラス.
 * 
 * @author kyoichiro.tomatsu
 *
 */
@Controller
@RequestMapping("/baseball")
public class BaseBallTeamController {
	
	@Autowired
	private BaseBallTeamService baseBallTeamService;
	
	/**
	 * 野球チーム一覧画面の表示.
	 * 
	 * @param model　リクエストスコープ
	 * @return　野球チーム一覧画面
	 */
	@RequestMapping("/")
	public String index(Model model) {
		List<BaseBallTeam> baseBallTeams = baseBallTeamService.findAll();
		model.addAttribute("baseBallTeams", baseBallTeams);
		
		return "baseballList";
	}
	
	/**
	 * 野球チーム詳細画面の表示
	 * 
	 * @param id ID
	 * @param model リクエストスコープ
	 * @return　野球チーム詳細画面
	 */
	@RequestMapping("/detail")
	public String detail(int id,Model model) {
		BaseBallTeam baseBallTeam = baseBallTeamService.load(id);
		model.addAttribute("baseBallTeam", baseBallTeam);
		
		return "baseballDetail";
	}
}
