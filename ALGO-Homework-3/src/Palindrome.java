import java.util.Scanner;

public class Palindrome {
    Scanner keyboard = new Scanner(System.in);

    public void palindromecheck() {
        System.out.println("Welcome to the Palindrome Checker.");
        System.out.println("Enter a string to check.");
        String input = keyboard.nextLine().replaceAll(" ", "").replaceAll("\\p{IsPunctuation}", "").toLowerCase();
        boolean state = true;

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                state = false;
                break;
            }
        }

        if (state) {
            System.out.println("This string is a palindrome.");
        } else System.out.println("This string is not a palindrome.");
    }
}
