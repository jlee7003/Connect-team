package kr.co.connect.directory.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class directorycontroller {
	
	@Autowired //자동으로 아래의 메소드들과 연결시켜줌
	 public SqlSession sqlSession;
	
	@RequestMapping("/makedir")
	public String makedir(Model model)
	{
//		String
		
		return "/makedir";
	}
}
