package kr.co.connect.invite.dao;

import java.util.ArrayList;

import kr.co.connect.invite.invite;

public interface iinviteDao {
	public String invitednum(String email);
	public void writeinvite(String email, int groupid, String authNum, String username, String groupname); 
	public ArrayList<invite> invitelist(String email); 
	public String whoismanager(String groupid2);
	public void delinvite(String invited,String groupid2);
	public int overlapinvite(String email, int groupid);
}
