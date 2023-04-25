package com.sulzip.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.admin.dao.AdminDAO;
import com.sulzip.app.myrecipe.dao.MyRecipeDAO;
import com.sulzip.app.product.dto.ProductDTO;

public class AdminSulkitUploadController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		
		List<ProductDTO> alcoholList = adminDAO.category(2); 
		List<ProductDTO> ingreList = adminDAO.category(3); 
		
		
		req.setAttribute("alcoholList", alcoholList);
		req.setAttribute("ingreList", ingreList);
		
		req.getRequestDispatcher("/app/admin/sulkitupload.jsp").forward(req, resp);
	
	}

}
