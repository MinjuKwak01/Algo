
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, r, c, l;
    static int[][] p = {{0, 0, 0, 0}, {1, 1, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 0, 1}, {0, 1, 0, 1},
            {0, 1, 1, 0}, {1, 0, 1, 0}};
    static int[][] dist;
    static int[] opp = {1, 0, 3, 2};

    static int bfs(int x, int y) {

        int ans = 0;
        //시작점 큐에 넣기
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        dist[x][y] = 1;
        ans += 1;

        while (!q.isEmpty()) {
            //큐에서 하나 꺼내기
            Node cur = q.poll();
            int curx = cur.x;
            int cury = cur.y;
            if (dist[curx][cury] == l) {
                return ans;
            }
            //사방탐색
            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                //경계 벗어나면 continue
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || dist[nx][ny] != 0) {
                    continue;
                }
                //현재 위치로 갈 수 있는 루트가 있고 움직인 칸에도 반대방향이 있을때
                if (p[arr[curx][cury]][i] == 1 && p[arr[nx][ny]][opp[i]] == 1) {
                    q.add(new Node(nx, ny));
                    dist[nx][ny] = dist[curx][cury] + 1;
                    ans += 1;
                }
            }
        }
        //가능한 위치보다 더 긴 시간을 준 경우
        return ans;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int T = 0; T < t; T++) {
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            r = Integer.parseInt(s[2]);
            c = Integer.parseInt(s[3]);
            l = Integer.parseInt(s[4]);

            arr = new int[n][m];
            dist = new int[n][m];

            for (int i = 0; i < n; i++) {
                String[] sr = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(sr[j]);
                }
            }
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(arr[i][j]);
//                }
//                System.out.println();
//            }

            int result = bfs(r, c);
            System.out.println("#" + (T + 1) + " " + result);
        }

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
