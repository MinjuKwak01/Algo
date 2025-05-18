
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] count;

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int size;

        public Node(int x, int y, int size){
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public int compareTo(Node o) {
            return this.size - o.size;
        }
    }

    static void dijkstra(int x, int y, int cnt){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(x, y, cnt));

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;

                if(nx<0 || ny< 0 || nx >=N || ny>=N)
                    continue;
                if(count[nx][ny] <= arr[nx][ny] + node.size)
                    continue;
                count[nx][ny] = arr[nx][ny] + node.size;
                q.offer(new Node(nx, ny, count[nx][ny]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc=1;
        while(true){
            N = Integer.parseInt(br.readLine());

            if(N == 0) {
                return;
            }
            count = new int[N][N];
            arr = new int[N][N];

            for(int i=0; i< N; i++){
                String[] s = br.readLine().split(" ");
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(s[j]);
                    count[i][j] = Integer.MAX_VALUE;
                }
            }

            dijkstra(0,0,arr[0][0]);

            System.out.println("Problem " + tc + ": " + count[N-1][N-1]);
            tc++;
        }

    }
}
