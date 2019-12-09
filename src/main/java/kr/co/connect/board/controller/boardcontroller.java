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
		int boardid=Integer.parseInt(request.getParameter("boardid"));
        String username=session.getAttribute("username").toString();
        String writeremail=session.getAttribute("userid").toString();
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
		System.out.println("boardid :"+boardid );
		dao.write(username,board.getTitle(),writeremail,board.getContent(),groupid,boardid);
		//write의 역할을 dao에 적어놓지 않았는데 그 역할을 xml에 적는다
		return "redirect:/list?gid="+groupid+"&boardid="+boardid+"&page=1";
	}
	
	@RequestMapping("/listseeok")
	public String listseeok(Board board, HttpServletRequest request,HttpSession session)
	{
		int listsee=Integer.parseInt(request.getParameter("listsee"));
		session.setAttribute("listsee", listsee);
		int groupid=Integer.parseInt(request.getParameter("gid"));
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		//write의 역할을 dao에 적어놓지 않았는데 그 역할을 xml에 적는다
		return "redirect:/list?gid="+groupid+"&boardid="+boardid+"&page=1";
	}
	@RequestMapping(value="/list")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String list(Model model,HttpSession session,HttpServletRequest request)
	{
		int listsee=10;
		if(	session.getAttribute("listsee")!=null)
		{
		 listsee=Integer.parseInt(session.getAttribute("listsee").toString());;
		 System.out.println("listsee :"+listsee);
		}
		else
		{
			listsee=10;
		}
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		if(boardid == 0)
		{
			return "board/selectboardplz";
		}
		int start;
		int page=1;
	
		start=0;
		 page=Integer.parseInt(request.getParameter("page"));
			if(page != 1)
			{
				start = (page - 1) * listsee;
			}
		String groupid=request.getParameter("gid");
		String groupname=request.getParameter("gname");
		model.addAttribute("gid", groupid);
		model.addAttribute("gname", groupname);
		String email=session.getAttribute("userid").toString();
		iegroupDao dao12=sqlSession.getMapper(iegroupDao.class);
		ArrayList<Egroup> glist=dao12.grouplist(email);
		model.addAttribute("glist", glist);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
		int cntnumber=dao.cntnumber();
		int pagenumber=cntnumber/listsee;
		if (cntnumber % 10 != 0)
		{
			pagenumber=pagenumber+1;
		}
		System.out.println(pagenumber);
		System.out.println(cntnumber);
		int pstart;
		int pend;
		 pstart = (int) page / 10;
		if (page % 10 == 0) {
			pstart = pstart - 1;
		}
		pstart = Integer.parseInt(pstart + "1");
		pend = pstart + 9;
		if (pend > pagenumber)
		{
			pend = pagenumber;
		}
		if(listsee == 10)
		{
			ArrayList<Board> list=dao.list10(groupid,boardid,start);
			 model.addAttribute("list",list);
		}
		else if(listsee == 15)
		{
			ArrayList<Board> list=dao.list15(groupid,boardid,start);
			 model.addAttribute("list",list);
		}
		else if(listsee == 20)
		{
			ArrayList<Board> list=dao.list20(groupid,boardid,start);
			 model.addAttribute("list",list);
		}
		else {
			ArrayList<Board> list=dao.list25(groupid,boardid,start);
			 model.addAttribute("list",list);
		}
		  
		   model.addAttribute("bid",boardid);
		   model.addAttribute("start",start);
		   model.addAttribute("pstart",pstart);
		   model.addAttribute("pend",pend);
		   model.addAttribute("page",page);
		   model.addAttribute("cntnumber",cntnumber);
		   model.addAttribute("pagenumber",pagenumber);
		
		return "board/list"; //실제 주소(실제로 입력이 되는 주소)
	}
	@RequestMapping(value="/content")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String content(HttpServletRequest request,Model model,HttpSession session)
	{
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		model.addAttribute("bid", boardid);
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

		int boardid=Integer.parseInt(request.getParameter("boardid"));
		model.addAttribute("bid", boardid);
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
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		String id=request.getParameter("id");
		String groupid=request.getParameter("gid");
		model.addAttribute("gid", groupid);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
	   dao.updateok(board.getTitle(), board.getContent(), id, groupid); 
		return "redirect:/content?id="+board.getId()+"&gid="+groupid+"&boardid="+boardid;
	}
	
	
	@RequestMapping(value="/write")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String write(Model model,HttpSession session,HttpServletRequest request)
	{
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		String username=session.getAttribute("username").toString();
		String groupid=request.getParameter("gid");
		String groupname=request.getParameter("gname");
		model.addAttribute("gid", groupid);
		model.addAttribute("gname", groupname);
		model.addAttribute("username", username);
		model.addAttribute("bid", boardid);
		return "board/write"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,HttpSession session, Model model)
	{
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		model.addAttribute("bid", boardid);
		String id=request.getParameter("id");
	String groupid=request.getParameter("gid");
	model.addAttribute("gid", groupid);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
		   dao.delete(id,groupid); 
		   return "redirect:/list?gid="+groupid+"&boardid="+boardid+"&page=1";
	}
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request,HttpSession session, Model model)
	{
		int selvalue=Integer.parseInt(request.getParameter("selvalue"));
		String searchtext=request.getParameter("searchtext");
		int start=Integer.parseInt(request.getParameter("start"));
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		String id=request.getParameter("id");
		String groupid=request.getParameter("groupid");
		System.out.println("groupid: "+groupid);
	model.addAttribute("gid", groupid);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
		if(selvalue == 0)
		{
			System.out.println(searchtext+"  "+start);
			ArrayList<Board> list=dao.searchtitle(searchtext, start);
			 model.addAttribute("list",list);
		}
		else
		{
			System.out.println(searchtext+"  "+start);
			ArrayList<Board> list=dao.searchusername(searchtext, start);
			 model.addAttribute("list",list);
		}
		return "redirect:/list?gid="+groupid+"&boardid="+boardid+"&page=1";
	}
	
	
	
	  public void inc(HttpServletRequest request, HttpSession session, Model model)
		{
			String id=request.getParameter("id");
			String groupid=request.getParameter("gid");
			model.addAttribute("gid", groupid);
		}
	 
}
