package com.sulzip.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sulzip.app.Execute;
import com.sulzip.app.user.dao.UserDAO;
import com.sulzip.app.user.dto.UserDTO;

public class LoginOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		String userId= req.getParameter("userId");
		String userPw= req.getParameter("userPw");
		int userNumber = 0;
		String path = null;
		String remember = req.getParameter("remember");
		HttpSession session = req.getSession();
		String prevPage = (String)req.getSession().getAttribute("prevPage");
		
		userDTO.setUserId(userId);
		userDTO.setUserPw(userPw);
		
		try {
			userNumber= userDAO.login(userDTO);
			userId= userDAO.getUserId(userNumber);
			path = prevPage;
			
			if(remember != null) {
				Cookie cookie = new Cookie("userId", userId);
				cookie.setMaxAge(60 * 60 *24);
				
				resp.addCookie(cookie);
			}
				session.setAttribute("userNumber", userNumber);
				session.setAttribute("userId", userId);
		} catch (NullPointerException e) {
				path = "/user/login.usr?result=false";
		}catch (Exception e) {
			System.out.println("예상치 못한 오류");
		e.printStackTrace();
		}
		
		resp.sendRedirect(path);
		
	}

}









