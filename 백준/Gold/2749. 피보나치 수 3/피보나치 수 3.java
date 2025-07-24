import java.io.*;

public class Main {
    static final int MOD = 1_000_000;

    static int result;
    static int pisano;
    static int reduceN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        pisano = getPisanoPeriod(MOD);
        reduceN = (int) (n%pisano);

        result = fiboMod(reduceN);

        System.out.println(result);

    }
    private static int getPisanoPeriod(int m) {
        int previous = 0;
        int current = 1;
        int count;
        for (int i = 0; i < m*6; i++) {
            count = (previous + current) % m;
            previous = current;
            current = count;

            if (previous == 0 && current == 1) {
                return i + 1;
            }
        }
        return -1;
    }

    private static int fiboMod(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int previous = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int next = (previous + current) % MOD;
            previous = current;
            current = next;
        }
        return current;
    }
}
