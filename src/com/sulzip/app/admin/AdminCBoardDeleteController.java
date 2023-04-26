package com.sulzip.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.admin.dao.AdminDAO;
import com.sulzip.app.clientboard.dto.ClientBoardDTO;
import com.sulzip.app.file.dto.FileDTO;
import com.sulzip.app.myrecipe.dto.MyRecipeDTO;
import com.sulzip.app.pmbridge.dto.PmBridgeDTO;

public class AdminCBoardDeleteController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ㅎㅇ");
		AdminDAO adminDAO = new AdminDAO();
		ClientBoardDTO clientDTO = new ClientBoardDTO();

		
		int boardNumber = Integer.valueOf(req.getParameter("boardNumber"));
		
		
		clientDTO.setBoardNumber(boardNumber);
		
		adminDAO.clientDel(clientDTO);
		
	}

}
