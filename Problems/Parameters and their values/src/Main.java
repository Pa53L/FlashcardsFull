class Problem {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 1) {
                System.out.println(args[i]);
            } else {
                System.out.print(args[i] + "=");
            }
        }
    }
}