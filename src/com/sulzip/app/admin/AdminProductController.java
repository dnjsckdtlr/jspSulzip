package com.sulzip.app.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.admin.dao.AdminDAO;
import com.sulzip.app.product.dto.ProductDTO;
import com.sulzip.app.product.vo.ProductVO;
import com.sulzip.app.sulkit.dto.SulkitDTO;

public class AdminProductController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDTO productDTO = new ProductDTO();
		SulkitDTO sulkitDTO = new SulkitDTO();
		AdminDAO adminDAO = new AdminDAO();
		ProductVO productVO = new ProductVO();
		
//		카테고리별 상품 개수
		int total = adminDAO.sulkit();
		int aTotal = adminDAO.product(2);
		int iTotal = adminDAO.product(3);
		int sTotal = adminDAO.product(4);
		int dataTotal = total + aTotal + iTotal + sTotal;
		
		req.setAttribute("sulkit", total);
		req.setAttribute("atotal", aTotal);
		req.setAttribute("itotal", iTotal);
		req.setAttribute("stotal", sTotal);
		req.setAttribute("dataTotal", dataTotal);
		
//		전체 상품 목록
		
		List<ProductVO> sulkitList = adminDAO.sulkitList();
		List<ProductVO> productList = adminDAO.productList();
		
		
		
//		System.out.println(sulkitList);
//		System.out.println(productList);
		
		req.setAttribute("sulkitList", sulkitList);
		req.setAttribute("productList", productList);
		req.setAttribute("sulkit2", sulkitDTO);
		
		
		List<ProductVO> joined = new ArrayList<ProductVO>();
		joined.addAll(sulkitList);
		joined.addAll(productList);
		
		req.setAttribute("joined", joined);
		
		req.getRequestDispatcher("/app/admin/adminproduct.jsp").forward(req, resp);
	}

}







