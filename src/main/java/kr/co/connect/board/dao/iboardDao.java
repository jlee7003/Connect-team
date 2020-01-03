package kr.co.connect.board.dao;

import java.util.ArrayList;

import kr.co.connect.board.Board;
import kr.co.connect.egroup.Egroup;

public interface iboardDao {


//	public ArrayList<Board> list(String groupid);

	public void write(String username, String title, String writeremail, String content, int groupid, int boardid);

	public Board content(String id, String groupid);

	public Board update(String id, String groupid);

	public void updateok(String title, String content, String id, String groupid);

	public void delete(String id, String groupid);

	public ArrayList<Board> list15(String groupid, int boardid,int page);
	
	public int cntnumber(String groupid);

	public ArrayList<Board> list10(String groupid, int boardid, int start);
	public ArrayList<Board> list20(String groupid, int boardid, int start);
	public ArrayList<Board> list25(String groupid, int boardid, int start);
	
	
	public ArrayList<Board> searchusername(String searchtext,String groupid, int boardid, int start);
	
	public ArrayList<Board> searchtitle(String searchtext, String groupid, int boardid, int start);


	public int searchusernamecount(String searchtext, String groupid, int boardid);

	public int searchtitlecount(String searchtext, String groupid, int boardid);

	public String whoiswriter(String id);
	
	public ArrayList<Egroup> memlist(String groupid);
	
	public void delmember(String id);

}
