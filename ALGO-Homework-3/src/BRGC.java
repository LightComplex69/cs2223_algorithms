import java.util.LinkedList;
import java.util.Scanner;

public class BRGC {
    private LinkedList<String> peeps = new LinkedList<>();
    private Scanner keyboard = new Scanner(System.in);

    public void start() {
        displayBRGC(5);

        for (int i = 0; i < peeps.size(); i++) {
            if (i == 0) {
                System.out.print("Spotlight ");
            }
            if (peeps.get(i).substring(0, 1).equalsIgnoreCase("1")) {
                System.out.print("Enzo ");
            }
            if (peeps.get(i).substring(1, 2).equalsIgnoreCase("1")) {
                System.out.print("Doofus ");
            }
            if (peeps.get(i).substring(2, 3).equalsIgnoreCase("1")) {
                System.out.print("Crunchy ");
            }
            if (peeps.get(i).substring(3, 4).equalsIgnoreCase("1")) {
                System.out.print("Boxo ");
            }
            if (peeps.get(i).substring(4, 5).equalsIgnoreCase("1")) {
                System.out.print("Axel ");
            }

            System.out.print(peeps.get(i) + "\n");
        }
    }

    public LinkedList<String> displayBRGC(int n) {
        if (n <= 0) {
            return peeps;
        } else if (n == 1) {
            peeps.add("0");
            peeps.add("1");
            return peeps;
        } else {
            displayBRGC(n - 1);
            LinkedList<String> speep = new LinkedList<>();

            for (int i = peeps.size() - 1; i >= 0; i--) {
                speep.add("1" + peeps.get(i));
            }
            for (int i = 0; i < peeps.size(); i++) {
                peeps.set(i, "0" + peeps.get(i));
            }

            peeps.addAll(speep);

            return peeps;
        }
    }
}
