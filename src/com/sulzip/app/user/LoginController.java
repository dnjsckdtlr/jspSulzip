package com.sulzip.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sulzip.app.Execute;

public class LoginController  implements Execute{
@Override
public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	
	String prevPage = req.getHeader("referer").substring("http://localhost:8085".length());
	session.setAttribute("prevPage", prevPage);
	
	Cookie[] cookies = req.getCookies();
		
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if ( cookie.getName().equals("userId")) {
				req.setAttribute("userId", cookie.getValue());
			}
		}
	}
		
		req.getRequestDispatcher("/app/user/login.jsp").forward(req, resp);
	}
}
