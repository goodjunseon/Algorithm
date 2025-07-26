import java.io.*;
import java.util.Arrays;

public class Main {
    /*
    * 1. 짧은 것이 앞
    * 2. 길이가 같으면, 자릿수의 합이 작은것이 앞(숫자만)
    * 3. 1,2 같을 시 알파벳 사전순
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String[] serials = new String[N];

        for (int i = 0; i < N; i++) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, (o1, o2) -> {
            // return값 
            // 음수 : o1,o2
            // 0 : 순서 유지
            // 양수 : o2, o1
            
            // 1. 길이가 짧은 것이 우선
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            // 2. 숫자합이 작은 것이 우선
            int sum1 = getDigit(o1);
            int sum2 = getDigit(o2);
            if (sum1 != sum2) {
                return sum1 - sum2;
            }

            // 3. 사전 순 정렬
            return o1.compareTo(o2);
        });

        for (String s : serials) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();

    }

    public static int getDigit(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }

}