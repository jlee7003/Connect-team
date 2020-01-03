package kr.co.connect.uploadcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class uploadcontroller extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 MultipartRequest mr = new MultipartRequest
				 
		(req, "D:", 1024*1024*10, "EUC-KR", new DefaultFileRenamePolicy());
  // (요청객체, 파일이 쓰여질 경로, 파일의 최대크기, 인코딩방식, 파일명이 이미 있을 경우 '파일명+1')
		
		 java.io.File image = mr.getFile("albumimage"); // image에 파일의 이름을 담음
		 java.io.File music = mr.getFile("musicfile");
		 
		 System.out.println(image);
		 System.out.println(music);

	}
}