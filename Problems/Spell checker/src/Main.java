import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        Set<String> knownWords = new HashSet<>();
        int numKnownWords = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numKnownWords; i++) {
            knownWords.add(sc.nextLine().toLowerCase());
        }

        Set<String> inputWords = new HashSet<>();
        int numInputWords = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numInputWords; i++) {
            inputWords.addAll(List.of(sc.nextLine().toLowerCase().split("[\\s]+")));
        }
        for (String q : inputWords) {
            if (!knownWords.contains(q)) {
                System.out.println(q);
            }
        }
    }
}