package com.sulzip.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminFrontController extends HttpServlet{
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
		case "/admin/product.adm":
			new AdminProductController().execute(req, resp);
			break;
		case "/admin/search.adm":
			new AdminSearchOkController().execute(req, resp);
			break;
		case "/admin/user.adm":
			new AdminUserController().execute(req,resp);
			break;
		case "/admin/userSearch.adm":
			new AdminUserSearchOkController().execute(req, resp);
			break;
		case "/admin/userDeleteOk.adm":
			new AdminUserDeleteOkController().execute(req, resp);
			break;
		case "/admin/board.adm":
			new AdminBoardController().execute(req, resp);
			break;
		case "/admin/boardSearch.adm":
			new AdminBoardSearchOKController().execute(req, resp);
			break;
		case "/admin/order.adm":
			new AdminOrderController().execute(req, resp);
			break;
		case "/admin/orderSearch.adm":
			new AdminOrderSearchOkController().execute(req, resp);
			break;
		
		}
	}
}
