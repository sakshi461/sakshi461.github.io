
public class EventHall {
	private int hallNo;
	private boolean booked = false;
	
	public EventHall(int hallNo) {
		this.hallNo = hallNo;
	}
	
	public int getHallNo() {
		return hallNo;
	}
	
	public boolean isBooked() {
		return booked;
	}

	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	} 

}
