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
			new MyRecipeListOkController().execute(req, resp);
			break;
		case "/myrecipe/myRecipeDetail.mrb": 
			new MyRecipeDetailController().execute(req, resp);
			break;
		case "/myrecipe/myRecipeUpload.mrb": 
			new MyRecipeUploadController().execute(req, resp);
			break;
		case "/myrecipe/myRecipeUploadOk.mrb": 
			new MyRecipeUploadOkController().execute(req, resp);
			break;
		case "/myrecipe/myRecipeUpdate.mrb": 
			new MyRecipeUpdateController().execute(req, resp);
			break;
		case "/myrecipe/myRecipeUpdateOk.mrb": 
			new MyRecipeUpdateOkController().execute(req, resp);
			break;
		case "/myrecipe/myRecipeDelete.mrb": 
			new MyRecipeDeleteOkController().execute(req, resp);
			break;
		}
	}
}
