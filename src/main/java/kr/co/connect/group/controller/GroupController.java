package kr.co.connect.group.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.connect.group.beans.GroupDto;
import kr.co.connect.group.mapper.GroupMapperInterface;

//@RequestMapping("/connect/group")
@Controller
public class GroupController {

	@Autowired
	public SqlSession sqlSession;

	// 클라이언트가 요청한 주소(url)에 대한 응답 페이지를 매핑
	@GetMapping("/makeGroup")
	public String makeGroup(Model model, HttpSession session) {
		String email = session.getAttribute("email").toString();
		model.addAttribute("email", email);
		return "groups/makeGroup"; // 실제 응답 페이지가 있는 경로
	}

	@PostMapping("/makeGroupOk")
	public String makeGroupOk(GroupDto groupDto, HttpSession session) {
		GroupMapperInterface dao = sqlSession.getMapper(GroupMapperInterface.class);
		dao.insertData(groupDto);
		// 세션 생성 
		session.setAttribute("groupname", groupDto.getGroupname());
		return "groups/makeGroupOk";
	}

}
