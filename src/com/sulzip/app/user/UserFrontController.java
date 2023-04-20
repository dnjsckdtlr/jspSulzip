package com.sulzip.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFrontController extends HttpServlet {

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
		
		case "/user/join.usr" : 
			System.out.println("user!!!");
			req.getRequestDispatcher("/app/user/join.jsp").forward(req, resp);
			break;
		case "/user/joinOk.usr" :
			new JoinOkController().execute(req, resp);
			break;
		case "/user/checkIdOk.usr" :
		    new CheckIdOkController().execute(req, resp);
		    break;
		case "/user/withdrawal.usr" :
			req.getRequestDispatcher("/app/user/withdrawal.jsp").forward(req, resp);
			break;
		case "/user/withdrawalOk.usr" :
			new WithdrawalOkController().execute(req, resp);
			break;
		case "/user/login.usr" : 
			System.out.println("login!!!");
			new LoginController().execute(req, resp);
			break;
		case "/user/loginOk.usr" :
			new LoginOkController().execute(req, resp);
			break;
		case "/user/logoutOk.usr" :
			new LogoutOkController().execute(req, resp);
			break;
			
		case "/user/mypage.usr" :
			new MypageController().execute(req, resp);
			break;
			
		case "/user/mypageOk.usr" :
			new MypageOkController().execute(req, resp);
			break;
			
		case "/user/edituserinfo.usr" :
			new EdituserinfoController().execute(req, resp);
			break;
			
		case "/user/edituserinfoOk.usr" :
			new EdituserinfoOkController().execute(req, resp);
			break;
			
//			아이디 찾기 
		case "/user/findidpw.usr" :
			new FindidpwController().execute(req, resp);
			break;
//			아이디 찾기 ok
		case "/user/findidOk.usr" :
			new FindidOkController().execute(req, resp);
			break;
		case "/user/findpwOk.usr" :
			new FindpwOkController().execute(req, resp);
			break;
		}
		
	}
}
