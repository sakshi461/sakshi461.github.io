import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Reservation {
	private Map<Integer, Guest> rooms = new LinkedHashMap<>();
	private Map<Integer, Guest> halls = new LinkedHashMap<>();
	private Map<Integer, Guest> spas = new LinkedHashMap<>();
	
	private Map<String, Map<Integer, Guest>> ress = new TreeMap<>();

	private int no;
	private String type;
	private Guest guest;
	
	public Reservation() {
		ress.put("Room", rooms);
		ress.put("EventHall", halls);
		ress.put("SpaServices", spas);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	public void makeReservation(String type, int no, Guest guest, String roomType) throws InvalidReservationException, RoomNotFoundException{
		if(no<1 || no>10) {
			throw new RoomNotFoundException("Invalid room no");
		}
		else {
			switch(type) {
			case "Room" :
				if(!rooms.containsKey(no)) {
					Room r = null;
					if(roomType.equals("Standard")) {
						r = new Standard(no);
						r.setBooked(true);
						rooms.put(no, guest);
					}
					else if(roomType.equals("Deluxe")) {
						r = new Deluxe(no);
						r.setBooked(true);
						rooms.put(no, guest);
					}
					else if(roomType.equals("Suite")) {
						r = new Suite(no);
						r.setBooked(true);
						rooms.put(no, guest);
					}
					else {
						throw new RoomNotFoundException("Invalid room type");
					}
				}
				else {
					throw new InvalidReservationException("Room already booked");
				}
				break;
				
			case "EventHall" :
				if(!halls.containsKey(no)){
					EventHall e = new EventHall(no);
					e.setBooked(true);
					halls.put(no, guest);
				}
				else {
					throw new InvalidReservationException("EventHall already booked");

				}
				break;
				
			case "SpaServices" :
				if(!spas.containsKey(no)) {
					SpaServices s = new SpaServices(no);
					s.setBooked(true);
					spas.put(no, guest);
				}
				else {
					throw new InvalidReservationException("SpaServices already booked");

				}
				break;
				
			default :
				System.out.println("Invalid choice");
			
			}
		}
		
		
	}
	
	public void availability() {
		
		for(String s : ress.keySet()) {
			System.out.println(s + " : " + ress.get(s));
		}
	}
	
	public void unReservation(String type, int no) throws RoomNotFoundException {
		boolean b = false;
		for(Entry<String, Map<Integer, Guest>> entry : ress.entrySet()) {
			String outer = entry.getKey();
			if(type.equals(outer)) {
				Map<Integer, Guest> inner = entry.getValue();
				if(inner.containsKey(no)) {
					inner.remove(no);
					b = true;
					break;
				}
				
			}
		}
		
		if(b) {
			System.out.println("Reservation deleted");
		}
		else {
			throw new RoomNotFoundException("Invalid room no");
		}
	}

	@Override
	public String toString() {
		return "Reservation [no=" + no + ", type=" + type + ", guest=" + guest + "]";
	}
	
	
	
}
