import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class Subirachs {
    private final Scanner keyboard = new Scanner(System.in);
    LinkedList<Integer> square = new LinkedList<>();

    public Subirachs() {
        square.add(1);
        square.add(14);
        square.add(14);
        square.add(4);
        square.add(11);
        square.add(7);
        square.add(6);
        square.add(9);
        square.add(8);
        square.add(10);
        square.add(10);
        square.add(5);
        square.add(13);
        square.add(2);
        square.add(3);
        square.add(15);
    }

    public void start() {
        System.out.println("Welcome to Subirachs Magic Square!");
        System.out.print("Enter 1: 4 element magic number sum, ");
        System.out.print("Enter 2: 'n' element magic number sum, ");
        System.out.print("Enter 3: all possible sums" + "\n");
        String input = keyboard.nextLine();

        switch (input) {
            case "1":
                System.out.println("There are " + displayFourCombMagic() + " four element combinations that add to 33.");
                break;
            case "2":
                System.out.println("There are " + displayAllSums().get(33) + " combinations of numbers that add to 33.");
                break;
            case "3":
                for (int i = 0; i < 133; i++) {
                    System.out.println(i + " occurs " + displayAllSums().get(i) + " times");
                }
                break;

            default:
                System.out.println("Invalid Entry");
                start();
                break;
        }
    }

    public int displayFourCombMagic() {
        int magicCounter = 0;
        int sum = 0;

        for (int i = 0; i < square.size() - 3; i++) {
            for (int j = i + 1; j < square.size() - 2; j++) {
                for (int k = j + 1; k < square.size() - 1; k++) {
                    for (int l = k + 1; l < square.size() && k < l; l++) {
                        sum = (square.get(i) + square.get(j) + square.get(k) + square.get(l));
                        //System.out.println(i + " + " + j + " + " + k + " + " + l + " = " + sum);
                        if (sum == 33) {
                            magicCounter++;
                        }
                    }
                }
            }
        }

        return magicCounter;
    }

    public Map<Integer, Integer> displayAllSums() {
        LinkedList<Integer> result = new LinkedList<>();
        int n = square.size();
        int sum = 0;

        for (int i = 0; i < (1 << n); i++) {
            sum = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += square.get(j);
                }
            }
            result.add(sum);
        }

        return getNumberFrequency(result);
    }

    public Map<Integer, Integer> getNumberFrequency(LinkedList<Integer> inputList) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (Integer integer : inputList) {
            if (resultMap.containsKey(integer)) {
                resultMap.put(integer, resultMap.get(integer) + 1);
            } else {
                resultMap.put(integer, 1);
            }
        }

        return resultMap;
    }
}
