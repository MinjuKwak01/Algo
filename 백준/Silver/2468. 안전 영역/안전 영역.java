
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] arr;
    static int maximum;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int cnt;
    static int answer =1;

    static void dfs(int x, int y, int h){
        visited[x][y] = true;
        //사방 탐색을 하며
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            //경계 밖이거나 높이보다 같거나 낮다면, 방문했다면 continue
            if(nx < 0 || nx >=n || ny < 0 || ny >=n || arr[nx][ny] <= h || visited[nx][ny])
                continue;

            //경계 안이고 높이보다 높고 방문안했다면
            dfs(nx, ny, h);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                maximum = Math.max(arr[i][j], maximum);
            }
        }
        ///입력 끝

        // 높이 1~maximum
        for (int i = 1; i <= maximum; i++) {
            visited = new boolean[n][n];
            cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    //높이보다 크거나 && 방문하지 않았다면
                    if (i < arr[j][k] && !visited[j][k]){
                        cnt++;
                        dfs(j, k, i);
                    }
                }
            }
            answer = Math.max(answer, cnt);

        }

        System.out.println(answer);


    }
}
