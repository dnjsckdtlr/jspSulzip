package com.sulzip.app.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sulzip.app.Execute;
import com.sulzip.app.order.dao.OrderDAO;
import com.sulzip.app.order.dto.OrderDTO;

//int orderNumber;
//String orderDate;
//int productEa;
//int productTotalPrice;
//String pickupStore;
//String orderMessage;
//int userNumber;


public class OrderOkController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		OrderDAO orderDAO = new OrderDAO();
		OrderDTO orderDTO = new OrderDTO();
		
		HttpSession session = req.getSession();

		orderDTO.setUserNumber((int)session.getAttribute("userNumber"));
		orderDTO.setProductTotalPrice(Integer.valueOf(req.getParameter("productTotalPrice")));
		orderDTO.setOrderPay(Integer.valueOf(req.getParameter("payingtype")));
		orderDTO.setOrderMessage(req.getParameter("orderMessage"));
		orderDTO.setPickupStore(req.getParameter("pickupStore"));
		orderDTO.setAccountName(req.getParameter("accountName"));
		System.out.println(orderDTO.toString());
		
		orderDAO.insert(orderDTO);
		
		resp.sendRedirect("/");
	}
}
