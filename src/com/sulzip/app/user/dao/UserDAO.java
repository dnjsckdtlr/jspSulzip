package com.sulzip.app.user.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sulzip.app.clientboard.dto.ClientBoardDTO;
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
	
	public boolean checkId(String userId) {
		return (Integer)sqlSession.selectOne("user.checkId", userId) <1;
	}
	
	public String getUserId(int userNumber) {
		return sqlSession.selectOne("user.getUserId", userNumber);
	}
	
	public UserDTO getUserDetail(int userNumber) {
		return sqlSession.selectOne("user.selectDetail", userNumber);
	}
	
	public void modify(UserDTO userDTO) {
		sqlSession.update("user.modify", userDTO);
	}
	
//	아이디 찾기
	public String selectId(UserDTO userDTO) {
		  return sqlSession.selectOne("user.selectId", userDTO);
	}
	
//	비밀번호 찾기
	public String selectPw(UserDTO userDTO) {
	return	sqlSession.selectOne("user.selectPw", userDTO);
	}

}
	
	
/**/



