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
import kr.co.connect.egroup.Egroup;
import kr.co.connect.egroup.dao.iegroupDao;
import kr.co.connect.invite.dao.iinviteDao;

@Controller
public class ChatController {
	
	
	
	@Autowired //자동으로 아래의 메소드들과 연결시켜줌
	 public SqlSession sqlSession;
	

	@RequestMapping(value="/nogroups")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String nogroups(Model model,HttpSession session)
	{
		System.out.println("nogroup");
		  inc(session,model);
		return "chat/nogroups"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	
	@RequestMapping(value="/test")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String Joinus(String err,Model model,HttpSession session)
	{
		session.setAttribute("groups", 1);
		model.addAttribute("err",err);
		  inc(session,model);
		return "chat/test"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping("/chatroom")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String chatroom(Model model,HttpServletResponse response, Chat chat, HttpSession session, HttpServletRequest request) 
	{   
		
		
		String user22=session.getAttribute("userid").toString();
		String groupid2=request.getParameter("gid");
		  iinviteDao dao2 = sqlSession.getMapper(iinviteDao.class);
	        String manager=dao2.whoismanager(groupid2);
	        model.addAttribute("user22", user22);
			model.addAttribute("manager", manager);
			
		
		String email=session.getAttribute("userid").toString();
		iegroupDao dao1=sqlSession.getMapper(iegroupDao.class);
		ArrayList<Egroup> glist=dao1.grouplist(email);
		model.addAttribute("glist", glist);
		ArrayList<Egroup> checkifhavegroup;
		checkifhavegroup = dao1.groupliststring(session.getAttribute("userid").toString());

		String groups="";
		String content=request.getParameter("content");
		if(checkifhavegroup==null)
		{
			return "egroup/joingroup"; //실제 주소(실제로 입력이 되는 주소)
		}
		
		
		String username=session.getAttribute("username").toString();
		model.addAttribute("list2",content);
		ichatDao dao=sqlSession.getMapper(ichatDao.class);
		System.out.println("username:: "+username);
		
		

		
		/*response.setCharacterEncoding("utf-8");
		out.print(URLEncoder.encode("홍길동"+username+":"+content )); // 한글이 깨져서!!!
        out.close();	*/
        String id=request.getParameter("userid");
		ArrayList<Chat> list=dao.chatlist(groups);
		model.addAttribute("list",list);
		model.addAttribute("user",username);
		model.addAttribute("groups",groups);
		model.addAttribute("gid", request.getParameter("gid"));
		model.addAttribute("gname", request.getParameter("gname"));
		  inc(session,model);
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
		dao.writechat(username,content,groups); //DB 작성하기
		dao.chatlist(groups); // DB저장후 20개 읽어오기
		out.print("#");
		  inc(session,model);
	}
	
	
	@RequestMapping("/chatlist")
	public void chatlist( HttpSession session,Model model)
	{
		session.setAttribute("groups", 1);
		String groups=session.getAttribute("groups").toString();
		ichatDao dao=sqlSession.getMapper(ichatDao.class);
		dao.getchatlist(groups);
		  inc(session,model);
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
	
	  public void inc(HttpSession session, Model model)
			{
			  if (session.getAttribute("userid") == null)
			  {
			  String messege="로그인 해주세요"; 
			  model.addAttribute("messege", messege); 
			  } else
			  {
			  String email=session.getAttribute("userid").toString();
			  String user=session.getAttribute("username").toString();
			  System.out.println("user"+user);
			  String welcome="님 환영합니다!";
			  iinviteDao dao = sqlSession.getMapper(iinviteDao.class);
			  String invitenum=dao.invitednum(email); String messege="그룹초대";
			  model.addAttribute("invitenum", invitenum);
			  model.addAttribute("welcome", welcome);
			  model.addAttribute("messege",messege); 
			  }
			}
}
