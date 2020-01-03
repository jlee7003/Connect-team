package kr.co.connect.studyroom.dao;

import java.util.ArrayList;

import kr.co.connect.studyroom.studyroom;

public interface istudyroomDao {
	public ArrayList<studyroom> studylist();
	
	public void writestudyroom(String string, String reserver, String stime, String endtime);

	public void updatestudyroom(String uproomname, String upstarttime, String upstoptime, String upid);

	public void deletestudyroom(String id);

	public ArrayList<studyroom> wherestudylist(String id);

	public ArrayList<studyroom> whoreserve(String reserver);
	
	public ArrayList<studyroom> reservationlist();

	public void writereservation(String roomname, String reserver, String stime, String endtime, String upid);

	public void deletereserve(String id);
}
