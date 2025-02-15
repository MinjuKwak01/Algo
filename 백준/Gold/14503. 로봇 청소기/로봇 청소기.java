
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int curx, cury;
    static int dir;
    static int cnt;
    // 방향: 북(0), 동(1), 남(2), 서(3)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    static void dfs(int x, int y, int dir) {

        if (!visited[x][y]) {
            //현재 칸 청소
            visited[x][y] = true;
            cnt++;
        }


        for (int i = 0; i < 4; i++) {
            // 반시계 방향으로 회전 (왼쪽 방향)
            dir = (dir + 3) % 4;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 전진할 수 있으면 이동 후 다시 DFS
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny, dir);
                return; // 이동 후 즉시 종료 (불필요한 반복 제거)
            }
        }

        // 네 방향 모두 청소되었거나 벽이 있는 경우 → 후진 시도
        int backDir = (dir + 2) % 4; // 반대 방향 계산
        int backX = x + dx[backDir];
        int backY = y + dy[backDir];

        // 후진할 수 있으면 후진 후 DFS 호출
        if (backX >= 0 && backX < n && backY >= 0 && backY < m && arr[backX][backY] == 0) {
            dfs(backX, backY, dir);
        }
    }

    //주변 4칸 중 청되지 않은 빈칸이 있는 경우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        curx = Integer.parseInt(s[0]);
        cury = Integer.parseInt(s[1]);
        dir = Integer.parseInt(s[2]);

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] sarr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(sarr[j]);
            }
        }

        ///입력 끝
        dfs(curx, cury, dir);

        System.out.println(cnt);


    }
}
