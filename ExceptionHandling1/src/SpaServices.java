
public class SpaServices {
	private int spaNo;
	private boolean booked = false;

	public SpaServices(int spaNo) {
		this.spaNo = spaNo;
	}
	
	public int getSpaNo() {
		return spaNo;
	}
	
	public boolean isBooked() {
		return booked;
	}

	public void setSpaNo(int spaNo) {
		this.spaNo = spaNo;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	} 

}
