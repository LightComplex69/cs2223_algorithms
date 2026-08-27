import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Algorithm Stuff: Hash Edition.");
        System.out.println("Select an option. (M for Moby Dick Hashing, D for Dijkstra's Algorithm)");
        String input = keyboard.nextLine();

        switch (input) {
            case "m":
            case "M":
                MobyHash m = new MobyHash();
                m.program();
                break;

            case "d":
            case "D":
                Dijkstra d = new Dijkstra();
                d.program();
                break;

            default:
                System.out.println("Invalid Entry");
                main(args);
                break;
        }
    }
}