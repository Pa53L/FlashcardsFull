import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        // write your code here
        if (val == null)
            return (int) 0;
        else if (val >= Integer.MIN_VALUE && val <= Integer.MAX_VALUE)
            return Math.toIntExact(val);
        else if (val < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return Integer.MAX_VALUE;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
    }
}