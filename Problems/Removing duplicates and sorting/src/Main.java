import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        TreeSet<String> sorted = new TreeSet<>();
        int numOfStrings = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numOfStrings; i++) {
            sorted.add(sc.nextLine());
        }
        for (String s : sorted) {
            System.out.println(s);
        }
    }
}