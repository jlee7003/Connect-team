package kr.co.connect.chat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.connect.chat.Chat;

public class chatDaojsp {

	private Connection conn;

	public chatDaojsp() {
		try {

			String aa = "jdbc:mysql://localhost:3307/connect?useSSL=false";
			String bb = "root";
			String cc = "1234";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(aa, bb, cc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Chat> getChatLlist(String nowTime) {
		ArrayList<Chat> chatList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from chat where chattime > ? order by chattime";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nowTime);
			rs = pstmt.executeQuery();
			chatList = new ArrayList<Chat>();
			while (rs.next()) {
				Chat chat = new Chat();
				chat.setId(rs.getString("id"));
				chat.setUsername(rs.getString("username"));
				chat.setContent(rs.getString("content").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;")
						.replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				int chattime = Integer.parseInt(rs.getString("chattime").substring(11, 13));
				String timetype = "오전";
				if (Integer.parseInt(rs.getString("chattime").substring(11, 13)) >= 12) {
					timetype = "오후";
					chattime -= 12;
				}
				chat.setChattime(rs.getString("chattime").substring(0, 11) + " " + timetype + " " + chattime + ":"
						+ rs.getString("chattime").substring(14, 16) + "");
				chatList.add(chat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return chatList;
	}

	/* a */
	public ArrayList<Chat> getChatLlistByRecent(int number, String groups) {
		ArrayList<Chat> chatList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from chat where id > (select max(id) - ? from chat) and groups = ? order by chattime";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setInt(2, Integer.parseInt(groups));
			rs = pstmt.executeQuery();
			chatList = new ArrayList<Chat>();
			while (rs.next()) {
				Chat chat = new Chat();
				chat.setId(rs.getString("id"));
				chat.setUsername(rs.getString("username"));
				chat.setContent(rs.getString("content").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;")
						.replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				int chattime = Integer.parseInt(rs.getString("chattime").substring(11, 13));
				String timetype = "오전";
				if (Integer.parseInt(rs.getString("chattime").substring(11, 13)) >= 12) {
					timetype = "오후";
					chattime -= 12;
				}
				chat.setChattime(rs.getString("chattime").substring(0, 11) + " " + timetype + " " + chattime + ":"
						+ rs.getString("chattime").substring(14, 16) + "");
				chatList.add(chat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return chatList;

	}
	
	
	public ArrayList<Chat> getChatLlistByRecent(String id, String groups) {
		ArrayList<Chat> chatList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from chat where id > ? and groups = ? order by chattime";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.setInt(2, Integer.parseInt(groups));
			rs = pstmt.executeQuery();
			chatList = new ArrayList<Chat>();
			while (rs.next()) {
				Chat chat = new Chat();
				chat.setId(rs.getString("id"));
				chat.setUsername(rs.getString("username"));
				chat.setContent(rs.getString("content").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;")
						.replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				int chattime = Integer.parseInt(rs.getString("chattime").substring(11, 13));
				String timetype = "오전";
				if (Integer.parseInt(rs.getString("chattime").substring(11, 13)) >= 12) {
					timetype = "오후";
					chattime -= 12;
				}
				chat.setChattime(rs.getString("chattime").substring(0, 11) + " " + timetype + " " + chattime + ":"
						+ rs.getString("chattime").substring(14, 16) + "");
				chatList.add(chat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return chatList;
	}

	public int submit(String username, String content, String groups) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into chat(username,content,groups,chattime) values(?,?,?,now())";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);// 따옴표 쓰면 문자열이다 ㅠㅠㅠ
			pstmt.setString(2, content);
			pstmt.setString(3, groups);
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;

	}

}
