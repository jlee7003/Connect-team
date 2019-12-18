package kr.co.connect.profile.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.connect.member.Member;
import kr.co.connect.profile.dao.iprofileDao;


@Controller
public class ProfileController {

		
		@Autowired //자동으로 아래의 메소드들과 연결시켜줌
		 public SqlSession sqlSession;
		
		@RequestMapping("/seeprofile")
		public String seeprofile(HttpSession session, Model model,Member member, HttpServletRequest request) 
		{
			String email=session.getAttribute("userid").toString();
			iprofileDao dao1=sqlSession.getMapper(iprofileDao.class);
			String imgname= dao1.profileimg(email);
			String profilemsg= dao1.profilemsg(email);
			model.addAttribute("imgname",imgname);
			model.addAttribute("profilemsg",profilemsg);
			return "/profile/seeprofile";
		}
		@RequestMapping("/changeprofile")
		public String changeprofile(HttpSession session, Model model,Member member, HttpServletRequest request) 
		{
			String email=session.getAttribute("userid").toString();
			iprofileDao dao1=sqlSession.getMapper(iprofileDao.class);
			String imgname= dao1.profileimg(email);
			String profilemsg= dao1.profilemsg(email);
			model.addAttribute("imgname",imgname);
			model.addAttribute("profilemsg",profilemsg);
			return "/profile/changeprofile";
		}
		
		@RequestMapping(value="upload", method=RequestMethod.POST)
		//MultipartHttpServletRequest를 이용하는 방법
		public String upload(HttpSession session,MultipartHttpServletRequest request) {
			//여기서 이 설정을 하지 않고 web.xml 파일에 인코딩 필터 설정을 해도 됩니다.
			//파라미터를 읽기 전에 파라미터 인코딩 설정
			System.out.println("fileupload");
			
			try {
				request.setCharacterEncoding("utf-8");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			//file 파라미터의 데이터 가져오기
			MultipartFile file = request.getFile("file");
			//파일 업로드 : 문서 디렉토리
			String filepath = "C:\\Users\\Anthony\\Documents\\workspace-teampro\\connect-team\\src\\main\\webapp\\resources\\profile\\";
			//저장 경로와 원래의 파일 이름을 결합
			//파일이름의 중복을 제거하기 위해서 랜덤한 문자열을 추가
			
					String random=	UUID.randomUUID().toString() + 
					file.getOriginalFilename();
					filepath = filepath + random;

			String img=random;
			System.out.print(file.getOriginalFilename()+" "+img);
			String profilemsg=request.getParameter("profilemsg");
			String email=session.getAttribute("userid").toString();
			System.out.println(img+profilemsg+email);
			iprofileDao dao1=sqlSession.getMapper(iprofileDao.class);
			dao1.updateprofile(img, profilemsg, email);
			
			try {
				//파일 업로드
				file.transferTo(new File(filepath));
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
			return "complete";
		}
	//	
		
	}

