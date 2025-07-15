import java.io.*;
import java.util.StringTokenizer;

// 직각 삼각형
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (c * c == a * a + b * b ||
                b * b == a * a + c * c ||
                a * a == b * b + c * c) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}