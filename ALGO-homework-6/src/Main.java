import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Algorithm Stuff: N Queens Edition.");
        System.out.println("Select an option. (L for Legal Position Check, N for Next Legal Position, A for All Solutions)");
        String input = keyboard.nextLine();
        NQueens nq = new NQueens();

        int[] fullSolution = new int[]{1, 6, 8, 3, 7, 4, 2, 5};
        int[] partialSolution = new int[]{1, 6, 8, 3, 7, 0, 0, 0};
        int[] wrongPartialSolution = new int[]{1, 6, 8, 3, 5, 0, 0, 0};
        int[] anotherWrong = new int[]{1, 3, 0, 0};

        switch (input) {
            case "l":
            case "L":
                System.out.println(Arrays.toString(fullSolution) + " returns " + nq.isLegalPosition(fullSolution, fullSolution.length));
                System.out.println(Arrays.toString(partialSolution) + " returns " + nq.isLegalPosition(partialSolution, partialSolution.length));
                System.out.println(Arrays.toString(wrongPartialSolution) + " returns " + nq.isLegalPosition(wrongPartialSolution, wrongPartialSolution.length));
                System.out.println(Arrays.toString(anotherWrong) + " returns " + nq.isLegalPosition(anotherWrong, anotherWrong.length));
                break;

            case "n":
            case "N":
                // Not implemented :(
                nq.nextLegalPosition(wrongPartialSolution, wrongPartialSolution.length);
                break;

            case "a":
            case "A":
                nq.allSolutions();
                break;

            default:
                System.out.println("Invalid Entry");
                main(args);
                break;
        }
    }
}