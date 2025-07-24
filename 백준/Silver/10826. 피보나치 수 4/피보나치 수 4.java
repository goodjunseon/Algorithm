import java.io.*;
import java.math.BigInteger;

public class Main {
    static BigInteger result;
    static BigInteger[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new BigInteger[n +1];
        result = fibo(n);

        System.out.println(result);

    }

    private static BigInteger fibo(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        if (memo[n] != null) return memo[n];
        memo[n] = fibo(n - 1).add(fibo(n - 2));
        return memo[n];
    }
}
