import java.io.*;
import java.util.*;

public class MobyHash {

    public void program() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome Moby Dick Hashing.");
        System.out.println("Select an option: ");
        System.out.println("H to Display the Hashmap, M to Display Code with Most Unique Words");
        System.out.println("Apologies. Other questions not present, IMGD 4000 kinda hard right now :(");
        String input = keyboard.nextLine();

        switch (input) {
            case "h":
            case "H":
                returnHash();
                break;

            case "m":
            case "M":
                returnMostUnique();
                break;

            default:
                System.out.println("Invalid Entry");
                program();
                break;
        }
    }

    // - converts text from file into a list of strings
    // - each string is a line of text
    private LinkedList<String> readFile() {
        LinkedList<String> words = new LinkedList<>();

        try {
            File moby = new File("src\\Moby-Dick-Chapter-1-groomed.txt");
            BufferedReader myReader = new BufferedReader(new FileReader(moby));

            String st;
            while ((st = myReader.readLine()) != null) {
                words.add(st + " ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return words;
    }

    // - separates each line of text into legible words
    // - assigns each word a hash value based on the given formula
    // - places each word and its value into a hash map
    private HashMap<String, Integer> hashWords() {
        HashMap<String, Integer> mobyhash = new HashMap<>(997);
        LinkedList<String> words = readFile();
        int hash = 0;

        for (String s : words) {
            String line = s.replaceAll("\\p{IsPunctuation}", "");
            StringBuilder word = new StringBuilder();


            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) != ' ' && line.charAt(j) != '�') {
                    hash = ((hash * 123) + (int) line.charAt(j)) % 997;
                    word.append(line.charAt(j));
                } else {
                    mobyhash.put(word.toString(), hash);
                    word = new StringBuilder();
                }
            }
        }

        return mobyhash;
    }

    // - prints the keys and values from the hash map
    private void returnHash() {
        int i = 0;

        for (Map.Entry<String, Integer> entry : hashWords().entrySet()) {
            System.out.println("Hash Address: " + i + " || Hashed Word: " + entry.getKey() +
                    " || Hash Value of Word: " + entry.getValue());
            i++;
        }
    }

    private void returnMostUnique() {
        HashMap<String, Integer> map = hashWords();
        int counter;
        int highest = 0;
        int highestHash = 0;


        for (int i = 0; i < map.size(); i++) {
            counter = 0;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == i) counter++;

                if(counter > highest) {
                    highestHash = entry.getValue();
                    highest = counter;
                }
            }
        }

        System.out.println("HashCode " + highestHash + " has " + highest + " unique words.");
    }
}
