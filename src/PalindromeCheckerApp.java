import java.util.Scanner;

public class UseCase1HotelBookingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();

        System.out.print("Enter cost per night: ");
        double costPerNight = sc.nextDouble();

        // Processing
        double totalCost = nights * costPerNight;

        // Output
        System.out.println("Customer Name: " + name);
        System.out.println("Number of Nights: " + nights);
        System.out.println("Cost per Night: " + costPerNight);
        System.out.println("Total Cost: " + totalCost);

        sc.close();
    }
}