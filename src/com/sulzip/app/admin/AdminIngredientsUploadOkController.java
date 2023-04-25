package com.sulzip.app.admin;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sulzip.app.Execute;
import com.sulzip.app.admin.dao.AdminDAO;
import com.sulzip.app.product.dto.ProductDTO;

public class AdminIngredientsUploadOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		ProductDTO productDTO = new ProductDTO();
		
		HttpSession session = req.getSession();

		String uploadPath = req.getSession().getServletContext().getRealPath("/") + "assets/img/ingredients/";
		int fileSize = 1024 * 1024 * 5; // 5mb
		MultipartRequest multipartReq = new MultipartRequest(req, uploadPath, fileSize, "utf-8",
				new DefaultFileRenamePolicy());
		String categoryNum = multipartReq.getParameter("category");
//글등록 1개
		
		productDTO.setProductNameKor(multipartReq.getParameter("productNameKor"));
		productDTO.setProductNameEng(multipartReq.getParameter("productNameEng"));
		productDTO.setProductPrice(Integer.valueOf(multipartReq.getParameter("productPrice")) );
		productDTO.setCategoryNumber(multipartReq.getParameter("category"));
		
		
		System.out.println(categoryNum);
		
		
		
		
		Enumeration<String> fileNames = multipartReq.getFileNames();

		while (fileNames.hasMoreElements()) {

			String name = fileNames.nextElement();
			
			System.out.println(name);

			String productFile = multipartReq.getFilesystemName(name);
			System.out.println("**************"+ productFile);
			if (productFile == null) {
				System.out.println("null");
				continue;
				
			}
			productDTO.setProductSystemName(productFile);
		}
		
		adminDAO.productUpload(productDTO);

//		int productNumber = adminDAO.getSequence();
		

		
//		업로드 후 작성된 글로 이동
		
		resp.sendRedirect("/product/ingredients.prd");
		
	}

}
