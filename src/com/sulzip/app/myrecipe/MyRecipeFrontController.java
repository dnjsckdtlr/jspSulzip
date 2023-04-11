package com.sulzip.app.myrecipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.sulkit.SulkitBoardController;

public class MyRecipeFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String target = req.getRequestURI().substring(req.getContextPath().length());
		System.out.println(target);
		switch(target) {
		case "/myrecipe/myRecipe.mrb":
			List<String> resultList = new ArrayList<String>();
			resultList.add("a");
			resultList.add("b");
			resultList.add("c");
			resultList.add("d");
			resultList.add("e");
			resultList.add("f");
			resultList.add("g");
			resultList.add("h");
			resultList.add("i");
			resultList.add("j");
			resultList.add("k");
			resultList.add("l");
			req.setAttribute("list", resultList);
			req.getRequestDispatcher("/app/myrecipe/myrecipe.jsp").forward(req, resp);
			break;
		case "/myrecipe/myRecipeDetail.mrb": 
			System.out.println("안녕하세요!!!");
			new MyRecipeDetailController().execute(req, resp);
			break;
		case "/myrecipe/myRecipeUpload.mrb": 
			System.out.println("안녕하세요!!!");
			new MyRecipeUploadController().execute(req, resp);
			break;
		case "/myrecipe/myRecipeUploadOk.mrb": 
			System.out.println("안녕하세요!!!");
			new MyRecipeUploadOkController().execute(req, resp);
			break;
		}
	}
}
