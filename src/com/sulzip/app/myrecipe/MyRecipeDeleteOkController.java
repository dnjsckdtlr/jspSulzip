package com.sulzip.app.myrecipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.myrecipe.dao.MyRecipeDAO;

public class MyRecipeDeleteOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyRecipeDAO myRecipeDAO = new MyRecipeDAO();
		
		int boardNum = Integer.parseInt(req.getHeader("referer").substring("http://localhost:8085/myrecipe/myRecipeDetail.mrb?num=".length()));
		
		myRecipeDAO.deleteFile(boardNum);
		myRecipeDAO.deletePmBridge(boardNum);
		myRecipeDAO.delete(boardNum);
		
		resp.sendRedirect("/myrecipe/myRecipe.mrb");
	}

}
