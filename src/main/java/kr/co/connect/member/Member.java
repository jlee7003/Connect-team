package kr.co.connect.member;

public class Member {
	private String id;
	private String username;
	private String phone;
	private String email;
	private String password;
	private String birth;
	private String sex;
	private String groups;
	public String getGroups() {
		return groups;
	}
	public Member(String id, String username, String phone, String email, String password, String birth, String sex,
			String groups, String writeday) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.birth = birth;
		this.sex = sex;
		this.groups = groups;
		this.writeday = writeday;
	}
	
	public Member() {}
	
	public void setGroups(String groups) {
		this.groups = groups;
	}
	private String writeday;
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}



}
