import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();
        String toParse = sc.nextLine();
        String[] arr = toParse.toLowerCase().split(" ");
        for (String s : arr) {
            if (map.containsKey(s)) {
                map.replace(s, map.getOrDefault(s, 0) + 1);
            } else {
                map.put(s, 1);
            }
        }
        map.forEach((e, v) -> System.out.println(e + " " + v));
    }
}