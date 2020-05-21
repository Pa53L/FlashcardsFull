import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        int count = 0;
        Scanner sc = new Scanner(System.in);
        char[] word_1 = sc.nextLine().toLowerCase().toCharArray();
        char[] word_2 = sc.nextLine().toLowerCase().toCharArray();
        Map<Character, Integer> map_1 = new HashMap<>();
        Map<Character, Integer> map_2 = new HashMap<>();
        for (char ch : word_1) {
            if (map_1.containsKey(ch)) {
                map_1.replace(ch, map_1.getOrDefault(ch, 0) + 1);
            } else {
                map_1.put(ch, 1);
            }
        }
        for (char ch : word_2) {
            if (map_2.containsKey(ch)) {
                map_2.replace(ch, map_2.getOrDefault(ch, 0) + 1);
            } else {
                map_2.put(ch, 1);
            }
        }
        for (var entry : map_1.entrySet()) {
            if (map_2.containsKey(entry.getKey())) {
                count = count + Math.abs(map_1.get(entry.getKey()) - map_2.get(entry.getKey()));
            } else if (!map_2.containsKey(entry.getKey())){
                count = count + map_1.get(entry.getKey());
            }
        }
        for (var entry : map_2.entrySet()) {
            if (!map_1.containsKey(entry.getKey())) {
                count = count + map_2.get(entry.getKey());
            }
        }
        System.out.println(count);
    }
}
