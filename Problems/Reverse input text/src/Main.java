import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // start coding here
            char[] arr = new char[50];
            int rec = reader.read();
            int i = 0;
            while (rec != -1) {
                arr[i] = (char) rec;
                i++;
                rec = reader.read();
            }
            int j = 49;
            while (arr[j] == 0) { j--; }
            while (j != -1) {
                System.out.print(arr[j]);
                j--;
            }
        }
    }
}