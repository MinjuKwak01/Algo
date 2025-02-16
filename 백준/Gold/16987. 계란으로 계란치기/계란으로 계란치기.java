
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] arr;
    static int ans;

    static void dfs(int cnt, int curEgg){
        if(curEgg == n){
            ans = Math.max(ans, cnt);
            return;
        }

        if(arr[curEgg][0] <=0){
            dfs(cnt, curEgg+1);
            return;
        }

        boolean hit = false;
        for(int i =0; i<n; i++){
            if(curEgg == i || arr[i][0] <=0){
                continue;
            }
            //계란 부딪히기
            int broken = 0;
            arr[curEgg][0] -= arr[i][1];
            arr[i][0] -= arr[curEgg][1];
            //꺠졌다면
            if(arr[curEgg][0] <= 0){
                broken++;
            }
            if(arr[i][0] <=0){
                broken++;
            }
            hit = true;
            dfs(cnt + broken, curEgg+1);
            arr[curEgg][0] += arr[i][1];
            arr[i][0] += arr[curEgg][1];

        }
        if(!hit){
            dfs(cnt, curEgg+1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        //입력 끝
        dfs(0,0);
        System.out.println(ans);

    }
}
