package kr.co.connect.member.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.co.connect.member.Member;


public interface imemberDao 
{
   // 사용할 메소드를 추상메소드로 정의 한다.
	//interface는 자기자신의 생성자를 만들수 없다
	public void write(String username ,String phone ,String email ,String password ,String birth, String sex, String writeday);
	
	  public ArrayList<Member> list(); 
	  public ArrayList<Member> sameID (String email);
	  public Member content(String id);
//	  Dto에 있는 레코드들을 배열로 저장하기 위해서 arraylist를 사용한다.
	  //mapping 되어 있는 dao.xml에서 쿼리문을 실행시켜줌

	  public Member login(String email,String password);
	  
	  public Member findid(String phone, String username);
	  
      public void delete(String id);

	  public Member update(Member member);
	
      public void updateok(String name ,String title ,String content ,String id);
	
	  public void write(Member dto, HttpServletRequest request);

	public Member findpwd(String phone, String username, String email);
	  
}