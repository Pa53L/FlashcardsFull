import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();
        
        while (true) {
            Random random = new Random(k);
            boolean ret = true;
            for (int i = 0; i < n; i++) {
                double rnd = random.nextGaussian();
                if (rnd > m) {
                    ret = false;
                    break;
                }
            }
            if (ret) {
                System.out.println(k);
                break;
            }
            k++;
        }
    }
}