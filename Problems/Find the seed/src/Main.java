import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        //перебираем сиды
        int[] seeds = new int[b - a + 1];
        int[] maxes = new int[b - a + 1];
        for(int j = 0; j < seeds.length; j++) {
            seeds[j] = a;
            Random random = new Random(a);
            for (int i = 0; i < n; i++) {
                int next = random.nextInt(k);
                maxes[j] = Math.max(maxes[j], next);
            }
            a++;
        }
        int minValue = maxes[0];
        int resSeed = seeds[0];
        for(int i = 1; i < maxes.length; i++){
            if(maxes[i] < minValue){
                minValue = maxes[i];
                resSeed = seeds[i];
            }
        }
        System.out.println(resSeed);
        System.out.println(minValue);
    }
}