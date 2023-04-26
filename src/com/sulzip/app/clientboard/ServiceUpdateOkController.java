package com.sulzip.app.clientboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.clientboard.dao.ClientBoardDAO;
import com.sulzip.app.clientboard.dto.ClientBoardDTO;

public class ServiceUpdateOkController implements Execute {
@Override
public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ClientBoardDAO clientBoardDAO = new ClientBoardDAO();
	ClientBoardDTO clientBoardDTO = new ClientBoardDTO();
	req.setCharacterEncoding("utf-8");
	int boardNumber = Integer.valueOf(req.getParameter("boardNumber"));
	String boardTitle = req.getParameter("boardTitle");
	String boardContent = req.getParameter("boardContent");
	
	clientBoardDTO.setBoardNumber(boardNumber);
	clientBoardDTO.setBoardTitle(boardTitle);
	clientBoardDTO.setBoardContent(boardContent);
	
	clientBoardDAO.modify(clientBoardDTO);
	System.out.println("ok컨트롤러 확인");
	System.out.println(req.getParameter("boardTitle"));
	
	resp.sendRedirect("/clientboard/serviceListOk.clb");
	
	
	}
}
