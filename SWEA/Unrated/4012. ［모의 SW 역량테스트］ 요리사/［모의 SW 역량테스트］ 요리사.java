
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int T, N;
    static int[][] arr;
    static boolean[] visited;
    static int minimum;

    static void dfs(int cnt, int start) {
        if(cnt == N / 2) { //절반 고름
          //  System.out.println(Arrays.toString(visited));
            int sum1 = 0, sum2 = 0;

            for(int i = 0; i < N; i++) {
                for(int j = i + 1; j < N; j++){
                    if(visited[i] && visited[j]) {
                        sum1 += arr[i][j] + arr[j][i]; // 고른 식재료로 만든 음식
                    } else if(!visited[i] && !visited[j]) {
                        sum2 += arr[i][j] + arr[j][i]; // 나머지 식재료로 만든 음식
                    }
                }
            }
            int diff = Math.abs(sum1 - sum2);	// 맛의 차이
            minimum = Math.min(minimum, diff);		// 최솟값 비교
            return;
        }
        for(int i = start; i < N; i++) {
            visited[i] = true;
            dfs(cnt+1, i+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            minimum = Integer.MAX_VALUE;
            visited = new boolean[N];
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }
            dfs(0, 0);
            System.out.println("#" + (t+1) + " " + minimum);
        }

    }
}
