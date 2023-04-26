package com.sulzip.app.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.product.dao.ProductDAO;
import com.sulzip.app.product.dto.ProductDTO;
import com.sulzip.app.sulkit.dto.SulkitDTO;

public class AlcoholDetailController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		
		int num = Integer.parseInt(req.getParameter("num"));
		ProductDTO productDTO = productDAO.alcohol(num);
		
		req.setAttribute("alcohol", productDTO);
		req.getRequestDispatcher("/app/product/alcoholdetail.jsp").forward(req, resp);
	}
}
