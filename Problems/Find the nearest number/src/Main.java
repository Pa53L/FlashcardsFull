import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String[] toParse;
        ArrayList<Integer> printList = new ArrayList<>();
        toParse = sc.nextLine().split(" ");
        int find = sc.nextInt();
        int minDiff = Math.abs(Integer.parseInt(toParse[0]) - find);
        for (int i = 1; i < toParse.length; i++) {
            if (Math.abs(Integer.parseInt(toParse[i]) - find) < minDiff) {
                minDiff = Math.abs(Integer.parseInt(toParse[i]) - find);
            }
        }
        for (int i = 0; i < toParse.length; i++) {
            if (Math.abs(Integer.parseInt(toParse[i]) - find) == minDiff) {
                printList.add(Integer.parseInt(toParse[i]));
            }
        }
        Collections.sort(printList);
        for (int n : printList) {
            System.out.print(n + " ");
        }
    }
}