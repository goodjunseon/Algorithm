import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
        bw.close();

    }
}