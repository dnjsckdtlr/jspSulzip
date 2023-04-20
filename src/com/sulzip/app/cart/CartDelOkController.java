package com.sulzip.app.cart;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sulzip.app.Execute;
import com.sulzip.app.cart.dao.CartDAO;

public class CartDelOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartDAO cartDAO = new CartDAO();
		HttpSession session = req.getSession();
		
		Map<String, Integer> proInfo = new HashMap<String, Integer>();
		int userNumber = (int)session.getAttribute("userNumber");
		proInfo.put("userNumber", userNumber);
		
		String[] proNum = req.getParameterValues("productNum");

		for(String num : proNum) {
			proInfo.put("productNumber", Integer.valueOf(num));
			cartDAO.delete(proInfo);
		}
	}

}
