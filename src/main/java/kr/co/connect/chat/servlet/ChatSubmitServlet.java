package kr.co.connect.chat.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.connect.chat.dao.chatDaojsp;

public class ChatSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("제발");
		response.setContentType("text/html);charset=UTF-8");
		String username= URLDecoder.decode(request.getParameter("username"),"UTF-8");
		String content = URLDecoder.decode(request.getParameter("content"),"UTF-8");
//		String groups="1";
		String groups=session.getAttribute("groups").toString();
		if(username == null || username.equals("")|| content == null || content.equals("")) {
			response.getWriter().write("0");
			System.out.println("제발1");
		}
		else {
			response.getWriter().write(new chatDaojsp().submit(username,content,groups)+ "");
			System.out.println("제발2");
			System.out.println(username);
			System.out.println(content);
			System.out.println(groups);
		}
	}
	

}
