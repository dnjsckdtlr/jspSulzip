package com.sulzip.app.sulkit;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.sulkit.dao.SulkitDAO;
import com.sulzip.app.sulkit.dto.SulkitDTO;
import com.sulzip.app.sulkit.vo.SulkitVO;

public class SulkitBoardController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SulkitDAO sulkitDAO = new SulkitDAO();
		
		int num = Integer.parseInt(req.getParameter("num"));
		
		SulkitDTO sulkitDTO = sulkitDAO.selectSulkit(num);
		
		List<SulkitVO> ingreList = sulkitDAO.recipe(num); 
		
		req.setAttribute("ingreList", ingreList);
		
		req.setAttribute("sulkit", sulkitDTO);
		req.getRequestDispatcher("/app/sulkit/sulkitdetail.jsp").forward(req, resp);
	}

}
















