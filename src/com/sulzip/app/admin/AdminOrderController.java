package com.sulzip.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.admin.dao.AdminDAO;
import com.sulzip.app.admin.vo.OrderVO;
import com.sulzip.app.order.dto.OrderDTO;

public class AdminOrderController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		OrderVO orderVO = new OrderVO();
		
		List<OrderVO> orderList = adminDAO.orderSelect();
		
		System.out.println(orderList);
		
		req.setAttribute("orderList", orderList);
		
		req.getRequestDispatcher("/app/admin/adminorder.jsp").forward(req, resp);
	}

}




















