package com.sulzip.app.cart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sulzip.app.cart.vo.CartVO;
import com.sulzip.app.cart.vo.CartVO2;

public class CartDAO {
	public SqlSession sqlSession;
	
	public CartDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public List<CartVO> select1(int userNumber) {
		return sqlSession.selectList("cart.select1", userNumber);
	}
	
	public List<CartVO> select2(int userNumber) {
		return sqlSession.selectList("cart.select2", userNumber);
	}
	
	public void delete(Map<String, Integer> proInfo) {
		sqlSession.delete("cart.delete", proInfo);
	}
	
	public void insert(CartVO2 cartVO2) {
		sqlSession.insert("cart.insert", cartVO2);
	}
	
	public int cartCheck(Map<String, Integer> cartInfo) {
		return sqlSession.selectOne("cart.cartCheck", cartInfo);
	}
}
