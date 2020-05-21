/* Please, do not rename it */
class Problem {

    public static void main(String args[]) {
        String operator = args[0];
        // write your code here
        int max = Integer.parseInt(args[1]);
        int min = Integer.parseInt(args[1]);
        int sum = 0;
        for (int i = 1; i < args.length; i++) {
            if (Integer.parseInt(args[i]) > max) {
                max = Integer.parseInt(args[i]);
            }
            if (Integer.parseInt(args[i]) < min) {
                min = Integer.parseInt(args[i]);
            }
            sum += Integer.parseInt(args[i]);
        }
        switch (operator) {
            case "MAX":
                System.out.println(max);
                break;
            case "MIN":
                System.out.println(min);
                break;
            case "SUM":
                System.out.println(sum);
        }
    }
}