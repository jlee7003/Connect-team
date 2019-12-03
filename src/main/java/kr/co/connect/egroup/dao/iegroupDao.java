package kr.co.connect.egroup.dao;

import java.util.ArrayList;

import kr.co.connect.egroup.Egroup;

public interface iegroupDao {
	
	
	public void write(int groupid, String email, String groupname,String manager,String writeday);
	public int select();
	public ArrayList<Egroup> grouplist(String email);
	public ArrayList<Egroup> groupliststring(String email);
}
