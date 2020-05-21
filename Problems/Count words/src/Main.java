import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // start coding here
            int rec = reader.read();
            int wordCount = 0;
            boolean state = false;
            while (rec != -1) {
                if (rec == ' ' || rec == '\n' || rec == '\t') {
                    state = false;
                } else if (!state) {
                    wordCount++;
                    state = true;
                }
                rec = reader.read();
            }
            System.out.println(wordCount);
        }
    }
}
