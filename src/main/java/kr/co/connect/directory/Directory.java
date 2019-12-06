package kr.co.connect.directory;

public class Directory {
 private String id;
 private String directoryid;
 private String directoryname;
 private String groupid;
 
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDirectoryid() {
	return directoryid;
}
public void setDirectoryid(String directoryid) {
	this.directoryid = directoryid;
}
public String getDirectoryname() {
	return directoryname;
}
public void setDirectoryname(String directoryname) {
	this.directoryname = directoryname;
}
public String getGroupid() {
	return groupid;
}
public void setGroupid(String groupid) {
	this.groupid = groupid;
}
public Directory(String id, String directoryid, String directoryname, String groupid) {
	super();
	this.id = id;
	this.directoryid = directoryid;
	this.directoryname = directoryname;
	this.groupid = groupid;
}
public Directory(){}
}
