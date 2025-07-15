import java.io.*;
import java.util.StringTokenizer;

// 웰컴 키트
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] shirts = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine()); // 참가자 수

        int countS = 0;
        int countPens = 0;
        int countPen = 0;

        for (int i = 0; i < 6; i++) {
            shirts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        for (int shirt : shirts) {
            if (shirt <= 0) {
                countS += 0;
            }else if (shirt <= T) {
                countS++;
            }else if (shirt%T == 0){
                countS += shirt/T;
            }else if (shirt%T != 0) {
                countS += shirt/T + 1;
            }
        }

        countPens = N / P;
        countPen = N % P;

        System.out.println(countS);
        System.out.println(countPens + " " + countPen);


    }
}