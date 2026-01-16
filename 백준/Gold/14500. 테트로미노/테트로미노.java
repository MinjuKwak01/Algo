
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        visited = new boolean[N][M];
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                func(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void func(int x, int y, int sum, int cnt){
        //각 점에서
        if(cnt == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >=N || ny >=M){
                continue;
            }

            if(!visited[nx][ny]){

                if(cnt == 2){
                    visited[nx][ny] = true;
                    func(x, y, sum + arr[nx][ny], cnt+1);
                    visited[nx][ny] = false;
                }
                visited[nx][ny] = true;
                func(nx, ny, sum + arr[nx][ny], cnt+1);
                visited[nx][ny] = false;
            }

        }

    }
}