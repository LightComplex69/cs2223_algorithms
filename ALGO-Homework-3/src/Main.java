import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Algorithm Stuff.");
        System.out.println("Select an option. (P for palindrome, I for inversion, B for Binary Reflected Gray Code)");
        String input = keyboard.nextLine();

        switch (input) {
            case "p":
            case "P":
                Palindrome p = new Palindrome();
                p.palindromecheck();
                break;
            case "i":
            case "I":
                Inversion i = new Inversion();
                i.start();
                break;
            case "b":
            case "B":
                BRGC brgc = new BRGC();
                brgc.start();
                break;

            default:
                System.out.println("Invalid Entry");
                main(args);
                break;
        }
    }
}