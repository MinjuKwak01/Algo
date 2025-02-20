import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] dx = {-1, 1, 0}; // 좌, 우, 상 (x 방향 이동)
    static int[] dy = {0, 0, -1}; // 좌, 우, 상 (y 방향 이동)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(br.readLine()).append(" ");

            int[][] ladder = new int[100][100];
            int x = 0, y = 99; // x : 열, y: 행

            // 사다리 입력 및 도착점 찾기
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if (i == 99 && ladder[i][j] == 2)
                    	x = j;
                }
            }

            // 사다리 역추적
            int nx, ny;
            //y좌표가 0이 되기 전까지
            while (y != 0) {
                for (int k = 0; k < 3; k++) {
                    nx = x + dx[k];
                    ny = y + dy[k];
                    //경계를 벗어나거나 길이 없는 경우
                    if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || ladder[ny][nx] == 0)
                    	continue;
                    x = nx;
                    y = ny;
                    ladder[ny][nx] = 0; // 방문한 곳 체크
                }
            }

            sb.append(x).append("\n");
        }

        System.out.print(sb);
    }
}
