package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BaseBallTeam;
import com.example.repository.BaseBallTeamRepository;

/**
 * 野球チームテーブルのリポジトリを使うサービスクラス.
 * 
 * @author kyoichiro.tomatsu
 *
 */
@Service
public class BaseBallTeamService {
	
	@Autowired
	private BaseBallTeamRepository baseBallTeamRepository;
	
	
	/**
	 *全件検索.
	 * 	
	 * @return 全ての野球チーム
	 */
	public List<BaseBallTeam> findAll(){
		return baseBallTeamRepository.findAll();
	}
	
	/**
	 * ID検索.
	 * @param id　検索したいID
	 * @return 検索された野球チーム
	 */
	public BaseBallTeam load(int id) {
		return baseBallTeamRepository.load(id);
	}
	
	
	
}
