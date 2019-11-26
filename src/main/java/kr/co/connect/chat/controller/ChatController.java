package kr.co.connect.chat.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.connect.chat.Chat;
import kr.co.connect.chat.dao.ichatDao;

@Controller
public class ChatController {
	
	@Autowired //자동으로 아래의 메소드들과 연결시켜줌
	 public SqlSession sqlSession;
	
	
	@RequestMapping(value="/test")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String Joinus(String err,Model model,HttpSession session)
	{
		session.setAttribute("groups", 1);
		model.addAttribute("err",err);
		return "chat/test"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping("/chatroom")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String chatroom(Model model,HttpServletResponse response, Chat chat, HttpSession session, HttpServletRequest request) 
	{
		session.setAttribute("groups", 1);
		String content=request.getParameter("content");
		String groups=session.getAttribute("groups").toString();
		String username=session.getAttribute("username").toString();
		model.addAttribute("list2",content);
		ichatDao dao=sqlSession.getMapper(ichatDao.class);
		System.out.println("ee");
		
		/*response.setCharacterEncoding("utf-8");
		out.print(URLEncoder.encode("홍길동"+username+":"+content )); // 한글이 깨져서!!!
        out.close();	*/
        String id=request.getParameter("userid");
		ArrayList<Chat> list=dao.chatlist(groups);
		model.addAttribute("list",list);
		model.addAttribute("user",username);
		model.addAttribute("groups",groups);
		return "chat/chatroom"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping("/writechat")
	public void writechat(HttpServletRequest request,Model model, PrintWriter out, HttpSession session)
	{
		session.setAttribute("groups", 1);
	String groups=session.getAttribute("groups").toString();
		String content=request.getParameter("content");
		String username=request.getParameter("username");
		ichatDao dao=sqlSession.getMapper(ichatDao.class);
		dao.writechatstr(username,content,groups); //DB 작성하기
		dao.chatlist(groups); // DB저장후 20개 읽어오기
		out.print("#");
	}
	
	
	@RequestMapping("/chatlist")
	public void chatlist( HttpSession session)
	{
		session.setAttribute("groups", 1);
		String groups=session.getAttribute("groups").toString();
		ichatDao dao=sqlSession.getMapper(ichatDao.class);
		dao.getchatlist(groups);
	}
	
	
	/*
	 * @RequestMapping("/writechat")//브라우저에 입력된 주소(사용자가 입력하는 주소) public String
	 * writechat(Chat chat, HttpSession session) { //username을 세션으로 받아올것 String
	 * username=session.getAttribute("username").toString(); String
	 * groups=session.getAttribute("groups").toString(); ichatDao
	 * dao=sqlSession.getMapper(ichatDao.class);
	 * dao.writechat(username,chat.getContent(),groups); System.out.println("##");
	 * return "redirect:/chatroom"; //실제 주소(실제로 입력이 되는 주소) }
	 */
	
}
