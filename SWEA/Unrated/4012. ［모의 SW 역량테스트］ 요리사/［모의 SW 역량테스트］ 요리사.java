
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int T;
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int res;

    static void dfs(int depth, int cnt) {
        if (depth == N / 2) {
            check();
            return;
        }
        for (int i = cnt; i < N; i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;

        }
    }

    static void check() {
        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    sumA += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    sumB += arr[i][j] + arr[j][i];
                }
            }
        }

        int min = Math.abs(sumA - sumB);
        res = Math.min(res, min);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N];
            res = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }
            dfs(0, 0);
            System.out.println("#" + tc + " "  + res);

        }

    }
}
