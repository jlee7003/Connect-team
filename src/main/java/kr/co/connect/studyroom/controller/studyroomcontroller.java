package kr.co.connect.studyroom.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.connect.invite.dao.iinviteDao;
import kr.co.connect.profile.dao.iprofileDao;
import kr.co.connect.studyroom.studyroom;
import kr.co.connect.studyroom.dao.istudyroomDao;

@Controller
public class studyroomcontroller {

	@Autowired // 자동으로 아래의 메소드들과 연결시켜줌
	public SqlSession sqlSession;

	@RequestMapping(value = "/studyroom") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String studyroom(Model model, HttpSession session, HttpServletRequest request) {
				inc(session,model);
				istudyroomDao dao=sqlSession.getMapper(istudyroomDao.class);
				ArrayList<studyroom> studylist = dao.studylist();
				model.addAttribute("studylist", studylist);
				ArrayList<studyroom> reservationlist = dao.reservationlist();
				model.addAttribute("reservationlist", reservationlist);
				String user=session.getAttribute("username").toString();
				model.addAttribute("user", user);
				return "studyroom/studyroom"; // 실제 주소(실제로 입력이 되는 주소)
	}

	@RequestMapping(value = "/makestudyroom") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String makestudyroom(Model model, HttpSession session) {
				inc(session,model);
				istudyroomDao dao=sqlSession.getMapper(istudyroomDao.class);
				ArrayList<studyroom> studylist = dao.studylist();
				model.addAttribute("studylist", studylist);
				return "studyroom/makestudyroom"; // 실제 주소(실제로 입력이 되는 주소)
	}
	@RequestMapping(value = "/updatestudyroom") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String updatestudyroom(Model model, HttpSession session, HttpServletRequest request) {
				inc(session,model);
				istudyroomDao dao=sqlSession.getMapper(istudyroomDao.class);
				String uproomname=request.getParameter("uproomname");
				String upstarttime=request.getParameter("upstarttime");
				String upstoptime=request.getParameter("upstoptime");
				String upid=request.getParameter("upid");
				dao.updatestudyroom(uproomname,upstarttime,upstoptime,upid);
				return "redirect:/makestudyroom"; // 실제 주소(실제로 입력이 되는 주소)
	}
	@RequestMapping(value = "/deletestudyroom") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String deletestudyroom(Model model, HttpSession session, HttpServletRequest request) {
				inc(session,model);
				istudyroomDao dao=sqlSession.getMapper(istudyroomDao.class);
		        String id=request.getParameter("id");
				dao.deletestudyroom(id);
				return "redirect:/makestudyroom"; // 실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping(value = "/reservestudyroom") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String reservestudyroom(Model model, HttpSession session, HttpServletRequest request) {
				inc(session,model);
				istudyroomDao dao=sqlSession.getMapper(istudyroomDao.class);
				String upid=request.getParameter("upid");
				String roomname=request.getParameter("uproomname");
				String reserver=request.getParameter("reserver");
				String stime=request.getParameter("upstarttime");
				String endtime=request.getParameter("upstoptime");
				System.out.println(roomname+reserver+stime+endtime);
				dao.writereservation(roomname, reserver, stime, endtime, upid);
				
				
				return "studyroom/reserveok"; // 실제 주소(실제로 입력이 되는 주소)
	}
	
	@RequestMapping(value = "/delreserve") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String delreserve(Model model, HttpSession session, HttpServletRequest request) {
				inc(session,model);
				istudyroomDao dao=sqlSession.getMapper(istudyroomDao.class);
		        String id=request.getParameter("id");
				dao.deletereserve(id);
				return "redirect:/reserveok"; // 실제 주소(실제로 입력이 되는 주소)
	}
	@RequestMapping(value = "/reserveok") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String reserveok(Model model, HttpSession session, HttpServletRequest request) {
				inc(session,model);
				  String reserver=session.getAttribute("username").toString();
				  model.addAttribute("reserver", reserver);
				  
				istudyroomDao dao=sqlSession.getMapper(istudyroomDao.class);
				ArrayList<studyroom> reserlist = dao.whoreserve(reserver);
				model.addAttribute("reserlist", reserlist);
				return "studyroom/reserveok"; // 실제 주소(실제로 입력이 되는 주소)
				
	}
	
	
	@RequestMapping(value = "/makestudyroom_ok") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String makestudyroom_ok(Model model, HttpSession session,HttpServletRequest request) {
				inc(session,model);
				String reserver=request.getParameter("reserver");
				String[] roomname_a=request.getParameter("roomname_a").split(",");
				String[] starttime_a=request.getParameter("starttime_a").split(",");
				String[] stoptime_a=request.getParameter("stoptime_a").split(",");
				
				istudyroomDao dao=sqlSession.getMapper(istudyroomDao.class);
				for(int i = 0; i < roomname_a.length; i++) 
				{
				dao.writestudyroom(roomname_a[i],reserver,starttime_a[i],stoptime_a[i]);
				}
				
				System.out.println("알림"+roomname_a+" "+reserver+" "+starttime_a+" "+stoptime_a);
				
				return "redirect:/makestudyroom"; // 실제 주소(실제로 입력이 되는 주소)
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
				iprofileDao dao1=sqlSession.getMapper(iprofileDao.class);
				String imgname= dao1.profileimg(email);
				model.addAttribute("imgname",imgname);
			  }
			}
}