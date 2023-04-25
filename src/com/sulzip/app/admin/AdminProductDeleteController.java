package com.sulzip.app.admin;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.admin.dao.AdminDAO;
import com.sulzip.app.product.dto.ProductDTO;
import com.sulzip.app.psbridge.dto.PsBridgeDTO;
import com.sulzip.app.sulkit.dto.SulkitDTO;

public class AdminProductDeleteController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		ProductDTO productDTO = new ProductDTO();
		SulkitDTO sulkitDTO = new SulkitDTO();
		PsBridgeDTO psBridgeDTO = new PsBridgeDTO();
		
		String[] productList = req.getParameterValues("productNumber");
		
		System.out.println(Arrays.toString(productList));
		
		for(String product : productList) {
			int productNumber = Integer.valueOf(product);
			
			if(Integer.valueOf(productNumber) <= 100) {
				psBridgeDTO.setSulkitNumber(productNumber);
				sulkitDTO.setSulkitNumber(productNumber);
				
				adminDAO.psBridgeDelete(psBridgeDTO);
				adminDAO.sulkitDelete(sulkitDTO);
			}else{
				productDTO.setProductNumber(productNumber);
				
				adminDAO.productDelete(productDTO);
			}
			
		}
		
	}

}
