import java.util.Scanner;
public class Room {

    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;

    // Constructor
    public Room(int roomNumber, String roomType, double pricePerNight, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
    }

    // Method to display room details
    public void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Night: " + pricePerNight);
        System.out.println("Available: " + isAvailable);
    }
}