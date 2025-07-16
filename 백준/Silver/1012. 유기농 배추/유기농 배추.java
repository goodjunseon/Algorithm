import java.io.*;
import java.util.*;

// 유기농 배추
public class Main {
    static int M, N, K;
    static int[][] cabbage;
    static boolean[][] visited;

    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 크기
            N = Integer.parseInt(st.nextToken()); // 세로 크기
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            cabbage = new int[M][N];
            visited = new boolean[M][N];

            // 배추 심어진 위치 표시
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[x][y] = 1;
            }

            int count = 0;
            // 모든 칸을 돌며 아직 방문하지 않은 배추가 있으면 BFS
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbage[x][y] == 1 && !visited[x][y]) {
                        bfs(x, y);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        // 결과를 한번에 출력
        System.out.println(sb);
    }
        private static void bfs(int startX, int startY) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {startX, startY});
            visited[startX][startY] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                // 네 방향으로 퍼져 나가기
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    // 범위 체크 및 방문/배추 여부 확인
                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && cabbage[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
}

