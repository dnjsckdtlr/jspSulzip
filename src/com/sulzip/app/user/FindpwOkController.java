package com.sulzip.app.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sulzip.app.Execute;
import com.sulzip.app.user.dao.UserDAO;
import com.sulzip.app.user.dto.UserDTO;

public class FindpwOkController implements Execute {
   @Override
      public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
	  UserDTO userDTO = new UserDTO();
      UserDAO userDAO = new UserDAO();
      
      Gson gson = new Gson();
      PrintWriter out = resp.getWriter();
      String replyJson;
      
      userDTO.setUserName(req.getParameter("userName"));
      userDTO.setUserPhone(req.getParameter("userPhone"));
      userDTO.setUserId(req.getParameter("userId"));
      
      String userPw = userDAO.selectPw(userDTO);
      
      replyJson = gson.toJson(userPw);
      out.print(replyJson.toString());
      out.close();
         
      }
      
   }



