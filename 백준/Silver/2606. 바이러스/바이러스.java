
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] lst;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        lst = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            lst[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            lst[a].add(b);
            lst[b].add(a);
        }

        visited[1] = true;
        dfs(1);

        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(visited[i]){
                cnt++;
            }
        }
        System.out.println(cnt-1);
    }

    static void dfs(int start){

        for(int num : lst[start]){
            if(!visited[num]){
                visited[num] = true;
                dfs(num);
            }
        }

    }
}
