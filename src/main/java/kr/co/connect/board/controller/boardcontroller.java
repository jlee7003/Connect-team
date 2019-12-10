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
import kr.co.connect.invite.dao.iinviteDao;

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
	
	
	@RequestMapping("/selectboardplz")
	public String selectboardplz(Model model, Board board, HttpServletRequest request,HttpSession session)
	{
//		String email=session.getAttribute("userid").toString();
//		int groupid=Integer.parseInt(request.getParameter("gid"));
//	     String groupid2=request.getParameter("groupid");
//		int boardid=Integer.parseInt(request.getParameter("boardid"));
//		  iinviteDao dao = sqlSession.getMapper(iinviteDao.class);
//		  String manager=dao.whoismanager(groupid2);
//		  if(manager==email)
//		  {
//			  System.out.println(manager+"  "+email);
//			  String grouphost="관리자";
//			  model.addAttribute("grouphost",grouphost);
//		  }
//		//write의 역할을 dao에 적어놓지 않았는데 그 역할을 xml에 적는다
		return "board/selectboardplz";
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
		String groupid=request.getParameter("gid");
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
			return "redirect:/selectboardplz?gid="+groupid+"&boardid="+boardid;
		}
		int start;
		int page=1;
	
		start=0;
		 page=Integer.parseInt(request.getParameter("page"));
			if(page != 1)
			{
				start = (page - 1) * listsee;
			}
	
		String groupname=request.getParameter("gname");
		model.addAttribute("gid", groupid);
		model.addAttribute("gname", groupname);
		String email=session.getAttribute("userid").toString();
		String user=session.getAttribute("username").toString();
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
		  
		     String groupid2=request.getParameter("gid");
			  iinviteDao dao1 = sqlSession.getMapper(iinviteDao.class);
			  String manager=dao1.whoismanager(groupid2);
			  model.addAttribute("manager",manager);
			  model.addAttribute("email",email);
			  System.out.println(email+" 1313"+manager);
			  if(manager.equals(email))
			  {  //같은 문자가 확실한데 왜 안나오지??
				  System.out.println(manager+" 관리자입니다  "+email);
				  String grouphost="관리자";
				  model.addAttribute("grouphost",grouphost);
			  }
			  else
			  {
			  System.out.println(manager+" 관리자가 아닙니다. "+email);
			  String grouphost="";
			  model.addAttribute("grouphost",grouphost);
			  }
			  
			  String selvalue=request.getParameter("selvalue");
				System.out.println("selvalue :"+selvalue);
				model.addAttribute("selvalue",selvalue);
				String searchtext=request.getParameter("searchtext");
				System.out.println("groupid: "+groupid2+" "+selvalue);
			model.addAttribute("gid", groupid);
				iboardDao dao11=sqlSession.getMapper(iboardDao.class);
				if(selvalue==null)
				{
					
				}
				else if(selvalue.equals("0"))
				{
					
						iboardDao dao33=sqlSession.getMapper(iboardDao.class);
						  cntnumber=dao33.searchtitlecount(searchtext,groupid2,boardid);
						  listsee=10;
						  pagenumber=cntnumber/listsee;
						  
						  start=0;
							 page=Integer.parseInt(request.getParameter("page"));
								if(page != 1)
								{
									start = (page - 1) * listsee;
								}
						  
						  if (cntnumber % 10 != 0)
							{
								pagenumber=pagenumber+1;
							}
						  
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
							   model.addAttribute("searchtext",searchtext);
							   model.addAttribute("selvalue",selvalue);
							   model.addAttribute("gid", groupid2);
							   System.out.println("page:"+ page);
							   System.out.println("cntnumber : "+cntnumber+"pend : "+pend+"pstart"+pstart+"pagenumber : "+pagenumber+"start : "+start);
							   System.out.println(searchtext+" d22"+groupid2+" d "+boardid+" d "+start);
								ArrayList<Board> list=dao11.searchtitle(searchtext,groupid2,boardid,start);
								 model.addAttribute("list",list);
				}
				else if(selvalue.equals("1"))
				{
					
						iboardDao dao33=sqlSession.getMapper(iboardDao.class);
						 cntnumber=dao33.searchusernamecount(searchtext,groupid2,boardid);
						 
						  listsee=10;
						  pagenumber=cntnumber/listsee;
						  
						  start=0;
							 page=Integer.parseInt(request.getParameter("page"));
								if(page != 1)
								{
									start = (page - 1) * listsee;
								}
						  
						  if (cntnumber % 10 != 0)
							{
								pagenumber=pagenumber+1;
							}
						  
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
						   model.addAttribute("searchtext",searchtext);
						   model.addAttribute("selvalue",selvalue);
						   model.addAttribute("gid", groupid2);
						   System.out.println("cntnumber : "+cntnumber+"pend : "+pend+"pstart"+pstart+"pagenumber : "+pagenumber+"start : "+start);
						   System.out.println(searchtext+" d "+groupid2+" d "+boardid+" d "+start);
							ArrayList<Board> list=dao.searchusername(searchtext,groupid,boardid,start);
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
		String user=session.getAttribute("userid").toString();
		int page=Integer.parseInt(request.getParameter("page"));
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		model.addAttribute("bid", boardid);
		model.addAttribute("page", page);
		String id=request.getParameter("id");
		String groupid=request.getParameter("gid");
		model.addAttribute("gid", groupid);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
		String writer=dao.whoiswriter(id);
		Board board =dao.content(id,groupid);
		board.setContent(board.getContent().replace("\r\n","<br>"));
		model.addAttribute("writer",writer);
		model.addAttribute("dto",board);
		model.addAttribute("user",user);
		return "board/content"; //실제 주소(실제로 입력이 되는 주소)
	}
	@RequestMapping(value="/update")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String update(HttpServletRequest request,Model model,HttpSession session)
	{
		int page=Integer.parseInt(request.getParameter("page"));
		model.addAttribute("page", page);
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

		int page=Integer.parseInt(request.getParameter("page"));
		model.addAttribute("page", page);
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		String id=request.getParameter("id");
		String groupid=request.getParameter("gid");
		model.addAttribute("gid", groupid);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
	   dao.updateok(board.getTitle(), board.getContent(), id, groupid); 
		return "redirect:/content?id="+board.getId()+"&gid="+groupid+"&boardid="+boardid+"&page="+page;
	}
	
	@RequestMapping("/delmemlist")
	public String delmemlist(Model model, Board board, HttpServletRequest request, HttpSession session)
	{ 
		String user=session.getAttribute("userid").toString();
		String groupid=request.getParameter("groupid");
		System.out.println("groupid : "+groupid);
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
		ArrayList<Egroup>list=dao.memlist(groupid);
		model.addAttribute("list", list);
		model.addAttribute("user", user);
	   return "board/delmemlist";
	}
	
	@RequestMapping("/delmember")
	public String delmember(Model model, Board board, HttpServletRequest request, HttpSession session)
	{ String id=request.getParameter("id");
		iboardDao dao=sqlSession.getMapper(iboardDao.class);
		dao.delmember(id);
	   return "board/delmemlist";
	}
	
	
	@RequestMapping("/memlist")
	public String memlist(Model model, Board board, HttpServletRequest request,HttpSession session)
	{ 
//----------------------------------------------------------------------------

		int listsee=10;
		String groupid=request.getParameter("gid");
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
			return "redirect:/selectboardplz?gid="+groupid+"&boardid="+boardid;
		}
		int start;
		int page=1;
	
		start=0;
		 page=Integer.parseInt(request.getParameter("page"));
			if(page != 1)
			{
				start = (page - 1) * listsee;
			}
	
		String groupname=request.getParameter("gname");
		model.addAttribute("gid", groupid);
		model.addAttribute("gname", groupname);
		String email=session.getAttribute("userid").toString();
		String user=session.getAttribute("username").toString();
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
		  
		     String groupid2=request.getParameter("gid");
			  iinviteDao dao1 = sqlSession.getMapper(iinviteDao.class);
			  String manager=dao1.whoismanager(groupid2);
			  model.addAttribute("manager",manager);
			  model.addAttribute("email",email);
			  System.out.println(email+" 1313"+manager);
			  if(manager.equals(email))
			  {  //같은 문자가 확실한데 왜 안나오지??
				  System.out.println(manager+" 관리자입니다  "+email);
				  String grouphost="관리자모드";
				  model.addAttribute("grouphost",grouphost);
			  }
			  else
			  {
			  System.out.println(manager+" 관리자가 아닙니다. "+email);
			  String grouphost="";
			  model.addAttribute("grouphost",grouphost);
			  }
			  
			  String selvalue=request.getParameter("selvalue");
				System.out.println("selvalue :"+selvalue);
				model.addAttribute("selvalue",selvalue);
				String searchtext=request.getParameter("searchtext");
				System.out.println("groupid: "+groupid2+" "+selvalue);
			model.addAttribute("gid", groupid);
				iboardDao dao11=sqlSession.getMapper(iboardDao.class);
				if(selvalue==null)
				{
					
				}
				else if(selvalue.equals("0"))
				{
					
						iboardDao dao33=sqlSession.getMapper(iboardDao.class);
						  cntnumber=dao33.searchtitlecount(searchtext,groupid2,boardid);
						  listsee=10;
						  pagenumber=cntnumber/listsee;
						  
						  start=0;
							 page=Integer.parseInt(request.getParameter("page"));
								if(page != 1)
								{
									start = (page - 1) * listsee;
								}
						  
						  if (cntnumber % 10 != 0)
							{
								pagenumber=pagenumber+1;
							}
						  
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
							   model.addAttribute("searchtext",searchtext);
							   model.addAttribute("selvalue",selvalue);
							   model.addAttribute("gid", groupid2);
							   System.out.println("page:"+ page);
							   System.out.println("cntnumber : "+cntnumber+"pend : "+pend+"pstart"+pstart+"pagenumber : "+pagenumber+"start : "+start);
							   System.out.println(searchtext+" d22"+groupid2+" d "+boardid+" d "+start);
								ArrayList<Board> list=dao11.searchtitle(searchtext,groupid2,boardid,start);
								 model.addAttribute("list",list);
				}
				else if(selvalue.equals("1"))
				{
					
						iboardDao dao33=sqlSession.getMapper(iboardDao.class);
						 cntnumber=dao33.searchusernamecount(searchtext,groupid2,boardid);
						 
						  listsee=10;
						  pagenumber=cntnumber/listsee;
						  
						  start=0;
							 page=Integer.parseInt(request.getParameter("page"));
								if(page != 1)
								{
									start = (page - 1) * listsee;
								}
						  
						  if (cntnumber % 10 != 0)
							{
								pagenumber=pagenumber+1;
							}
						  
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
						   model.addAttribute("searchtext",searchtext);
						   model.addAttribute("selvalue",selvalue);
						   model.addAttribute("gid", groupid2);
						   System.out.println("cntnumber : "+cntnumber+"pend : "+pend+"pstart"+pstart+"pagenumber : "+pagenumber+"start : "+start);
						   System.out.println(searchtext+" d "+groupid2+" d "+boardid+" d "+start);
							ArrayList<Board> list=dao.searchusername(searchtext,groupid,boardid,start);
							 model.addAttribute("list",list);
				}
				   model.addAttribute("bid",boardid);
				   model.addAttribute("start",start);
				   model.addAttribute("pstart",pstart);
				   model.addAttribute("pend",pend);
				   model.addAttribute("page",page);
				   model.addAttribute("cntnumber",cntnumber);
				   model.addAttribute("pagenumber",pagenumber);
		
		
