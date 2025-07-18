import java.io.*;
import java.util.*;

// G5_7569_토마토
public class Main {
    static int M, N, H;
    static String line;
    static int[][][] tomato;

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                line = br.readLine();
                st = new StringTokenizer(line);
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        bfs(tomato);
        int max = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomato[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, tomato[i][j][k]);
                }
            }
        }

        System.out.println(max -1);
    }

    private static void bfs(int[][][] tomato) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomato[i][j][k] == 1) {
                        queue.offer(new int[] {i, j, k});
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];

            for (int d = 0; d < 6; d++) {
                int nz = z + dz[d];
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= nz && nz < H && 0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (tomato[nz][ny][nx] == 0) {
                        tomato[nz][ny][nx] = tomato[z][y][x] + 1;
                        queue.offer(new int[] {nz, ny, nx});
                    }
                }
            }



        }

    }
}


