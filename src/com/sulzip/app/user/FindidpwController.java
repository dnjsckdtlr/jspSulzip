package com.sulzip.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sulzip.app.Execute;

public class FindidpwController implements Execute {
   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      req.getRequestDispatcher("/app/user/findidpw.jsp").forward(req, resp);
      
      
   }

}