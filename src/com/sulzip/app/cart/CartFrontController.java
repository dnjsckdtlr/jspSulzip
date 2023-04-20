package com.sulzip.app.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.clientboard.ServiceListOkController;

public class CartFrontController extends HttpServlet{
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
		case "/cart/cart.car":
			new CartListOkController().execute(req, resp);
			break;
		case "/cart/cartDelOk.car":
			new CartDelOkController().execute(req, resp);
			break;
		case "/cart/cartAddOk.car":
			new CartAddOkController().execute(req, resp);
			break;
		}
	}
}
