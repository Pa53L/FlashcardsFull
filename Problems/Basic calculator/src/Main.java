class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int first = Integer.parseInt(args[1]);
        int second = Integer.parseInt(args[2]);
        switch (operator) {
            case "+":
                System.out.println(first + second);
                break;
            case "-":
                System.out.println(first - second);
                break;
            case "*":
                System.out.println(first * second);
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}