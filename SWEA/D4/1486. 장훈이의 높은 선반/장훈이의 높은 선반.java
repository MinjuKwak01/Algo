
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int t, n, b;
    static int[] arr;
    static int answer;

    static void dfs(int depth, int sum){
        if(depth == n){
            if(sum >= b){
                int diff = sum - b;
                answer = Math.min(answer, diff);
                return;
            }
            return;
        }

        dfs(depth+1, sum + arr[depth]); //포함시키는 경우
        dfs(depth+1, sum); //포함시키지 않는 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int T = 1; T <= t; T++) {
            answer = Integer.MAX_VALUE;;
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            arr = new int[n];

            s = br.readLine().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(s[i]);
            }

            ///입력끝
            dfs(0,0);
            System.out.println("#" + T + " " + answer);

        }

    }
}
