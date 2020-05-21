import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int finish = sc.nextInt();
        int numOfPairs = sc.nextInt();
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < numOfPairs; i++) {
            map.put(sc.nextInt(), sc.next());
        }
        for (var entry : map.entrySet()) {
            if (entry.getKey() >= start && entry.getKey() <= finish)
                System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}