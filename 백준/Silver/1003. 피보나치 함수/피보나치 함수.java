import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];

        // 초기값 설정
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;

        for(int i=2; i<=40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for(int i=0; i<N; i++) {
            int idx = Integer.parseInt(br.readLine());
            System.out.println(dp[idx][0] + " " + dp[idx][1]);
        }
    }
}
