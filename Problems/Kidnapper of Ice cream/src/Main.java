import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String newspaper = sc.nextLine();
        String myNote = sc.nextLine();
        String[] words = newspaper.split(" ");
        String[] wordsInNote = myNote.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (map.containsKey(s)) {
                map.replace(s, map.getOrDefault(s, 0) + 1);
            } else {
                map.put(s, 1);
            }
        }
        int count = 0;
        for (String s : wordsInNote) {
            if (map.containsKey(s) && map.get(s) != 0) {
                count++;
                map.replace(s, map.getOrDefault(s, 0) - 1);
            }
        }
        if (count == wordsInNote.length) {
            System.out.println("You get money");
        } else {
            System.out.println("You are busted");
        }
    }
}