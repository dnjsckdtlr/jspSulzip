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
		HttpSession session = req.getSession();

		String uploadPath = req.getSession().getServletContext().getRealPath("/") + "assets/img/sulkit/";
		int fileSize = 1024 * 1024 * 5; // 5mb
		MultipartRequest multipartReq = new MultipartRequest(req, uploadPath, fileSize, "utf-8",
				new DefaultFileRenamePolicy());
		System.out.println("1");
//글등록 1개
		
		sulkitDTO.setSulkitNameKor(multipartReq.getParameter("sulkitNameKor"));
		sulkitDTO.setSulkitNameEng(multipartReq.getParameter("sulkitNameEng"));
		sulkitDTO.setSulkitDesc(multipartReq.getParameter("sulkitDesc"));
		sulkitDTO.setSulkitPrice(Integer.valueOf(multipartReq.getParameter("sulkitprice")) );
		sulkitDTO.setSulkitRecipe(multipartReq.getParameter("sulkitRecipe"));
		System.out.println("2");
		
		
		
		Enumeration<String> fileNames = multipartReq.getFileNames();

		while (fileNames.hasMoreElements()) {

			String name = fileNames.nextElement();
			
			System.out.println(name);

			String sulkitFile = multipartReq.getFilesystemName(name);
			System.out.println("**************"+ sulkitFile);
			if (sulkitFile == null) {
				System.out.println("null");
				continue;
				
			}
			System.out.println("3");
			sulkitDTO.setSulkitImg(sulkitFile);
			
		}
		
		adminDAO.insert(sulkitDTO);

		int sulkitNumber = adminDAO.getSequence();
		
		List<String> productList = Arrays.stream(multipartReq.getParameterValues("category1"))
		.filter(cate -> !cate.equals("")).collect(Collectors.toList());
		// System.out.println(productList);

		List<String> volList = Arrays.stream(multipartReq.getParameterValues("psBridgeVol"))
		.filter(vol -> !vol.equals("")).collect(Collectors.toList());
		// System.out.println(volList);

		for (int i = 0; i < productList.size(); i++) {
			psBridgeDTO.setProductNumber(Integer.parseInt(productList.get(i)));
			psBridgeDTO.setPsBridgeVol(volList.get(i));
			System.out.println("4");
			psBridgeDTO.setSulkitNumber(sulkitNumber);
			adminDAO.insertPs(psBridgeDTO);
			System.out.println("5");
		}
		
//		업로드 후 작성된 글로 이동
		resp.sendRedirect("/sulkit/sulkit.suk");

	}

}













