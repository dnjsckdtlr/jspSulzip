package com.sulzip.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.admin.dao.AdminDAO;
import com.sulzip.app.admin.vo.UserListVO;

public class AdminUserController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		UserListVO userListVO = new UserListVO();
		
		List<UserListVO> userList = adminDAO.userSelect();
		
		req.setAttribute("userList", userList);
		
		req.getRequestDispatcher("/app/admin/adminuser.jsp").forward(req, resp);
		System.out.println("jsp !!!!!!!!!!!!!");
		
	}

}














