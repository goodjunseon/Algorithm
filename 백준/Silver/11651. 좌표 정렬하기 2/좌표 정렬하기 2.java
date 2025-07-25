import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static class Dot{
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

//        Dot[] dot =  new Dot[N];
        ArrayList<Dot> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Dot(x, y));
        }

        // x 좌표 비교
        list.sort(Comparator.comparingInt((Dot p) -> p.y).thenComparingInt(p -> p.x));

        for (int i = 0; i < N; i++) {
            bw.write(list.get(i).x + " " + list.get(i).y+ "\n");
        }

        bw.flush();
        bw.close();


    }
}