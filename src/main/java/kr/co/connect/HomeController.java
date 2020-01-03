package kr.co.connect;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.connect.invite.dao.iinviteDao;
import kr.co.connect.profile.dao.iprofileDao;

@Controller
public class HomeController {
	
	@Autowired // 자동으로 아래의 메소드들과 연결시켜줌
	public SqlSession sqlSession;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		inc(session,model);
		return "home";
		
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
