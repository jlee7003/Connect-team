package kr.co.connect.studyroom;

public class reservation {

	private String id;
	private String roomid;
	private String roomname;
	private String reserver;
	private String reservedate;
	private String afterreservedate;
	private String reservation;
	private String stime;
	private String endtime;
	public reservation() {};
	public reservation(String id, String roomid, String roomname, String reserver, String reservedate,
			String afterreservedate, String reservation, String stime, String endtime) {
		super();
		this.id = id;
		this.roomid = roomid;
		this.roomname = roomname;
		this.reserver = reserver;
		this.reservedate = reservedate;
		this.afterreservedate = afterreservedate;
		this.reservation = reservation;
		this.stime = stime;
		this.endtime = endtime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getReserver() {
		return reserver;
	}
	public void setReserver(String reserver) {
		this.reserver = reserver;
	}
	public String getReservedate() {
		return reservedate;
	}
	public void setReservedate(String reservedate) {
		this.reservedate = reservedate;
	}
	public String getAfterreservedate() {
		return afterreservedate;
	}
	public void setAfterreservedate(String afterreservedate) {
		this.afterreservedate = afterreservedate;
	}
	public String getReservation() {
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
}
