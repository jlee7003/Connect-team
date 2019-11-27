package kr.co.connect.group.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.connect.group.beans.GroupDto;
import kr.co.connect.group.mapper.GroupMapperInterface;

//@RequestMapping("/connect/group")
@Controller
public class GroupController {

//	@Autowired
//	public GroupMapperInterface groupMapper;

	// 클라이언트가 요청한 주소(url)에 대한 응답 페이지를 매핑
	@RequestMapping(value = "connect/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping("/makeGroup")
	public String makeGroup() {
		return "groups/makeGroup"; // 실제 응답 페이지가 있는 경로
	}
/*
	@RequestMapping(value = "/makeGroupOk", method = RequestMethod.POST)
	public String makeGroupOk(GroupDto groupDto, HttpSession session) {
//		groupMapper.insertData(groupDto);
		// 세션 생성 
		session.setAttribute("groupname", groupDto.getGroupname());
		return "groups/makeGroupOk";
	}
*/
}
