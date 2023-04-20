package com.sulzip.app.myrecipe;

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
import com.sulzip.app.file.dto.FileDTO;
import com.sulzip.app.myrecipe.dao.MyRecipeDAO;
import com.sulzip.app.myrecipe.dto.MyRecipeDTO;
import com.sulzip.app.pmbridge.dto.PmBridgeDTO;

public class MyRecipeUploadOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		myrecipe 글내용 업로드, 파일업로드, pmbridge업로드
		MyRecipeDAO myRecipeDAO = new MyRecipeDAO();
		MyRecipeDTO myRecipeDTO = new MyRecipeDTO();
		PmBridgeDTO pmBridgeDTO = new PmBridgeDTO();
		FileDTO fileDTO = new FileDTO();
		HttpSession session = req.getSession();

		String uploadPath = req.getSession().getServletContext().getRealPath("/") + "assets/img/myrecipe/";
		int fileSize = 1024 * 1024 * 5; // 5mb
		MultipartRequest multipartReq = new MultipartRequest(req, uploadPath, fileSize, "utf-8",
				new DefaultFileRenamePolicy());

//글등록 1개
		myRecipeDTO.setMyRecipeNameKor(multipartReq.getParameter("myRecipeNameKor"));
		myRecipeDTO.setMyRecipeNameEng(multipartReq.getParameter("myRecipeNameEng"));
		myRecipeDTO.setMyRecipeDesc(multipartReq.getParameter("myRecipeDesc"));
		myRecipeDTO.setMyRecipeRecipe(multipartReq.getParameter("myRecipeRecipe"));
		myRecipeDTO.setUserNumber((Integer)session.getAttribute("userNumber"));
		myRecipeDAO.insert(myRecipeDTO);

//파일업로드 for문
		int myRecipeNumber = myRecipeDAO.getSequence();

		// System.out.println("num : " + myRecipeNumber);

		Enumeration<String> fileNames = multipartReq.getFileNames();

		while (fileNames.hasMoreElements()) {

			String name = fileNames.nextElement();

			// System.out.println("name : " + name);

			String fileSystemName = multipartReq.getFilesystemName(name);
			String fileOriginalName = multipartReq.getOriginalFileName(name);

			if(name.equals("myRecipeFile1")) {
				
				Map<String, String> thumbInfo = new HashMap<String, String>();
				
				thumbInfo.put("fileSystemName", fileSystemName);
				thumbInfo.put("myRecipeNumber", Integer.toString(myRecipeNumber));
				
				myRecipeDAO.upThumb(thumbInfo);
			}

			// System.out.println("fileSystemName : " + fileSystemName);
			if (fileSystemName == null) {
				continue;
			}

			fileDTO.setFileSystemName(fileSystemName);
			fileDTO.setFileOriginalName(fileOriginalName);
			fileDTO.setMyRecipeNumber(myRecipeNumber);

			myRecipeDAO.uploadFile(fileDTO);
		}

//pmBridge업로드 for문

		List<String> productList = Arrays.stream(multipartReq.getParameterValues("category1"))
				.filter(cate -> !cate.equals("")).collect(Collectors.toList());
		// System.out.println(productList);

		List<String> volList = Arrays.stream(multipartReq.getParameterValues("pmBridgeVol"))
				.filter(vol -> !vol.equals("")).collect(Collectors.toList());
		// System.out.println(volList);

		for (int i = 0; i < productList.size(); i++) {
			pmBridgeDTO.setProductNumber(Integer.parseInt(productList.get(i)));
			pmBridgeDTO.setPmBridgeVol(volList.get(i));
			pmBridgeDTO.setMyRecipeNumber(myRecipeNumber);
			myRecipeDAO.insertPmBridge(pmBridgeDTO);
		}
		resp.sendRedirect("/myrecipe/myRecipeUpload.mrb");
		//추후 '작성된 글로 넘어가게' 처리
	}

}
