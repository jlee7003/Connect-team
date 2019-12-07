package kr.co.connect.directory.dao;

import java.util.ArrayList;

import kr.co.connect.boarddir.boarddir;
import kr.co.connect.directory.Directory;

public interface idirectoryDao {


	public void insertdir(int directoryid, String directoryname, int groupid);
	
	public void deletedir(int groupid, String directoryname);

	public ArrayList<Directory> listdir(int groupid);

	public ArrayList<boarddir> listboarddir(int groupid);
 	public void insertdir2(int directoryid, String directoryname, int groupid);

	public int selectboardid();


	public void deleteboarddir(String boardname, int directoryid);

	public void insertboarddir(String boardname, int boardid, int directoryid, String directoryname, int groupid);

	public int getboardgroupid(int groupid);

	public void deletealldir(String boardname, String directoryname, int groupid);
}
