import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        final int OFFSET = 1_000_000;
        int[] arr = new int[2_000_001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num + OFFSET]++;
        }


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                for (int j = 0; j < arr[i]; j++) {
                    bw.write(i - OFFSET + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}