package kr.co.connect.member.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.connect.invite.dao.iinviteDao;
import kr.co.connect.member.Member;
import kr.co.connect.member.dao.imemberDao;

@Controller
public class MemberController {
	@Autowired //자동으로 아래의 메소드들과 연결시켜줌
	 public SqlSession sqlSession; //SqlSession이라는 객체를 만듬 즉 따로 객체를 만들어줄 필요 없이 알아서 자동으로 객체를 만들어줌
	
	@RequestMapping(value="/Joinus" ,produces="text/plain;charset=UTF-8")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String Joinus(String err,Model model, HttpSession session)
	{		
		model.addAttribute("err",err);
		  inc(session,model);
		return "member/Joinus"; //실제 주소(실제로 입력이 되는 주소)
	}
	@RequestMapping("/login" )//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String login(String err,Model model, HttpSession session)
	{
		model.addAttribute("err",err);
		  inc(session,model);
		return "member/login"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	
	@RequestMapping("/Joinus_ok")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String Joinus_ok(Model model,Member member, HttpServletRequest request, HttpSession session) throws SQLException
	{
		
		imemberDao dao=sqlSession.getMapper(imemberDao.class);
		dao.write(member.getUsername(), member.getPhone(),member.getEmail(),member.getPassword(),member.getBirth(),member.getSex(),member.getWriteday()); //WriteCommand으로 내가 dto에 작성한 변수 name,age,juso를 보내줌
		// 실행할 커맨드 호출
		
		session.setAttribute("username", member.getUsername());
		session.setAttribute("userid", member.getEmail());
		  inc(session,model);
		return "member/Joinus_ok"; //실제 주소(실제로 입력이 되는 주소)
	}

	@RequestMapping(value="/login_ok" ,produces="text/plain;charset=UTF-8")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String login_ok(Model model,HttpServletRequest request,HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password) throws SQLException
	{
		
		imemberDao dao=sqlSession.getMapper(imemberDao.class);
        
		Member logtruevalue = dao.login(email, password);//int형 밥통은 오직 int만 받는다
		if(logtruevalue == null)
		{
			System.out.println("wrong");
			String err="wrong id or password";
			return "redirect:/login?err="+err;
		}
		else
		{
			session.setAttribute("username", logtruevalue.getUsername());//이렇게 하면 select 하기 전의 Username이 들어감으로 X 결과값을 가져와야 함 하지만 어떻게??
			session.setAttribute("userid", email);
			session.setAttribute("groups", logtruevalue.getGroups());
			if(session.getAttribute("groups")==null && session.getAttribute("userid")==null)
			{
				System.out.println("groups가 null이다1");
				System.out.println("userid가 null이다");

			}
			  inc(session,model);
			return "redirect:/";
		}
	}
	@RequestMapping("/view")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String view(HttpSession session, Model model)
	{
		  inc(session,model);
			return "/view"; //실제 주소(실제로 입력이 되는 주소)
	} 
	@RequestMapping("/logout")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String logout(Model model,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:/"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping("/findid")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String findid(HttpSession session, Model model, Member dto, HttpServletRequest request)
	{
		imemberDao dao=sqlSession.getMapper(imemberDao.class);
	    dao.findid(dto.getPhone(), dto.getUsername());
	    model.addAttribute("Fid", dao.findid(dto.getPhone(), dto.getUsername()));
	    inc(session,model);
		return "member/findid"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping("/findid_ok")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String findid_ok(HttpSession session, Model model, Member dto, HttpServletRequest request)
	{
		imemberDao dao=sqlSession.getMapper(imemberDao.class);
	    dao.findid(dto.getPhone(), dto.getUsername());
	    model.addAttribute("Fid", dao.findid(dto.getPhone(), dto.getUsername()));
	    inc(session,model);
		return "member/findid_ok"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping("/findpwd")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String findpwd1(HttpSession session, Model model, Member dto, HttpServletRequest request)
	{
		imemberDao dao=sqlSession.getMapper(imemberDao.class);
	    dao.findpwd(dto.getPhone(), dto.getUsername(), dto.getEmail());
	    model.addAttribute("Fpwd", dao.findpwd(dto.getPhone(), dto.getUsername(), dto.getEmail()));
	    inc(session,model);
		return "member/findid"; //실제 주소(실제로 입력이 되는 주소)
	}

	
	@RequestMapping("/findpwd_ok")//브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String findpwd(Model model, Member dto, HttpServletRequest request,HttpSession session)	
	{
		imemberDao dao=sqlSession.getMapper(imemberDao.class);
	    dao.findpwd(dto.getPhone(), dto.getUsername(), dto.getEmail());
	    model.addAttribute("Fpwd", dao.findpwd(dto.getPhone(), dto.getUsername(), dto.getEmail()));
	    inc(session,model);
		return "member/findpwd_ok"; //실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping("/emailcheck")
	public String emailcheck(HttpSession session, Model model,Member member, HttpServletRequest request) 
	{
		 inc(session,model);
		return "/member/emailcheck";
	}
	

	@RequestMapping("/selectUser")
	public 	@ResponseBody String selectUser(HttpServletRequest request)
	{
		
		String emailajax=request.getParameter("emailajax");
		System.out.println("email"+emailajax);
		imemberDao dao=sqlSession.getMapper(imemberDao.class);
		ArrayList<Member> list=dao.sameID(emailajax);
		if(list.size() == 0 && emailajax != ""){
			return "ok";
		}else if(emailajax == "" || emailajax.equals(""))
		{
			return "empty";
		}
		else {
			return "nope";
		}
		
	}
	  
	  
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
