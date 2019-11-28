package kr.co.connect.chat.dao;

import java.util.ArrayList;

import kr.co.connect.chat.Chat;

public interface ichatDao {
	 public ArrayList<Chat> chatlist(String groups); 
	public void writechat(String username, String content, String groups);
	public String writechatstr(String username, String content, String groups);
	 public ArrayList<Chat> getchatlist(String groups); 
}

