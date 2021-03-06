package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.BaseBallTeam;

/**
 * 野球チームテーブルを操作するリポジトリクラス.
 * 
 * @author kyoichiro.tomatsu
 *
 */
@Repository
public class BaseBallTeamRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	 /** マッパー */
	private static final RowMapper<BaseBallTeam> BASEBALLTEAM_ROW_MAPPER = (rs, i) -> {
		  BaseBallTeam baseBallTeam = new BaseBallTeam();
		  
		  baseBallTeam.setId(rs.getInt("id"));
		  baseBallTeam.setLeagueName(rs.getString("league_name"));
		  baseBallTeam.setTeamName(rs.getString("team_name"));
		  baseBallTeam.setHeadquarters(rs.getString("headquarters"));
		  baseBallTeam.setInauguration(rs.getString("inauguration"));
		  baseBallTeam.setHistory(rs.getString("history"));
		  	  
		  return baseBallTeam;
	  };
	  
	 /**
	  * 全件検索.
	  * 
	 * @return　全ての野球チーム
	 */
	public List<BaseBallTeam> findAll(){
		  
		  String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams ORDER BY inauguration ";
		  List<BaseBallTeam> baseBallTeamList = template.query(sql, BASEBALLTEAM_ROW_MAPPER);
		  
		  return baseBallTeamList;
	  }
	  
	  
	  /**
	   * ID検索.
	 * @param id　検索したいID
	 * @return 検索された野球チーム
	 */
	public BaseBallTeam load(int id) {
		  
		  String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams WHERE id=:id";
		  SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		  BaseBallTeam baseBallTeam = template.queryForObject(sql, param, BASEBALLTEAM_ROW_MAPPER);
		  
		  return baseBallTeam;
	  }
	  
	  
}
