
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n,m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] result;

    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));

        while(!q.isEmpty()){
            Node curNode = q.poll();
            int curX = curNode.x;
            int curY = curNode.y;
            int curDist = curNode.dist;

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || nx >=n || ny < 0 || ny>=m || arr[nx][ny] == 0 || visited[nx][ny])
                    continue;
                Node newNode = new Node(nx, ny, curDist+1);
                result[nx][ny] = curDist+1;
                q.offer(newNode);
                visited[nx][ny] = true;

            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m;j++){
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs(0,0);
        System.out.println(result[n-1][m-1]);

    }

    static class Node{
        int x;
        int y;
        int dist;
        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
