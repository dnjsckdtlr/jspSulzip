package com.sulzip.app.clientboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;
import com.sulzip.app.clientboard.dao.ClientBoardDAO;
import com.sulzip.app.clientboard.dto.ClientBoardDTO;

public class ServiceReadOkController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   int boardNumber = Integer.valueOf(req.getParameter("boardNumber"));
		   	  ClientBoardDTO clientBoardDTO = new ClientBoardDTO();
		      ClientBoardDAO clientBoardDAO = new ClientBoardDAO();
		      clientBoardDTO.setBoardNumber(boardNumber);
		      ClientBoardDTO boardRow = clientBoardDAO.selectDetail(clientBoardDTO);
		      
		      req.setAttribute("boardRow", boardRow);
		      
		      req.setAttribute("num", boardNumber);
		      
		      req.getRequestDispatcher("/app/clientboard/servicepage.jsp").forward(req, resp);
	}
}
