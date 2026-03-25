import java.util.Map;
import java.util.Scanner;

/**
 * ============================================================
 * MAIN CLASS - UseCase4RoomSearch
 * ============================================================
 *
 * Use Case 4: Room Search Functionality
 *
 * Description:
 * This class allows users to search for room availability
 * by room type using the centralized RoomInventory.
 *
 * No booking is performed here, only availability check.
 *
 * @version 4.0
 */
public class UseCase4RoomSearch {

    /**
     * Application entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RoomInventory inventory = new RoomInventory();

        System.out.print("Enter room type to search (Single/Double/Suite): ");
        String roomType = sc.nextLine();

        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (availability.containsKey(roomType)) {
            int count = availability.get(roomType);

            if (count > 0) {
                System.out.println(roomType + " rooms are available: " + count);
            } else {
                System.out.println(roomType + " rooms are currently not available.");
            }
        } else {
            System.out.println("Invalid room type entered.");
        }

        sc.close();
    }
}