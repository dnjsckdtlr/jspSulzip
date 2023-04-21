package com.sulzip.app.admin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sulzip.app.Execute;
import com.sulzip.app.admin.dao.AdminDAO;
import com.sulzip.app.file.dto.FileDTO;
import com.sulzip.app.psbridge.dto.PsBridgeDTO;
import com.sulzip.app.sulkit.dto.SulkitDTO;

public class AdminSulkitUploadOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		글내용 업로드, 파일업로드, psbridge업로드
		AdminDAO adminDAO = new AdminDAO();
		SulkitDTO sulkitDTO = new SulkitDTO();
		PsBridgeDTO psBridgeDTO = new PsBridgeDTO();
		FileDTO fileDTO = new FileDTO();
		HttpSession session = req.getSession();

		String uploadPath = req.getSession().getServletContext().getRealPath("/") + "assets/img/myrecipe/";
		int fileSize = 1024 * 1024 * 5; // 5mb
		MultipartRequest multipartReq = new MultipartRequest(req, uploadPath, fileSize, "utf-8",
				new DefaultFileRenamePolicy());

//글등록 1개
		
		sulkitDTO.setSulkitNameKor(multipartReq.getParameter("sulkitNameKor"));
		sulkitDTO.setSulkitNameEng(multipartReq.getParameter("sulkitNameEng"));
		sulkitDTO.setSulkitDesc(multipartReq.getParameter("sulkitDesc"));
		sulkitDTO.setSulkitPrice((Integer)session.getAttribute("sulkitPrice"));
		sulkitDTO.setSulkitRecipe(multipartReq.getParameter("sulkitRecipe"));
		adminDAO.insert(sulkitDTO);
		



	}

}
