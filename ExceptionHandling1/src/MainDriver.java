import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDriver {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	Reservation reservation = new Reservation();
	
	System.out.println("Welcome to hotel reservation ");
	int choice;
	while (true) {
	    System.out.println("Select an option\n| 1 Make Reservation\n| 2 Check Availability" +
				"\n| 3 Checkout\n| 4 Exit");
		choice= scanner.nextInt();
	    scanner.nextLine();
		if(choice==1){
			makeReservation(scanner, reservation);
		} else if (choice==2) {
			checkAvailability(reservation);
		} else if (choice==3) {
			unReserve(scanner, reservation);
		} else if (choice==4) {
			System.out.println("Exiting the program.");
			break;
		}else{
			System.out.println("Please enter a valid option");
		}
	}

	
}
public static void makeReservation(Scanner scanner, Reservation res) {
    try {
        System.out.println("Enter reservation type (Room, EventHall, SpaServices)");
        String type = scanner.nextLine();
        System.out.println("Enter room no");
		int roomNumber = scanner.nextInt();
		scanner.nextLine();

        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter contact number");
        long phone = scanner.nextLong();
		scanner.nextLine();

        Guest guest = new Guest(name, phone);
        String roomType = null;

        if (type.equals("Room")) {
            System.out.println("Enter room type (Standard, Deluxe, Suite)");
            roomType = scanner.nextLine();
        }

        res.makeReservation(type, roomNumber, guest, roomType);
    } 
    catch (InputMismatchException | InvalidReservationException | RoomNotFoundException e) {
        System.out.println("Error: " + e.getMessage());
    }
    finally {
        res.availability();
    }
}
public static void checkAvailability(Reservation res) {
	res.availability();
}
public static void unReserve(Scanner scanner, Reservation res) {
    try {
        System.out.println("Enter reservation type (Room, EventHall, SpaServices)");
        String type = scanner.nextLine();

        System.out.println("Enter room no (1-10)");
		int roomNumber = scanner.nextInt();
		scanner.nextLine();

        res.unReservation(type, roomNumber);
    }
    catch (InputMismatchException | RoomNotFoundException e) {
        System.out.println("Error: " + e.getMessage());
    } 
    finally {
        res.availability();
    }
}
}

