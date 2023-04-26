package com.sulzip.app.sulkit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sulzip.app.sulkit.dto.SulkitDTO;
import com.sulzip.app.sulkit.vo.SulkitVO;

public class SulkitDAO {
	public SqlSession sqlsession;
	
	public SulkitDAO() {
		sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public SulkitDTO selectSulkit (int sulkitNumber){
		return sqlsession.selectOne("sulkit.selectSulkit", sulkitNumber);
	}
	
	public List<SulkitVO> recipe(int productNumber) {
		return sqlsession.selectList("sulkit.recipe", productNumber);
	}
	
	public List<SulkitDTO> sulkitBoard(Map<String, Object> pageMap) {
		return sqlsession.selectList("sulkit.sulkitBoard", pageMap);
	}
	
	public int getTotal() {
		return sqlsession.selectOne("sulkit.getTotal");
	}
}
