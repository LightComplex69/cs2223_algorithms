import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Homework 4!");
        System.out.println("Enter G for Gauss-Jordan question, or Enter M for Most-Precious-Path question");

        String input = keyboard.nextLine();

        switch(input){
            case "g":
            case "G":
                GaussJordan g = new GaussJordan();

                // coefficient columns
                double[][] A = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1},
                        {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                        {11, -10, 9, -8, 7, -6, 5, -4, 3, -2, 1}};
                // answer column
                double[] b = {2047, 3, 12, 48, 384, 1536, 5, 50, 1952, 4083, 459};
                // solutions
                double[] x = g.BestForwardElimination(A, b);

                System.out.println("Unique solution for the provided matrix:");

                for (int i = 0; i < x.length; i++) {
                    System.out.println("x" + (i + 1) + " = " + x[i]);
                }
                break;

            case "m":
            case "M":
                break;

            default:
                System.out.println("Invalid Selection!!!");
                main(args);
        }
    }
}