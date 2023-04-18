package com.sulzip.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.user.dao.UserDAO;
import com.sulzip.app.user.dto.UserDTO;

public class FindidpwOkController implements Execute {
	@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			UserDTO userDTO = new UserDTO();
			UserDAO userDAO = new UserDAO();
			String path = null;			
			
			String[] phoneArr = req.getParameterValues("userPhone");
			String phoneNumber ="";
			for(int i =0; i<phoneArr.length; i++) {
				phoneNumber += phoneArr[i];
			}
			System.out.println(phoneNumber);
			System.out.println(req.getParameter("userName"));
			
			userDTO.setUserName(req.getParameter("userName"));
			userDTO.setUserPhone("userPhone");
			
			String userId =userDAO.selectId(userDTO);
			String userPw = userDAO.selectPw(userDTO);
			
			
			if(userId == null ) {
				path="/app/user/findidpw.jsp";
				req.setAttribute(userPw, phoneNumber);
			}
			
			if(userPw == null) {
				path="/app/user/fididpw.jsp";
				req.setAttribute(userPw, phoneNumber);
			}
			
			System.out.println(userId);
			
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		}
	   
	}




