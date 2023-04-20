package com.sulzip.app.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.sulzip.app.Execute;
import com.sulzip.app.admin.dao.AdminDAO;
import com.sulzip.app.admin.vo.BoardVO;
import com.sulzip.app.admin.vo.OrderSearchVO;
import com.sulzip.app.admin.vo.OrderVO;

public class AdminOrderSearchOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		OrderVO orderVO = new OrderVO();
		OrderSearchVO orderSearchVO = new OrderSearchVO();
		
		Gson gson = new Gson();
//		JsonArray result = new JsonArray();
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		
		String date = req.getParameter("date");
		String keyword = req.getParameter("keyword");
		String select = req.getParameter("select");
		
		orderSearchVO.setDate(date);
		orderSearchVO.setKeyword(keyword);
		orderSearchVO.setSelect(select);
		
		
			
//			if(select.equals("1")) {
//				List<OrderVO> orderList = adminDAO.searchName(orderSearchVO);
//				
//				System.out.println(orderList);
//				
//				result = gson.toJson(orderList);
//				
//			}else if(select.equals("2")) {
//				List<OrderVO> orderList = adminDAO.searchId(orderSearchVO);
//				
//				result = gson.toJson(orderList);
//			}
			System.out.println(orderSearchVO);
			List<OrderVO> orderList = adminDAO.orderDate(orderSearchVO);
			
			System.out.println(orderList);
			
//			for(OrderVO order : orderList) {
//				String jsonString = gson.toJson(order);
//				result.add(JsonParser.parseString(jsonString));
//			}
			
			String result = gson.toJson(orderList);
			
			
		out.print(result.toString());
		out.close();
	}

}













