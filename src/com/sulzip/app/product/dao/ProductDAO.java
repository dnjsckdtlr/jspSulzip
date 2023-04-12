package com.sulzip.app.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sulzip.app.product.dto.ProductDTO;

public class ProductDAO {
	public SqlSession sqlsession;
	
	public ProductDAO() {
		sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public ProductDTO alcohol (int productNumber){
		return sqlsession.selectOne("product.alcohol", productNumber);
	}
	
	public ProductDTO ingredients(int productNumber){
		return sqlsession.selectOne("product.ingredients", productNumber);
	}
	
	public ProductDTO supplies(int productNumber){
		return sqlsession.selectOne("product.supplies", productNumber);
	}
	
	public int getTotal(int categoryNumber) {
		return sqlsession.selectOne("product.getTotal", categoryNumber);
	}

	public List<ProductDTO> alcoholBoard(Map<String, Integer> pageMap) {
		return sqlsession.selectList("product.alcoholBoard", pageMap);
	}
	
	public List<ProductDTO> ingreBoard(Map<String, Integer> pageMap) {
		return sqlsession.selectList("product.ingreBoard", pageMap);
	}
	
	public List<ProductDTO> supBoard(Map<String, Integer> pageMap) {
		return sqlsession.selectList("product.supBoard", pageMap);
	}
}
