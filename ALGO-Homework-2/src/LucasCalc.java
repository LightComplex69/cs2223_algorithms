import java.util.Scanner;

public class LucasCalc {
    private final Scanner keyboard = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the Lucas Number Calculator!");
        System.out.println("Enter a value to calculate: ");
        int input = keyboard.nextInt();
        displayNumbers(input);
    }

    public void displayNumbers(int n) {
        long elapsedTime = 0;
        double lastElapsedTime = 0;
        double prevLucasNum = 0;

        for (int i = 0; i <= n; i++) {
            long start = System.nanoTime();
            long currLucasNum = calcNumbers(i);
            System.out.print("L(" + i + ") = " + currLucasNum + " --- Time Taken: ");
            long end = System.nanoTime();
            elapsedTime = end - start;

            if (lastElapsedTime == 0) {
                System.out.print(elapsedTime + "\n");
            } else {
                System.out.print(elapsedTime + " --- Ratios of Time: " + (elapsedTime / lastElapsedTime) +
                        " --- Ratios of Numbers: " + (currLucasNum / prevLucasNum) + "\n");
            }

            lastElapsedTime = elapsedTime;
            prevLucasNum = currLucasNum;
        }
    }

    public int calcNumbers(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 1;
        } else return (calcNumbers(n - 1) + calcNumbers(n - 2));
    }
}


