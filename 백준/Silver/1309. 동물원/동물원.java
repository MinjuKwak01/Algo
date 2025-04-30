import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[100001][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        int sum = 0;
        for (int i = 2; i <= 100000; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];

            dp[i][0] %= 9901;
            dp[i][1] %= 9901;
            dp[i][2] %= 9901;
        }

        sum = (dp[N][0] + dp[N][1] + dp[N][2]) ;
        
        System.out.println(sum % 9901);


    }
}
