import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Lucas or Subirachs? (L for Lucas, S for Subirachs)");
        String input = keyboard.nextLine();

        switch (input) {
            case "l":
            case "L":
                LucasCalc lc = new LucasCalc();
                lc.start();
                break;
            case "s":
            case "S":
                Subirachs su = new Subirachs();
                su.start();
                break;
            default:
                System.out.println("Invalid Entry");
                main(args);
                break;
        }
    }
}