package com.sulzip.app.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.product.dao.ProductDAO;
import com.sulzip.app.product.dto.ProductDTO;

public class SuppliesListOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		
		String temp = req.getParameter("page");
		
		int page = temp == null? 1 : Integer.valueOf(temp);
		
		//한 페이지에 게시글 12개
		int rowCount = 12;
		
		//페이지 버튼 5개
		int pageCount = 5;
		
		int startRow = rowCount * (page-1);
		
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("startRow", startRow);
		pageMap.put("rowCount", rowCount);
		
		int total = productDAO.getTotal(2);
		
		//페이지번호 한세트의 마지막 페이지번호, Math.ceil()은 올림처리.
		int endPage = (int)(Math.ceil(page/(double)pageCount) * pageCount);
		
		//페이지번호 세트의 첫번째 번호
		int startPage = endPage - (pageCount-1);
		
		//페이지번호 제일 마지막세트의 첫번째 번호.
		int realEndPage = (int)Math.ceil(total / (double)rowCount);
		
		//페이지번호 양옆에 있는 이전과 다음 화살표 표시 여부
		boolean prev = startPage > 1;
		
		//실제로 7번에서 끝나면, 1~5, 6~10이 아닌 6~7로 끝나는 처리.
		endPage = endPage > realEndPage ? realEndPage : endPage;
		
		boolean next = endPage != realEndPage;
		
		List<ProductDTO> supList = productDAO.supBoard(pageMap);
		
		req.setAttribute("supList", supList);
		req.setAttribute("page", page);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("prev", prev);
		req.setAttribute("next", next);
		
		req.getRequestDispatcher("/app/product/supplies.jsp").forward(req, resp);
		
	}

}
