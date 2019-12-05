package kr.co.connect.board.dao;

import java.util.ArrayList;

import kr.co.connect.board.Board;

public interface iboardDao {


	public ArrayList<Board> list(String groupid);

	public void write(String username, String title, String writeremail, String content, int groupid);

	public Board content(String id, String groupid);

	public Board update(String id, String groupid);

	public void updateok(String title, String content, String id, String groupid);

	public void delete(String id, String groupid);

}
