package kr.co.connect.egroup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Egroup {

	private int id;
	private int groupid;
	private String email;
	private String groupname;
	private String manager;
	private String writeday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public Egroup(int id, int groupid, String email, String groupname, String manager, String writeday) {
		super();
		this.id = id;
		this.groupid = groupid;
		this.email = email;
		this.groupname = groupname;
		this.manager = manager;
		this.writeday = writeday;
	}
	
	public Egroup() {}
}
