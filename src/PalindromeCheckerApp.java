import java.util.Scanner;

public class UseCase11PalindromeCheckerApp {

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
     * Recursive method to check palindrome
     */
    private static boolean isPalindrome(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // Check characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }
}