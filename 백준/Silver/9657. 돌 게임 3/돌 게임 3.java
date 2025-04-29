
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //1, 3, 4
        int[] dp = new int[1001];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 0;
        for(int i= 5; i<=1000; i++){
            if(dp[i-1] + dp[i-3] + dp[i-4] == 0)
                dp[i] = 1;
            else{
                dp[i] = 0;
            }
        }

        if(dp[N] == 0){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }


    }
}
