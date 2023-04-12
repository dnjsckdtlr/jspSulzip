package com.sulzip.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.user.dao.UserDAO;
import com.sulzip.app.user.dto.UserDTO;

public class WithdrawalOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		
		req.setCharacterEncoding("utf-8");
		
		userDTO.setUserId(req.getParameter("userId"));
		userDTO.setUserPw(req.getParameter("userPw"));
		
		String path = null;
		if(userDAO.withCheck(userDTO) != 0) {
			userDAO.withdrawal(userDTO);
			path = "/";
		}else {
			path = "/user/withdrawal.usr?result=false";
		}
		
		resp.sendRedirect(path);
				
	}

}













