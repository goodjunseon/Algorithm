import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int T;
    static char[] function;
    static int n;
    static String line;

    static boolean reverse;
    static boolean error;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 4

        for (int i = 0; i < T; i++) {
            function = br.readLine().toCharArray(); // RDD
            n = Integer.parseInt(br.readLine());
            StringBuilder sb= new StringBuilder();
            line = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            line = line.substring(1, line.length() - 1); // 대괄호 제거

            if (n > 0 && !line.isEmpty()) {
                String[] nums = line.split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }

            reverse = false;
            error = false;

            for (char cmd : function) {
                if (cmd == 'R') {
                    reverse = !reverse;
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    } else {
                        if (!reverse) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                    }
                }
            }

            if (error) {
                sb.append("error");
            } else {
                sb.append('[');

                int size = deque.size();
                for (int j = 0; j < size; j++) {
                    sb.append(reverse ? deque.pollLast() : deque.pollFirst());
                    if (j != size - 1) {
                        sb.append(',');
                    }
                }

                sb.append(']');
            }

            System.out.println(sb);

        }
    }

}