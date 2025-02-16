
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    static int[] arr;
    static int[] ans;
    static int n;
    static StringBuilder sb;

    static void dfs(int depth, int start){

        if(depth == 6){
            for (int i = 0; i < 6; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i= start; i< n; i++){
            ans[depth] = arr[i];
            dfs(depth+1, i+1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] s = br.readLine().split(" ");
            if(Objects.equals(s[0], "0")){
                break;
            }
            n = Integer.parseInt(s[0]);
            arr = new int[n];
            ans = new int[6];
            sb = new StringBuilder();
            for(int i=0; i< n; i++){
                arr[i] = Integer.parseInt(s[i+1]);
            }

            /////입력
            dfs(0, 0);

            System.out.println(sb);
        }

    }
}
