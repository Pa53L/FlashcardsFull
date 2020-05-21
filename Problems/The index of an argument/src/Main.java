class Problem {
    public static void main(String[] args) {
        int find = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("test")) {
                find = i;
            }
        }
        System.out.println(find);
    }
}