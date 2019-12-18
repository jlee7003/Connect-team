package kr.co.connect.profile.dao;

public interface iprofileDao {

	public void writeprofile(String username, String email, String sex, String empty, String profilemsg);
	
	public String profileimg(String email);
	
	public String profilemsg(String email);
	
	public void updateprofile(String img, String profilemsg, String email);
	
}
