
public class Room {
	private int roomNo;
	private boolean booked = false;

	
	public Room(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	


}
