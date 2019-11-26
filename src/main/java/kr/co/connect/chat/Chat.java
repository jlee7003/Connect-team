package kr.co.connect.chat;

public class Chat {

	private String username;
	private String id;
	private String content;
	private String groups;
	private String chattime;
	
	public Chat(String username, String id, String content, String groups, String chattime) {
		super();
		this.username = username;
		this.id = id;
		this.content = content;
		this.groups = groups;
		this.chattime = chattime;
	}
	public String getChattime() {
		return chattime;
	}
	public void setChattime(String chattime) {
		this.chattime = chattime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	public Chat() {}
	public void setChatContent(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
