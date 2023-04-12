package com.sulzip.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sulzip.app.admin.vo.SearchVO;
import com.sulzip.app.admin.vo.UserListVO;
import com.sulzip.app.admin.vo.UserSearchVO;
import com.sulzip.app.product.vo.ProductVO;

public class AdminDAO {
	public SqlSession sqlsession;
	
	public AdminDAO() {
		sqlsession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public int sulkit() {
		return sqlsession.selectOne("admin.sulkit");
	}
	
	public int product(int categoryNumber) {
		return sqlsession.selectOne("admin.product", categoryNumber);
	}
	
	public List<ProductVO> sulkitList(){
		return sqlsession.selectList("admin.sulkitList");
	}
	
	public List<ProductVO> productList(){
		return sqlsession.selectList("admin.productList");
	}
	
	public List<ProductVO> searchPro(SearchVO searchVO){
		return sqlsession.selectList("admin.searchPro", searchVO);
	}
	
	public List<ProductVO> searchSul(SearchVO searchVO){
		return sqlsession.selectList("admin.searchSul", searchVO);
	}
	
	public List<ProductVO> searchProAll(SearchVO searchVO){
		return sqlsession.selectList("admin.searchProAll", searchVO);
	}
	
	public List<ProductVO> searchProEng(SearchVO searchVO){
		return sqlsession.selectList("admin.searchProEng", searchVO);
	}
	
	public List<ProductVO> searchSulEng(SearchVO searchVO){
		return sqlsession.selectList("admin.searchSulEng", searchVO);
	}
	
	public List<ProductVO> searchProAllEng(SearchVO searchVO){
		return sqlsession.selectList("admin.searchProAllEng", searchVO);
	}
	
//	============회원관리===============
	
	public List<UserListVO> userSelect(){
		return sqlsession.selectList("admin.userSelect");
	}
	
	public List<UserListVO> userId(UserSearchVO userSearchVO) {
		return sqlsession.selectList("admin.userId", userSearchVO);
	}
	
	public List<UserListVO> userName(UserSearchVO userSearchVO) {
		return sqlsession.selectList("admin.userName", userSearchVO);
	}
	
	public List<UserListVO> date(UserSearchVO userSearchVO){
		return sqlsession.selectList("admin.date", userSearchVO);
	}
	
	public List<UserListVO> searchUser(UserSearchVO userSearchVO){
		return sqlsession.selectList("admin.searchUser", userSearchVO);
	}
	
}













