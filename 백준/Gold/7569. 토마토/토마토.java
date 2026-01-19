
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][][] arr;
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    static class Node{
        int x, y, z, day;

        public Node(int x, int y, int z, int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        H = Integer.parseInt(s[2]);
        arr = new int[N][M][H];

        Queue<Node> q = new LinkedList<>();

        for(int k=0; k<H; k++) {
            for (int i = 0; i < N; i++) {
                s = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    arr[i][j][k] = Integer.parseInt(s[j]);
                    if(arr[i][j][k] == 1){
                        q.offer(new Node(i, j, k, 0));
                    }
                }
            }
        }

        System.out.println(bfs(q));
    }

    static int bfs(Queue<Node> q){
        int maxDay = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            maxDay = Math.max(maxDay, node.day);

            for(int i=0; i<6; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H){
                    continue;
                }
                if(arr[nx][ny][nz] == 0){
                    arr[nx][ny][nz] = 1;
                    q.offer(new Node(nx, ny, nz, node.day + 1));
                }
            }
        }

        // 익지 않은 토마토 확인
        for(int k=0; k<H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j][k] == 0){
                        return -1;
                    }
                }
            }
        }
        
        return maxDay;
    }
}