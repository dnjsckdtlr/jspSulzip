package com.sulzip.app.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductFrontController extends HttpServlet {
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
		case "/product/alcohol.prd" : 
			new AlcoholListOkController().execute(req, resp);
			break;
		case "/product/alcoholDetail.prd": 
			new AlcoholDetailController().execute(req, resp);
			break;
		case "/product/ingredients.prd" : 
			new IngredientsListOkController().execute(req, resp);
			break;
		case "/product/ingredientsDetail.prd": 
			new IngredientsDetailController().execute(req, resp);
			break;
		case "/product/supplies.prd" : 
			new SuppliesListOkController().execute(req, resp);
			break;
		case "/product/suppliesDetail.prd": 
			new SuppliesDetailController().execute(req, resp);
			break;
		}
	}
}
