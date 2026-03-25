import java.util.Scanner;

public class UseCase13PalindromeCheckerApp {

    /**
     * Application entry point
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Input: ");
        String input = sc.nextLine();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        System.out.println("Is Palindrome?: " + result);

        sc.close();
    }

    /**
     * Recursive palindrome checker
     */
    private static boolean isPalindrome(String str, int start, int end) {

        // Base case
        if (start >= end) {
            return true;
        }

        // Case-insensitive comparison
        if (Character.toLowerCase(str.charAt(start)) !=
                Character.toLowerCase(str.charAt(end))) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }
}