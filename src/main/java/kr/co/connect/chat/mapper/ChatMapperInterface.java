package kr.co.connect.chat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.connect.chat.Chat;

public interface ChatMapperInterface {

	@Insert("insert into chat(username,content,groups) values(#{username},#{content},#{groups})")
	void writechat(Chat chat);
	
	@Select("select * from chat where groups=#{groups} order by id desc limit 0,20")
	List<Chat> chatlist();
	
	@Select("select * from chat where groups=#{groups} and where chartime > ? order by id desc limit 0,20")
	List<Chat> getchatlist();
}
