package com.sulzip.app.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sulzip.app.Execute;
import com.sulzip.app.cart.dao.CartDAO;
import com.sulzip.app.cart.vo.CartVO2;

public class CartAddOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartDAO cartDAO = new CartDAO();
		CartVO2 cartVO2 = new CartVO2();
		HttpSession session = req.getSession();
		Gson gson = new Gson();
		PrintWriter out = resp.getWriter();
		
		int userNumber = (int)session.getAttribute("userNumber");
		int productNumber = Integer.valueOf(req.getParameter("productNumber"));
		int productEa = Integer.valueOf(req.getParameter("productEa")); 
		int productTotalPrice= Integer.valueOf(req.getParameter("productPrice")) * productEa;
		
		cartVO2.setUserNumber(userNumber);
		cartVO2.setProductNumber(productNumber);
		cartVO2.setProductTotalPrice(productTotalPrice);
		cartVO2.setProductEa(productEa);
		
		System.out.println(cartVO2);
		Map<String, Integer> cartInfo = new HashMap<String, Integer>();
		cartInfo.put("userNumber", userNumber);
		cartInfo.put("productNumber", productNumber);
		int cartCheck = cartDAO.cartCheck(cartInfo);
		String replyJson;
		
		if(cartCheck == 0) {
			cartDAO.insert(cartVO2);
			replyJson = gson.toJson("success");
		} else {
			replyJson = gson.toJson("fail");
		}
		
		out.print(replyJson.toString());
		out.close();
	}

}
