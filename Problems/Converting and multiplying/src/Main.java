import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        int index = 0;
        arrayList.add(sc.nextLine());
        while (!arrayList.get(index).equals("0")) {
            //arrayList.add(sc.nextLine());
            try {
                System.out.println(Integer.parseInt(arrayList.get(index)) * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + arrayList.get(index));
            }
            index++;
            arrayList.add(sc.nextLine());
        }
    }
}
