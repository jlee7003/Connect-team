package kr.co.connect.board;

public class Board {
	private String id;
	private String username;
	private String title;
	private String writeday;
	private String writeremail;
	private String content;
	private String groupid;
	
	public Board() {}
	
	public Board(String id, String username, String title, String writeday, String writeremail, String content,
			String groupid) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.writeday = writeday;
		this.writeremail = writeremail;
		this.content = content;
		this.groupid = groupid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public String getWriteremail() {
		return writeremail;
	}
	public void setWriteremail(String writeremail) {
		this.writeremail = writeremail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	
}
