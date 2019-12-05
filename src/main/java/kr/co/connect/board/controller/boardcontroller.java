package kr.co.connect.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.connect.board.Board;
import kr.co.connect.board.dao.iboardDao;
import kr.co.connect.egroup.Egroup;
import kr.co.connect.egroup.dao.iegroupDao;

@Controller
public class boardcontroller {

	@Autowired //자동으로 아래의 메소드들과 연결시켜줌
	 public SqlSession sqlSession;
	@RequestMapping("/write_ok")
	public String write_ok(Board board, HttpServletRequest request,HttpSession session)
	{
		
		int groupid=Integer.parseInt(request.getParameter("groupid"));
        String username=session.getAttribute("username").toString();
        String writeremail=session.getAttribute("userid").toString();
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
		dao.write(username,board.getTitle(),writeremail,board.getContent(),groupid);
		//write의 역할을 dao에 적어놓지 않았는데 그 역할을 xml에 적는다
		return "redirect:/list?gid="+groupid;
	}
	@RequestMapping(value="/list")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String list(Model model,HttpSession session,HttpServletRequest request)
	{
		String groupid=request.getParameter("gid");
		String groupname=request.getParameter("gname");
		model.addAttribute("gid", groupid);
		model.addAttribute("gname", groupname);
		String email=session.getAttribute("userid").toString();
		iegroupDao dao12=sqlSession.getMapper(iegroupDao.class);
		ArrayList<Egroup> glist=dao12.grouplist(email);
		model.addAttribute("glist", glist);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
			ArrayList<Board> list=dao.list(groupid);
		   model.addAttribute("list",list);
		
		return "board/list"; //실제 주소(실제로 입력이 되는 주소)
	}
	@RequestMapping(value="/content")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String content(HttpServletRequest request,Model model,HttpSession session)
	{
		String id=request.getParameter("id");
		String groupid=request.getParameter("gid");
		model.addAttribute("gid", groupid);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
		model.addAttribute("dto",dao.content(id,groupid));
		return "board/content"; //실제 주소(실제로 입력이 되는 주소)
	}
	@RequestMapping(value="/update")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String update(HttpServletRequest request,Model model,HttpSession session)
	{

		String id=request.getParameter("id");
		String groupid=request.getParameter("gid");
		model.addAttribute("gid", groupid);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
		model.addAttribute("dto",dao.update(id,groupid));
		
		return "board/update"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(Model model, Board board, HttpServletRequest request)
	{ 

		String id=request.getParameter("id");
		String groupid=request.getParameter("gid");
		model.addAttribute("gid", groupid);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
	   dao.updateok(board.getTitle(), board.getContent(), id, groupid); 
		return "redirect:/content?id="+board.getId()+"&gid="+groupid;
	}
	
	
	@RequestMapping(value="/write")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String write(Model model,HttpSession session,HttpServletRequest request)
	{
		String username=session.getAttribute("username").toString();
		String groupid=request.getParameter("gid");
		String groupname=request.getParameter("gname");
		model.addAttribute("gid", groupid);
		model.addAttribute("gname", groupname);
		model.addAttribute("username", username);
		return "board/write"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,HttpSession session, Model model)
	{
		String id=request.getParameter("id");
	String groupid=request.getParameter("gid");
	model.addAttribute("gid", groupid);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
		   dao.delete(id,groupid); 
		   return "redirect:list";
	}
	
	
	
	  public void inc(HttpServletRequest request, HttpSession session, Model model)
		{
			String id=request.getParameter("id");
			String groupid=request.getParameter("gid");
			model.addAttribute("gid", groupid);
		}
	 
}
