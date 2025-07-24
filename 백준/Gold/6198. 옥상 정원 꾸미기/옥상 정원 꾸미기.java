import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
            }
            stack.push(h);
            result += stack.size()-1;
        }

        System.out.println(result);
    }
}