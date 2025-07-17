
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int N, L, R;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static List<Node> group;
    static int days;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }


        while (true) {
            if(!isEdongPossible())
                break;
            days++;
        }

        System.out.println(days);
    }

    static void printArr() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        int sum = 0;

        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + node.x;
                int ny = dy[k] + node.y;

                //범위 안이라면
                if (isIn(nx, ny)) {
                    //주변 칸 차이 계산
                    int num = Math.abs(arr[nx][ny] - arr[node.x][node.y]);
                    //합칠 수 있는 칸이라면
                    if (num <= R && num >= L) {
                        //방문처리, 주변칸 큐에 넣기, group 리스트에 추가
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                        group.add(new Node(nx, ny));
                        sum += arr[nx][ny];
                    }
                }
            }
        }
        return sum;
    }

    static boolean isEdongPossible() {
        boolean isPossible = false;
        //하루가 지날때마다 visited를 초기화시켜줘야함
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //아직 방문하지 않은 칸이라면
                if (!visited[i][j]) {
                    //하나의 합쳐진 그룹을 반환
                    //bfs를 돌릴때마다 합쳐진 그룹을 초기화해줘야함
                    group = new ArrayList<>();
                    int sum = bfs(i, j);
                    //그룹 크기가 2칸 이상이라면
                    if (group.size() > 1) {
                        //그룹이 2이상이라는건 인구 이동이 한번이라도 일어난것이기 때문에 isPossible은 true
                        isPossible = true;
                        //평균 계산
                        int avg = sum / (group.size());
                        //각 칸 평균으로 만들어주기
                        for (Node n : group) {
                            arr[n.x][n.y] = avg;
                        }
                    }
                }
                //방문한 칸은 건너뜀
            }
        }
        return isPossible;
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && !visited[x][y];
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