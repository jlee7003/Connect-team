package kr.co.connect.egroup.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.connect.egroup.Egroup;
import kr.co.connect.egroup.dao.iegroupDao;

@Controller
public class egroupcontroller {

	@Autowired // 자동으로 아래의 메소드들과 연결시켜줌
	public SqlSession sqlSession;

	@RequestMapping(value = "/joingroup") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String joingroup(Model model, HttpSession session) {
		String email=session.getAttribute("userid").toString();
		iegroupDao dao12=sqlSession.getMapper(iegroupDao.class);
		ArrayList<Egroup> glist=dao12.grouplist(email);
		System.out.println("정상출력");
		model.addAttribute("glist", glist);
		ArrayList<Egroup> checkifhavegroup;
		iegroupDao dao1 = sqlSession.getMapper(iegroupDao.class);
		if (session.getAttribute("userid") == null) {
			return "chat/nogroups";
		} else {
			checkifhavegroup = dao1.groupliststring(session.getAttribute("userid").toString());
			System.out.println(checkifhavegroup+"wewe");
			if (checkifhavegroup == null) {
				
				return "redirect:/chatroom";
			} else {
				return "egroup/joingroup"; // 실제 주소(실제로 입력이 되는 주소)
			}
		}

	}

	@RequestMapping(value = "/joingroup_ok") // 브라우저에 입력된 주소(사용자가 입력하는 주소)
	public String joingroup_ok(Egroup egroup) {

		iegroupDao dao1 = sqlSession.getMapper(iegroupDao.class);
		int groupid = dao1.select();

		iegroupDao dao = sqlSession.getMapper(iegroupDao.class);
		dao.write(groupid, egroup.getEmail(), egroup.getGroupname(), egroup.getManager(), egroup.getWriteday());

		return "egroup/joingroup_ok"; // 실제 주소(실제로 입력이 되는 주소)
	}
}