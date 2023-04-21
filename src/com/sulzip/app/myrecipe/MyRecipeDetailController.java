package com.sulzip.app.myrecipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sulzip.app.Execute;
import com.sulzip.app.file.dao.FileDAO;
import com.sulzip.app.file.dto.FileDTO;
import com.sulzip.app.myrecipe.dao.MyRecipeDAO;
import com.sulzip.app.myrecipe.dto.MyRecipeDTO;
import com.sulzip.app.myrecipe.vo.MyRecipeVO;
import com.sulzip.app.user.dao.UserDAO;

public class MyRecipeDetailController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FileDAO fileDAO = new FileDAO();
		MyRecipeDAO myRecipeDAO = new MyRecipeDAO();
		HttpSession session = req.getSession();
		Integer userNumber = (Integer) session.getAttribute("userNumber");
		String path = null;
		
		int mrbNum = Integer.parseInt(req.getParameter("num"));

		MyRecipeDTO myRecipeDTO = myRecipeDAO.select(mrbNum);
		List<MyRecipeVO> ingreList = myRecipeDAO.ingre(mrbNum);
		List<FileDTO> fileList = fileDAO.select(mrbNum);
		
		req.setAttribute("myRecipe", myRecipeDTO);
		req.setAttribute("ingreList", ingreList);
		req.setAttribute("fileList", fileList);
		
		if (userNumber == null) {
			path = "/app/user/login.jsp";
		} else {
			path = "/app/myrecipe/myrecipedetail.jsp";
		}
		
		req.getRequestDispatcher(path).forward(req, resp);

	}

}