//		return "redirect:/content?id="+board.getId()+"&gid="+groupid+"&boardid="+boardid+"&page="+page;
	   return "board/memlist";
	}
	
	
	@RequestMapping(value="/write")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String write(Model model,HttpSession session,HttpServletRequest request)
	{
		int boardid=Integer.parseInt(request.getParameter("boardid"));
		String username=session.getAttribute("username").toString();
		String groupid=request.getParameter("gid");
		String groupname=request.getParameter("gname");
		int page=Integer.parseInt(request.getParameter("page"));
		model.addAttribute("page", page);
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
	
	/*
	 * @RequestMapping("/search") public String search(HttpServletRequest
	 * request,HttpSession session, Model model) { // String
	 * selvalue=request.getParameter("selvalue"); // String
	 * searchtext=request.getParameter("searchtext"); // int
	 * start=Integer.parseInt(request.getParameter("start")); // int
	 * boardid=Integer.parseInt(request.getParameter("boardid")); // String
	 * id=request.getParameter("id"); // String
	 * groupid=request.getParameter("groupid"); //
	 * System.out.println("groupid: "+groupid+" "+selvalue); //
	 * model.addAttribute("gid", groupid); // iboardDao
	 * dao=sqlSession.getMapper(iboardDao.class); // if(selvalue.equals("0")) // {
	 * // System.out.println(searchtext+" a "+start); //
	 * System.out.println("listbefore"); // ArrayList<Board>
	 * list=dao.searchtitle(searchtext, start); // //
	 * model.addAttribute("list",list); // } // else // { //
	 * System.out.println(searchtext+" d "+start); // ArrayList<Board>
	 * list=dao.searchusername(searchtext, start); //
	 * model.addAttribute("list",list); // } // return
	 * "redirect:/list?gid="+groupid+"&boardid="+boardid+"&page=1&selvalue="+
	 * selvalue; }
	 */
	
	
	
	  public void inc(HttpServletRequest request, HttpSession session, Model model)
		{
			String id=request.getParameter("id");
			String groupid=request.getParameter("gid");
			model.addAttribute("gid", groupid);
		}
	 
}
