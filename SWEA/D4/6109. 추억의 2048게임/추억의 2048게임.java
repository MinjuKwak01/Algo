import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] map;


    static void func(String cmd) {
        if(cmd.equals("up")) {
            play();
        }
        else if(cmd.equals("right")) {
            rotate(1);
            play();
            rotate(3);
        }
        else if(cmd.equals("left")) {
            rotate(3);
            play();
            rotate(1);
        }
        else {
            rotate(2);
            play();
            rotate(2);
        }
    }

    //cnt만큼 방향 왼쪽으로 돌려주기
    static void rotate(int cnt) {
        for(int t = 0; t < cnt; t++) {
            int[][] temp = new int[N][N];
            for(int i = 0; i < N; i++ ) {
                for(int j = 0, k = N-1; j < N; j++, k--) {
                    temp[k][i] = map[i][j];
                }
            }
            map = temp;
        }
    }

    // 위로 합치기
    static void play() {
        int[][] temp = new int[N][N];

        for(int i = 0; i < N; i++) {
            int cnt = 0; // temp 에 들어갈 좌표
            for(int j = 0; j < N; j++) {
                if(map[j][i] == 0) continue;
                // 0 이라면 아직 입력이 안 된것
                if(temp[cnt][i] == 0) {
                    // map 의 숫자를 가져옴
                    temp[cnt][i] = map[j][i];
                }
                else {
                    // 만약 다른 숫자가 들어있다면 -> 다음 항목과 비교해주기
                    // 다음 행 숫자와 같다면 *2 넣어주고 cnt ++
                    if(temp[cnt][i] == map[j][i]) {
                        temp[cnt++][i] = map[j][i] * 2;
                    }
                    else {
                        //다음 행 숫자와 다르다면 ++cnt 칸에 숫자 넣어주기
                        temp[++cnt][i] = map[j][i];
                    }
                }
            }
        }
        map = temp;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            String cmd = st.nextToken();

            map = new int[N+1][N+1];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            func(cmd);
            System.out.println("#" + tc);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++ ) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}