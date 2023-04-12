package com.sulzip.app.myrecipe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sulzip.app.file.dto.FileDTO;
import com.sulzip.app.myrecipe.dto.MyRecipeDTO;
import com.sulzip.app.myrecipe.vo.MyRecipeListVO;
import com.sulzip.app.myrecipe.vo.MyRecipeVO;
import com.sulzip.app.pmbridge.dto.PmBridgeDTO;
import com.sulzip.app.product.dto.ProductDTO;

public class MyRecipeDAO {
	public SqlSession sqlSession;
	
	public MyRecipeDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void insert(MyRecipeDTO myRecipeDTO) {
	    sqlSession.insert("myRecipe.insert", myRecipeDTO);
	}
	
	public MyRecipeDTO select(int myRecipeNumber) {
		return sqlSession.selectOne("myRecipe.select", myRecipeNumber);
	}
	
	public List<MyRecipeVO> ingre(int myRecipeNumber) {
		return sqlSession.selectList("myRecipe.ingre", myRecipeNumber);
	}
	
	public List<ProductDTO> category(int categoryNumber){
		return sqlSession.selectList("myRecipe.category", categoryNumber);
	}
	
	public void uploadFile(FileDTO fileDTO) {
		sqlSession.insert("file.insert", fileDTO);
	}
	
	public int getSequence() {
		return sqlSession.selectOne("myRecipe.getSequence");
	}
	
	public void insertPmBridge(PmBridgeDTO pmBridgeDTO) {
		sqlSession.insert("PmBridge.insert", pmBridgeDTO);
	}
	
	public List<MyRecipeDTO> selectMrb(Map<String, Integer> pageMap){
		return sqlSession.selectList("myRecipe.selectMrb", pageMap);	
	}
	
	public int getTotal() {
		return sqlSession.selectOne("myRecipe.getTotal");
	}
	
	public void upThumb(Map<String, String> thumbInfo) {
		sqlSession.update("myRecipe.upThumb", thumbInfo);
	}
}
