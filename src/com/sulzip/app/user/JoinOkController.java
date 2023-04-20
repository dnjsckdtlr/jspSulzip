package com.sulzip.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sulzip.app.Execute;
import com.sulzip.app.user.dao.UserDAO;
import com.sulzip.app.user.dto.UserDTO;

//int userNumber;
//String userStatus;


//String userRegistrationDate;
//String userId;
//String userPw;
//String userName;
//String userPhone;
//String userGender;
//String userEmail;
//String userRegistrationNumber;

public class JoinOkController implements Execute{
	 @Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	      UserDAO userDAO = new UserDAO();
	      UserDTO userDTO = new UserDTO();
	      HttpSession session = req.getSession();
	      req.setCharacterEncoding("utf-8");
	      
	      userDTO.setUserRegistrationDate(req.getParameter("userRegistrationDate"));
	      userDTO.setUserId(req.getParameter("userId"));
	      userDTO.setUserPw(req.getParameter("userPw"));
	      userDTO.setUserName(req.getParameter("userName"));
	      userDTO.setUserRegistrationNumber(req.getParameter("userRegistrationNumber"));
	      userDTO.setUserGender(req.getParameter("userGender"));
	      userDTO.setUserEmail(req.getParameter("userEmail"));
	      userDTO.setUserPhone(req.getParameter("userPhone"));
	      
	      userDAO.join(userDTO);
	      
	      resp.sendRedirect("/");
	      	 
		 
	}
}
