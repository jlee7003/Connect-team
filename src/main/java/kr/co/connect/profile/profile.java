package kr.co.connect.profile;

public class profile {
private String id;
private String username;
private String email;
private String sex;
private String img;
private String profilemsg;
public String getProfilemsg() {
	return profilemsg;
}
public profile(String id, String username, String email, String sex, String img, String profilemsg) {
	super();
	this.id = id;
	this.username = username;
	this.email = email;
	this.sex = sex;
	this.img = img;
	this.profilemsg = profilemsg;
}
public void setProfilemsg(String profilemsg) {
	this.profilemsg = profilemsg;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
}
