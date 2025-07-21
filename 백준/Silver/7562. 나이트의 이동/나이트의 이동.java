import java.io.*;
import java.util.*;

// S1_7562_나이트의_이동
public class Main {
    static int I, N, X, Y;
    static int movX, movY;
    static String line;
    static int[][] map;
    static boolean[][] visited;


    // 상하좌우
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            I = Integer.parseInt(br.readLine()); // 한변의 길이
            map = new int[I][I];
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            movX = Integer.parseInt(st.nextToken());
            movY = Integer.parseInt(st.nextToken());
//            System.out.println("map: " + I);
//            System.out.println("X:" + X);
//            System.out.println("Y:" + Y);
//            System.out.println("movX:" + movX);
//            System.out.println("movY:" + movY);
            bfs();
            sb.append(map[movX][movY]).append("\n");
        }
        System.out.println(sb);

    }


    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{X, Y});
        visited[X][Y] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int nx = current[0];
            int ny = current[1];

            for (int i = 0; i < 8; i++) {
                int ox = nx + dx[i];
                int oy = ny + dy[i];

                if (ox >= 0 && ox < I && oy >= 0 && oy < I) {
                    if (!visited[ox][oy]) {
                        q.add(new int[]{ox, oy});
                        map[ox][oy] = map[nx][ny] + 1;
                        visited[ox][oy] = true;
                    }
                }
            }
        }
    }

}

