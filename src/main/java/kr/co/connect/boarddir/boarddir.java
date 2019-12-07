package kr.co.connect.boarddir;

public class boarddir {
	private String id;
	private String boardname;
	private int boardid;
	private int directoryid;
	private int groupid;
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	private String directoryname;
	public String getDirectoryname() {
		return directoryname;
	}
	public void setDirectoryname(String directoryname) {
		this.directoryname = directoryname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public int getDirectoryid() {
		return directoryid;
	}
	public void setDirectoryid(int directoryid) {
		this.directoryid = directoryid;
	}
	public boarddir(String id, String boardname, int boardid, int directoryid, int groupid, String directoryname) {
		super();
		this.id = id;
		this.boardname = boardname;
		this.boardid = boardid;
		this.directoryid = directoryid;
		this.groupid = groupid;
		this.directoryname = directoryname;
	}
	public boarddir() {}
}
