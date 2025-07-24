import java.io.*;

public class Main {
    static long result;
    static long[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new long[n + 1];
        result = fibo(n);
        System.out.println(result);

    }

    private static long fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != 0) return memo[n];

        memo[n] = fibo(n - 1) + fibo(n -2);
        return memo[n];
    }
}
