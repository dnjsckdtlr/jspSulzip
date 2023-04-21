package com.sulzip.app.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sulzip.app.Execute;
import com.sulzip.app.product.dao.ProductDAO;
import com.sulzip.app.product.vo.AllProductVO;
import com.sulzip.app.user.dao.UserDAO;
import com.sulzip.app.user.dto.UserDTO;

public class OrderController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ProductDAO productDAO = new ProductDAO();
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();

		
		//로그인한 유저의 상세정보 가져오기
		userDTO = userDAO.getUserDetail((int)session.getAttribute("userNumber"));
		
		req.setAttribute("userInfo", userDTO);
		
		//장바구니 체크된 항목들의 정보 가져오기
		List<AllProductVO> checkList = new ArrayList<>();
		
		String[] check = req.getParameterValues("cart_check");
		String[] ea = req.getParameterValues("productEa");
		String[] price = req.getParameterValues("productPrice");
		
		for(String productNum : check) {
			int productNumber = Integer.valueOf(productNum);
			checkList.add(productDAO.allProduct(productNumber));
		}
		
		List<String> eaList = Arrays.stream(ea).collect(Collectors.toList()); 
		List<String> priceList = Arrays.stream(price).collect(Collectors.toList()); 
		
		req.setAttribute("checkList", checkList);
		req.setAttribute("eaList", eaList);
		req.setAttribute("priceList", priceList);
		
//		resp.sendRedirect("/app/order/orderpage.jsp");
		req.getRequestDispatcher("/app/order/orderpage.jsp").forward(req, resp);
	}
}
