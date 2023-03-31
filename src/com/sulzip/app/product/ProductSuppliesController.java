package com.sulzip.app.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.product.dao.ProductDAO;
import com.sulzip.app.product.dto.ProductDTO;
import com.sulzip.app.sulkit.dto.SulkitDTO;

public class ProductSuppliesController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ProductDTO productDTO = new ProductDTO();
		ProductDAO productDAO = new ProductDAO();
		
		int num = Integer.parseInt(req.getParameter("num"));
		
		ProductDTO productDTO = productDAO.alcohol(num);
		
		System.out.println(productDTO);
		
		req.setAttribute("supplies", productDTO);
		req.getRequestDispatcher("/app/product/suppliesdetail.jsp").forward(req, resp);
		
	}
}
