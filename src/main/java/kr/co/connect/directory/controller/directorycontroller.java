package kr.co.connect.directory.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.connect.boarddir.boarddir;
import kr.co.connect.directory.Directory;
import kr.co.connect.directory.dao.idirectoryDao;


@Controller
public class directorycontroller {
	
	@Autowired //자동으로 아래의 메소드들과 연결시켜줌
	 public SqlSession sqlSession;
	
	@RequestMapping("/makedir")
	public String makedir(HttpServletRequest request, Model model)
	{
		
		String directoryname=request.getParameter("directoryname");
		int groupid=Integer.parseInt(request.getParameter("gid"));
		idirectoryDao dao=sqlSession.getMapper(idirectoryDao.class);
		ArrayList<Directory> listdir =dao.listdir(groupid);
		model.addAttribute("list",listdir);
		model.addAttribute("gid", groupid);
		model.addAttribute("dirname", directoryname);
		return "dir/makedir";
	}
	
	@RequestMapping("/makedirok")
	public String makedirok(HttpServletRequest request, Model model)
	{
		int directoryid=1;
		int trueval=Integer.parseInt(request.getParameter("trueval"));
		String directoryname=request.getParameter("directoryname");
		int groupid=Integer.parseInt(request.getParameter("gid"));
		model.addAttribute("gid", groupid);
		model.addAttribute("dirname", directoryname);
		idirectoryDao dao=sqlSession.getMapper(idirectoryDao.class);
		if(trueval == 1)
		{
		dao.insertdir(directoryid,directoryname,groupid);
		}
		ArrayList<Directory> listdir =dao.listdir(groupid);
		model.addAttribute("list",listdir);
		
		return "dir/makedir";
	}

	
	
	@RequestMapping("/makedirok2")
	public String makedirok2(HttpServletRequest request, Model model)
	{
		int directoryid=2;
		int trueval=Integer.parseInt(request.getParameter("trueval"));
		String directoryname=request.getParameter("directoryname");
		int groupid=Integer.parseInt(request.getParameter("gid"));
		model.addAttribute("gid", groupid);
		model.addAttribute("dirname", directoryname);
		idirectoryDao dao=sqlSession.getMapper(idirectoryDao.class);
		ArrayList<Directory> listdir =dao.listdir(groupid);
		model.addAttribute("list",listdir);
		
		return "dir/makedir";
	}
	@RequestMapping("/deletedirok")
	public String deletedirok(HttpServletRequest request, Model model)
	{
		String boardname=request.getParameter("boardname");
		int groupid=Integer.parseInt(request.getParameter("gid"));
		int directoryid=Integer.parseInt(request.getParameter("directoryid"));
		model.addAttribute("gid", groupid);
		model.addAttribute("boardname", boardname);
		idirectoryDao dao=sqlSession.getMapper(idirectoryDao.class);
		dao.deleteboarddir(boardname,directoryid);
		
		return "redirect:/makedir";
	}
	@RequestMapping("/deletefolderok")
	public String deletefolderok(HttpServletRequest request, Model model)
	{
		String boardname=request.getParameter("boardname");
		int groupid=Integer.parseInt(request.getParameter("gid"));
		int directoryid=Integer.parseInt(request.getParameter("directoryid"));
		model.addAttribute("gid", groupid);
		String directoryname=request.getParameter("directoryname");
		idirectoryDao dao=sqlSession.getMapper(idirectoryDao.class);
		dao.deletedir(groupid,directoryname);
		dao.deletealldir(boardname,directoryname,groupid);
		System.out.println(boardname+" "+directoryname+" "+groupid);
		System.out.println("실행완료");
		return "redirect:/makedir";
	}
	
	@RequestMapping("/opendirok")
	public String opendirok(HttpServletRequest request, Model model)
	{
		String directoryname=request.getParameter("directoryname");
		int directoryid=Integer.parseInt(request.getParameter("directoryid"));
		int groupid=Integer.parseInt(request.getParameter("gid"));
		model.addAttribute("gid", groupid);
		model.addAttribute("dirname", directoryname);
		idirectoryDao dao=sqlSession.getMapper(idirectoryDao.class);
		ArrayList<boarddir> listboarddir =dao.listboarddir(directoryid);
		model.addAttribute("list2",listboarddir);
		System.out.println("열림");
		ArrayList<Directory> listdir =dao.listdir(groupid);
		model.addAttribute("list",listdir);
		return "dir/makedir";
	}
	
	
	@RequestMapping("/makeboard")
	public String makeboard(HttpServletRequest request, Model model)
	{
		String directoryname=request.getParameter("directoryname");
		int groupid=Integer.parseInt(request.getParameter("gid"));
		model.addAttribute("gid", groupid);
		model.addAttribute("dirname", directoryname);
		idirectoryDao dao=sqlSession.getMapper(idirectoryDao.class);
		ArrayList<Directory> listdir =dao.listdir(groupid);
		model.addAttribute("list",listdir);
		System.out.println("열림");
		return "dir/makedir";
	}
	
	@RequestMapping("/makeboarddir")
	public String makeboarddir(HttpServletRequest request, Model model)
	{   
		int groupid=Integer.parseInt(request.getParameter("gid"));
		String directoryname=request.getParameter("directoryname");
		System.out.println(directoryname+"directoryname");
		idirectoryDao dao=sqlSession.getMapper(idirectoryDao.class);
		int boardid=dao.selectboardid();
		int directoryid=Integer.parseInt(request.getParameter("directoryid"));
		String boardname=request.getParameter("boardname");
		dao.insertboarddir(boardname,boardid,directoryid,directoryname,groupid);
		
		

		model.addAttribute("gid", groupid);
		model.addAttribute("boardname", boardname);
		
		ArrayList<Directory> listdir =dao.listdir(groupid);
		model.addAttribute("list",listdir);
		System.out.println("열림");
		return "dir/makedir";
	}
}
