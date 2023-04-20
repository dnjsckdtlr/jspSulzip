package com.sulzip.app.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sulzip.app.Execute;
import com.sulzip.app.cart.dao.CartDAO;
import com.sulzip.app.cart.vo.CartVO;
import com.sulzip.app.user.dao.UserDAO;
import com.sulzip.app.user.dto.UserDTO;

public class CartListOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartDAO cartDAO = new CartDAO();
		UserDAO userDAO = new UserDAO();
		HttpSession session = req.getSession();
		
		int userNumber = (Integer)session.getAttribute("userNumber");
		
		UserDTO userDTO = userDAO.getUserDetail(userNumber);
		List<CartVO> cartList = cartDAO.select1(userNumber);
		cartList.addAll(cartDAO.select2(userNumber));
		
		req.setAttribute("userInfo", userDTO);
		req.setAttribute("cartList", cartList);
		req.getRequestDispatcher("/app/cart/cart.jsp").forward(req, resp);
	}

}
