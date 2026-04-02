import java.util.*;

/**
 * MAIN CLASS - UseCase6RoomAllocation
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 */
public class UseCase6RoomAllocation {

    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.addRooms("DELUXE", 2);
        inventory.addRooms("STANDARD", 1);

        RoomAllocationService service = new RoomAllocationService();

        Reservation r1 = new Reservation("Alice", "DELUXE");
        Reservation r2 = new Reservation("Bob", "DELUXE");
        Reservation r3 = new Reservation("Charlie", "STANDARD");
        Reservation r4 = new Reservation("David", "DELUXE"); // should fail (only 2 available)

        service.allocateRoom(r1, inventory);
        service.allocateRoom(r2, inventory);
        service.allocateRoom(r3, inventory);
        service.allocateRoom(r4, inventory);
    }
}

/**
 * Handles room allocation logic
 */
class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();

        if (!inventory.isAvailable(roomType)) {
            System.out.println("❌ No rooms available for type: " + roomType);
            return;
        }

        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.reserveRoom(roomType);

        System.out.println("✅ Room allocated: " + roomId +
                " | Guest: " + reservation.getGuestName());
    }

    private String generateRoomId(String roomType) {
        String roomId;
        do {
            roomId = roomType + "-" + UUID.randomUUID().toString().substring(0, 6);
        } while (allocatedRoomIds.contains(roomId));

        return roomId;
    }
}

/**
 * Represents a reservation request
 */
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

/**
 * Manages room inventory
 */
class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRooms(String roomType, int count) {
        inventory.put(roomType, inventory.getOrDefault(roomType, 0) + count);
    }

    public boolean isAvailable(String roomType) {
        return inventory.getOrDefault(roomType, 0) > 0;
    }

    public void reserveRoom(String roomType) {
        inventory.put(roomType, inventory.get(roomType) - 1);
    }
}
