package com.sulzip.app.order.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sulzip.app.order.dto.OrderDTO;

public class OrderDAO {
	public SqlSession sqlSession;
	
	public OrderDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void insert(OrderDTO orderDTO) {
		sqlSession.insert("order.orderInsert", orderDTO);
	}
	

}
