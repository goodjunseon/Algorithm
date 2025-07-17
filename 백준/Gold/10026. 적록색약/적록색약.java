import java.io.*;
import java.util.*;

// G5_10026_적록색약
// R/G/B or RG/B
public class Main {
    static int N;
    static String s;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static char arr[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];
        int countA = 0;
        int countB = 0;

        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    countA++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i,j);
                    countB++;
                }
            }
        }
        System.out.println(countA + " " + countB);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char color = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0<= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                if (arr[nx][ny] == color) {
                    dfs(nx,ny);
                }
            }
        }
    }
}


