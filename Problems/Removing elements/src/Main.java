import java.util.*;
import java.util.function.Predicate;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        // write your code here
        Set<Integer> numFromString = new HashSet<>();
        Set<String> parse = new HashSet<>();
        parse.addAll(List.of(str.split("[\\s]+")));
        for (String q : parse) {
            numFromString.add(Integer.parseInt(q));
        }
        return numFromString;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        // write your code here
        set.removeIf(num -> num > 10);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}