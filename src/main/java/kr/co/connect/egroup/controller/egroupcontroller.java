package kr.co.connect.egroup.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.connect.egroup.Egroup;
import kr.co.connect.egroup.dao.iegroupDao;
import kr.co.connect.invite.invite;
import kr.co.connect.invite.dao.iinviteDao;
import kr.co.connect.member.service.EmailConfirm;

@Controller
public class egroupcontroller {

	@Autowired // 자동으로 아래의 메소드들과 연결시켜줌
	public SqlSession sqlSession;

	@RequestMapping(value = "/joingroup") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String joingroup(Model model, HttpSession session) {
	
		System.out.println("정상출력");
		inc(session,model);
		ArrayList<Egroup> checkifhavegroup;
		iegroupDao dao1 = sqlSession.getMapper(iegroupDao.class);
		if (session.getAttribute("userid") == null) {
			return "chat/nogroups";
		} else {
			String email=session.getAttribute("userid").toString();
			iegroupDao dao12=sqlSession.getMapper(iegroupDao.class);
			ArrayList<Egroup> glist=dao12.grouplist(email);
			model.addAttribute("glist", glist);
			
			checkifhavegroup = dao1.groupliststring(session.getAttribute("userid").toString());
			System.out.println(checkifhavegroup+"wewe");
			if (checkifhavegroup == null) {
				System.out.println(checkifhavegroup+"1");
				return "redirect:/chatroom";
			} else {
				String userid=session.getAttribute("userid").toString();
				System.out.println(checkifhavegroup+"2");
				model.addAttribute("userid",userid);
				return "egroup/joingroup"; // 실제 주소(실제로 입력이 되는 주소)
			}
		}

	}

	@RequestMapping(value = "/joingroup_ok") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String joingroup_ok(HttpServletRequest request, Egroup egroup,Model model, HttpSession session) {
		String mg=request.getParameter("mg");
		if( mg=="그룹만들기")
		{
			
		
		iegroupDao dao1 = sqlSession.getMapper(iegroupDao.class);
		int groupid = dao1.select();

		iegroupDao dao = sqlSession.getMapper(iegroupDao.class);
		dao.write(groupid, egroup.getEmail(), egroup.getGroupname(), egroup.getManager(), egroup.getWriteday());
		inc(session,model);
		return "egroup/joingroup_ok"; // 실제 주소(실제로 입력이 되는 주소)
		}
		else
		{
		String err="정확히 입력해주세요";
	    model.addAttribute("err",err);
	    return "egroup/joingroup";
		}
	}
	
	@RequestMapping(value = "/sorry") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String sorry(HttpServletRequest request,Model model, HttpSession session) 
	{
		   iinviteDao dao1 = sqlSession.getMapper(iinviteDao.class);
		   String invited=session.getAttribute("userid").toString();
		   String groupid2 =request.getParameter("groupid");
			inc(session,model);
		   System.out.println(invited+"=="+groupid2);
		   dao1.delinvite(invited,groupid2);
		return "egroup/invitesorry"; // 실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping(value = "/invited") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String invited(Model model,invite invite, HttpSession session) {
		if(session.getAttribute("userid")!=null)//로그인이 되어 있다면
		{
	    inc(session,model);
		String email=session.getAttribute("userid").toString();
		iinviteDao dao = sqlSession.getMapper(iinviteDao.class);
		ArrayList<invite> invitelist= dao.invitelist(email);
		model.addAttribute("invitelist",invitelist);
		
		return "egroup/invited"; // 실제 주소(실제로 입력이 되는 주소)
		}
		else //로그인이 안되어 있다면
		{
			
			return "chat/nogroups";
		}
		
	}
	
	@RequestMapping(value = "/oksign") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String oksign(HttpServletRequest request,Egroup egroup,Model model, HttpSession session) {
		String groupname=request.getParameter("groupname");
        String username=request.getParameter("username");
        String joincode=request.getParameter("joincode");
        String groupid2=request.getParameter("groupid");
        String invited=session.getAttribute("userid").toString();
        int groupid=Integer.parseInt(request.getParameter("groupid"));
        
        iinviteDao dao1 = sqlSession.getMapper(iinviteDao.class);
        String manager=dao1.whoismanager(groupid2);
        String email=session.getAttribute("userid").toString();
        String authnum = dao1.viewinvitenum(invited, groupid);
        
		iegroupDao dao = sqlSession.getMapper(iegroupDao.class);
	    int groupoverlap=dao.groupoverlap(email, groupid);
	    if(groupoverlap == 0 && authnum.equals(joincode))
	    {
	    	System.out.println(email+" "+groupid);
	    	System.out.println("groupoverlap :"+groupoverlap );
		dao.write2(groupid,email, egroup.getGroupname(),manager, egroup.getWriteday());
	    }
	    else
	    {
	    	System.out.println("groupoverlap :"+groupoverlap );
	    	System.out.println(email+" "+groupid);
	    	String overlap="이미 가입하셨거나 인증번호가 틀렸습니다.";
			model.addAttribute("overlap",overlap);
			return "egroup/inviteok";
	    }
		inc(session,model);
		dao1.delinvite(invited,groupid2);
		return "egroup/inviteok"; // 실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping(value = "/invitecheck") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String invitecheck(HttpServletRequest request,Model model, HttpSession session) {
		int groupid =Integer.parseInt(request.getParameter("groups"));
		String groupid2 =request.getParameter("groups");
		String groupname=request.getParameter("groupname");
        iinviteDao dao1 = sqlSession.getMapper(iinviteDao.class);
        String manager=dao1.whoismanager(groupid2);
        String username=session.getAttribute("username").toString();
		if(session.getAttribute("groups")!=null || manager==username)
		{
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		String email = email1 + "@" + email2;//
		int inviteoverlap;
		EmailConfirm emailconfirm = new EmailConfirm();
		String authNum = emailconfirm.connectEmail(email);//
		iinviteDao dao = sqlSession.getMapper(iinviteDao.class);
		inviteoverlap=dao.overlapinvite(email,groupid);
		System.out.println(inviteoverlap+"123");
		if(inviteoverlap != 0)
		{
			String overlap="회원님을 이미 초대하셨습니다.";
			model.addAttribute("overlap",overlap);
		}
		else
		{
			System.out.println("초대리스트작성");
			dao.writeinvite(email,groupid,authNum,username,groupname);
		}
		
		inc(session,model);

		return "member/invitecheck"; // 실제 주소(실제로 입력이 되는 주소)
		}
		else {
			System.out.println("해당그룹의 매니저가 아닙니다.");
			return "member/youarenotmanager";
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
		  iinviteDao dao = sqlSession.getMapper(iinviteDao.class);
		  String invitenum=dao.invitednum(email); String messege="그룹초대";
		  model.addAttribute("invitenum", invitenum);
		  model.addAttribute("messege",messege); 
		  }
		}
}