import java.util.Scanner;

public class UseCase12PalindromeCheckerApp {

    /**
     * Application entry point
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Input: ");
        String input = sc.nextLine();

        // Optional: make it case-insensitive and ignore spaces
        input = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = checkPalindrome(input, 0, input.length() - 1);

        System.out.println("Is Palindrome?: " + result);

        sc.close();
    }

    /**
     * Recursive palindrome checker
     */
    private static boolean checkPalindrome(String str, int start, int end) {

        // Base case
        if (start >= end) {
            return true;
        }

        // Compare characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return checkPalindrome(str, start + 1, end - 1);
    }
}