import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String toParse = sc.nextLine();
        String toCompare = sc.nextLine();
        char[] chars = toParse.toLowerCase().toCharArray();
        char[] compared = toCompare.toLowerCase().toCharArray();
        Map<Character, Integer> original = new HashMap<>();
        Map<Character, Integer> comp = new HashMap<>();
        charsToMap(chars, original);
        charsToMap(compared, comp);
        if (original.equals(comp)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

    private static void charsToMap(char[] compared, Map<Character, Integer> comp) {
        for (char ch : compared) {
            int count = 0;
            for (int i = 0; i < compared.length; i++) {
                if (compared[i] == ch && compared[i] != '~') {
                    comp.put(ch, count++);
                    count++;
                    compared[i] = '~';
                }
            }
        }
    }
}