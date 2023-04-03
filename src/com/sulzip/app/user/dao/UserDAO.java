package com.sulzip.app.user.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sulzip.app.user.dto.UserDTO;

public class UserDAO {
	public SqlSession sqlSession;

	public UserDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public void join(UserDTO userDTO) {
		sqlSession.insert("user.join", userDTO);
	}

	public int login(UserDTO userDTO) {
		return sqlSession.selectOne("user.login", userDTO);
	}
	
	public void withdrawal(UserDTO userDTO) {
		sqlSession.update("user.withdrawal", userDTO);
	}
	
	public int withCheck(UserDTO userDTO) {
		return sqlSession.selectOne("user.withCheck", userDTO);
	}
}
