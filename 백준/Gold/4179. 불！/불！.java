import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// G3_4179_불!
public class Main {
    static int R, C;
    static char [][]map;
    static int[][] dist1; // 불 전파 시간
    static int[][] dist2; // 지훈이 이동 시간
    static  int[] dx, dy;
    static Queue<Pair> Q1;
    static Queue<Pair> Q2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1<= R, C <= 1000
        R = Integer.parseInt(st.nextToken()); // rows
        C =Integer.parseInt(st.nextToken()); // columns

        map = new char[R][C];
        dist1 = new int[R][C]; // 불 전파 시간
        dist2 = new int[R][C]; // 지훈이의 이동 시간
        Q1 = new LinkedList<>();
        Q2 = new LinkedList<>();
        dx = new int[] {1, 0, -1, 0};
        dy = new int[] {0, 1, 0, -1};


        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                dist1[i][j] = -1; // 불 전파 시간 초기화
                dist2[i][j] = -1; // 불 전파 시간 초기화
                if (map[i][j] == 'F'){
                    Q1.offer(new Pair(i, j));
                    dist1[i][j] = 0; // 불의 시작 위치
                }
                if (map[i][j] == 'J') {
                    Q2.offer(new Pair(i, j));
                    dist2[i][j] = 0; // 지훈이의 시작 위치
                }
            }
        }

        // 불 전파 BFS
        while (!Q1.isEmpty()) {
            Pair cur = Q1.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (dist1[nx][ny] >= 0 || map[nx][ny] == '#') continue;
                dist1[nx][ny] = dist1[cur.x][cur.y] + 1; // 불 전파 시간 갱신
                Q1.offer(new Pair(nx, ny));
            }
        }

        // 지훈이 이동 BFS
        while (!Q2.isEmpty()) {
            Pair cur = Q2.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                // 범위를 벗어났다는 것은 지훈이가 탈출했다는 의미
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        System.out.println(dist2[cur.x][cur.y] + 1);
                        return; // 탈출 성공
                }
                if (dist2[nx][ny] >= 0 || map[nx][ny] == '#') continue; // 방문한 곳이거나 벽인 경우

                if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.x][cur.y] + 1 ) continue; // 불이 먼저 도착한 곳
                dist2[nx][ny] = dist2[cur.x][cur.y] + 1; // 지훈이 이동 시간 갱신
                Q2.offer(new Pair(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}