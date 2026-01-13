
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int M;
    static boolean[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N+1];
        dp = new boolean[N+1][N+1];
        String[] s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i+1] = Integer.parseInt(s[i]);
        }

        checkIfPal();
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            int ss = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);

            if(dp[ss][e])
                sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.println(sb);

    }

    static void checkIfPal(){
        for(int i=1; i<=N; i++){
            dp[i][i] = true;
        }
        for(int i=1; i<=N-1; i++){
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = true;
            }
        }
        for(int i=2; i<N; i++){
            for(int j=1; j<=N-i; j++){
                if(arr[j] == arr[j+i] && dp[j+1][i+j-1]){
                    dp[j][j+i] = true;
                }
            }
        }
    }
}