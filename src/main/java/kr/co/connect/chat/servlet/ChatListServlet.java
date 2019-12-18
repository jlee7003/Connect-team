package kr.co.connect.chat.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.connect.chat.Chat;
import kr.co.connect.chat.dao.chatDaojsp;

public class ChatListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아작스로 받은 listtype을 통하여 반환할 함수를 다르게 해주었음
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String listType = request.getParameter("listType");
		String groups = request.getParameter("groups");
		if(listType == null || listType.equals("")) response.getWriter().write("");
		else if(listType.equals("today"))response.getWriter().write(getToday());
		else if(listType.equals("ten"))response.getWriter().write(getTen(groups));
		else {
			try {
				Integer.parseInt(listType); //숫자가 아니라면 오류 발생
				response.getWriter().write(getID(listType, groups)); 
			} catch (Exception e) {
				response.getWriter().write(""); 
			}
		}
	}
	
	// 2분 11초 동빈나 4장
	public String getToday(){
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");//<- 제이슨 : 큰따옴표로 구분하고 어떠한 변수들의 이름을 지정하고 그것을 클라이언트에게 보내진담에 클라이언트는 다시 파싱해서 화면에 출력
	    chatDaojsp chatDao =new chatDaojsp();
	    ArrayList<Chat> chatList = chatDao.getChatLlist(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	    for(int i=0; i< chatList.size(); i++)
	    {
			result.append("[{\"value\": \"" + chatList.get(i).getUsername() + "\"},");//하나의 메세지를 출력
			result.append("{\"value\": \"" + chatList.get(i).getContent() + "\"},");//하나의 메세지를 출력
			result.append("{\"value\": \"" + chatList.get(i).getChattime() + "\"}]");//하나의 메세지를 출력
			if(i != chatList.size() -1) result.append(",");                           //-> 그후 클라이언트에게 메세지를 돌려줌
	    }
	    result.append("], \"last\":\""+ chatList.get(chatList.size() - 1).getId() + "\"}");
	    //클라이언트 쪽으로 가장 마지막 채팅아이디를 보낸다.
	    return result.toString();
	}
	
	
	
	public String getTen(String groups){
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");//<- 제이슨 : 큰따옴표로 구분하고 어떠한 변수들의 이름을 지정하고 그것을 클라이언트에게 보내진담에 클라이언트는 다시 파싱해서 화면에 출력
	    chatDaojsp chatDao =new chatDaojsp();
	    ArrayList<Chat> chatList = chatDao.getChatLlistByRecent(10,groups);
	    for(int i=0; i< chatList.size(); i++)
	    {
			result.append("[{\"value\": \"" + chatList.get(i).getUsername() + "\"},");//하나의 메세지를 출력
			result.append("{\"value\": \"" + chatList.get(i).getContent() + "\"},");//하나의 메세지를 출력
			result.append("{\"value\": \"" + chatList.get(i).getChattime() + "\"}]");//하나의 메세지를 출력
			if(i != chatList.size() -1) result.append(",");                           //-> 그후 클라이언트에게 메세지를 돌려줌
	    }
	    result.append("], \"last\":\""+ chatList.get(chatList.size()-1).getId() + "\"}");
	    return result.toString();
	}
	
	
	
	public String getID(String id, String groups){
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");//<- 제이슨 : 큰따옴표로 구분하고 어떠한 변수들의 이름을 지정하고 그것을 클라이언트에게 보내진담에 클라이언트는 다시 파싱해서 화면에 출력
	    chatDaojsp chatDao =new chatDaojsp();
	    ArrayList<Chat> chatList = chatDao.getChatLlistByRecent(id,groups);
	    for(int i=0; i< chatList.size(); i++)
	    {
			result.append("[{\"value\": \"" + chatList.get(i).getUsername() + "\"},");//하나의 메세지를 출력
			result.append("{\"value\": \"" + chatList.get(i).getContent() + "\"},");//하나의 메세지를 출력
			result.append("{\"value\": \"" + chatList.get(i).getChattime() + "\"}]");//하나의 메세지를 출력
			if(i != chatList.size() -1) result.append(",");                           //-> 그후 클라이언트에게 메세지를 돌려줌
	    }
	    result.append("], \"last\":\""+ chatList.get(chatList.size()-1).getId() + "\"}");
	    return result.toString();
	}
}
