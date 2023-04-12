package com.sulzip.app.sulkit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.product.AlcoholDetailController;
import com.sulzip.app.product.AlcoholListOkController;

public class SulkitFrontController extends HttpServlet {
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
		case "/sulkit/sulkitDetail.suk": 
			new SulkitBoardController().execute(req, resp);
			break;
		case "/sulkit/sulkit.suk" : 
			new SulkitListOkController().execute(req, resp);
			break;
		}
	}
}
