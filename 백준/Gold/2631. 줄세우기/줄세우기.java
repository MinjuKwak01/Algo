import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        Arrays.fill(dp, 1);
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                   dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int maximum = 0;
        for(int i=0; i<N; i++){
            maximum = Math.max(maximum, dp[i]);
        }

        System.out.println(N - maximum);


    }
}
