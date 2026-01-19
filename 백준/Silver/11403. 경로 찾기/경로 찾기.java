
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        res = new int[N][N];

        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i=0; i<N; i++){
            bfs(i);
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];

        for(int i=0; i<N; i++){
            if(arr[start][i] == 1){
                q.offer(i);
                visited[i] = true;
                res[start][i] = 1;
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0; i<N; i++){
                if(arr[now][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    res[start][i] = 1;
                }
            }
        }

    }
}
