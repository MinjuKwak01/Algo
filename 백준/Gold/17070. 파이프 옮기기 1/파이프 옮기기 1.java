
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        //가로 0, 세로 1, 대각선 2
        dfs(0, 1, 0);
        System.out.println(cnt);

    }

    static void dfs(int x, int y, int status) {
        if (x == N - 1 && y == N - 1) {
            cnt++;
            return;
        }

        //가로
        if (status == 0) {
            if (y + 1 < N && arr[x][y + 1] != 1) {
                dfs(x, y + 1, 0);
            }
            if (x + 1 < N && y + 1 < N && arr[x + 1][y] != 1 && arr[x][y + 1] != 1 && arr[x + 1][y + 1] != 1) {
                dfs(x + 1, y + 1, 2);
            }
        } else if (status == 1) {
            if (x + 1 < N && arr[x + 1][y] != 1) {
                dfs(x + 1, y, 1);
            }
            if (x + 1 < N && y + 1 < N && arr[x + 1][y] != 1 && arr[x][y + 1] != 1 && arr[x + 1][y + 1] != 1) {
                dfs(x + 1, y + 1, 2);
            }
        } else if (status == 2) {
            if (y + 1 < N && arr[x][y + 1] != 1) {
                dfs(x, y + 1, 0);
            }
            if (x + 1 < N && arr[x + 1][y] != 1) {
                dfs(x + 1, y, 1);
            }
            if (x + 1 < N && y + 1 < N && arr[x + 1][y] != 1 && arr[x][y + 1] != 1 && arr[x + 1][y + 1] != 1) {
                dfs(x + 1, y + 1, 2);
            }
        }
    }
}
