import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class Main {

    //전역 변수 선언: 문제 전체에 걸쳐 사용
    static int N, M;
    static int[][] tomato;
    //방향 벡터 (상 하 좌 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};



    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        tomato = new int[N][M];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.offer(new Pair(i,j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int x = current.x;
            int y = current.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 체크 + 안 익은 토마토인지 확인
                if (nx >=0 && ny >= 0 && nx < N && ny < M) {
                    if (tomato[nx][ny] == 0) {
                        tomato[nx][ny] = tomato[x][y] + 1; // 날짜 증가
                        queue.offer(new Pair(nx,ny));
                    }
                }
            }
        }

        // 결과 확인: 익지 않은 토마토가 있으면 -1
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, tomato[i][j]);
            }
        }

        // 가장 큰 값 - 1 (초기 익은 토마토가 1이기 때문에)
        System.out.println(result-1);

    }
}