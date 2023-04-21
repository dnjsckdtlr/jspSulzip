package com.sulzip.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.sulzip.app.Execute;
import com.sulzip.app.admin.dao.AdminDAO;
import com.sulzip.app.file.dto.FileDTO;
import com.sulzip.app.myrecipe.dto.MyRecipeDTO;
import com.sulzip.app.pmbridge.dto.PmBridgeDTO;

public class AdminBoardDeleteController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("안녕");
		AdminDAO adminDAO = new AdminDAO();
		MyRecipeDTO myRecipeDTO = new MyRecipeDTO();
		FileDTO fileDTO = new FileDTO();
		PmBridgeDTO pmBridgeDTO = new PmBridgeDTO();

		
		int myRecipeNumber = Integer.valueOf(req.getParameter("myRecipeNumber"));
		
		fileDTO.setMyRecipeNumber(myRecipeNumber);
		pmBridgeDTO.setMyRecipeNumber(myRecipeNumber);
		myRecipeDTO.setMyRecipeNumber(myRecipeNumber);
		
		
		System.out.println(myRecipeNumber);
		
		adminDAO.fileDel(fileDTO);
		System.out.println("dd");
		adminDAO.pmBridgeDel(pmBridgeDTO);
		System.out.println("cc");
		adminDAO.myRecipeDel(myRecipeDTO);
		
		System.out.println("aa");
		
		
	}

}
