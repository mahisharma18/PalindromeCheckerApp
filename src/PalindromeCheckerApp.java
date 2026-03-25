import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input: ");
        String str = sc.nextLine();

        String reversed = "";

        // Reverse the string
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        // Check palindrome
        if (str.equalsIgnoreCase(reversed)) {
            System.out.println("Is Palindrome?: true");
        } else {
            System.out.println("Is Palindrome?: false");
        }

        sc.close();
    }
}
