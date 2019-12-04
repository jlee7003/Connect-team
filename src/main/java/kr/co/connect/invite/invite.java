package kr.co.connect.invite;

public class invite {
private String invited;
private int groupid;
private String authnum;
private String username;
private String groupname;

public invite(String invited, int groupid, String authnum, String username, String groupname) {
	super();
	this.invited = invited;
	this.groupid = groupid;
	this.authnum = authnum;
	this.username = username;
	this.groupname = groupname;
}
public String getGroupname() {
	return groupname;
}
public void setGroupname(String groupname) {
	this.groupname = groupname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public invite() {}

public String getInvited() {
	return invited;
}
public void setInvited(String invited) {
	this.invited = invited;
}
public int getGroupid() {
	return groupid;
}
public void setGroupid(int groupid) {
	this.groupid = groupid;
}
public String getAuthnum() {
	return authnum;
}
public void setAuthnum(String authnum) {
	this.authnum = authnum;
}

}
