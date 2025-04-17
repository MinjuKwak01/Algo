

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int T, N, M, K;
    static List<Node> lst;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;

    static class Node{
        int x;
        int y;
        int k;
        int dir;

        public Node(int x, int y, int k ,int dir){
            this.x = x;
            this.y = y;
            this.k = k;
            this.dir = dir;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void updateK() {
            if(k == 1)
                this.k = 0;
            else
                this.k /=2;
        }

        public void changeDir(){
            if(this.dir == 1)
                this.dir = 0;
            else if(this.dir == 0)
                this.dir = 1;
            else if(this.dir == 2)
                this.dir = 3;
            else if(this.dir == 3)
                this.dir = 2;
        }
    }
    static void printArr(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            K = Integer.parseInt(s[2]);

            lst = new ArrayList<>();
            arr = new int[N][N];

            for (int i = 0; i < K; i++) {
                s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                int k = Integer.parseInt(s[2]);
                int dir = Integer.parseInt(s[3]);

                lst.add(new Node(x, y, k, dir-1));
                arr[x][y]++;
            }

            while (M-- > 0) {
                //미생물 이동
                moveNode();

                //약품에 칠해진 노드 확인 후 값 업데이트
                checkInYakPoom();

                //두 개 이상의 군집이 한 셀에 모이는 경우 확인
                checkIfMoreThanTwo();

            }

            //미생물 총합 구하기
            int ans = calcSum();
            System.out.println("#" + (tc+1) + " " + ans);

        }

    }

    static void moveNode(){
        for(int i=0; i<lst.size(); i++){
            Node cur = lst.get(i);
            int nx = dx[cur.dir] + cur.x;
            int ny = dy[cur.dir] + cur.y;

            //위치 값 업데이트
            if(nx >=0 && ny >= 0 && nx < N && ny < N) {
                arr[cur.x][cur.y] --;
                arr[nx][ny] ++;
                cur.setX(nx);
                cur.setY(ny);
            }
        }
    }

    static void checkInYakPoom(){
        for(int i=0; i<lst.size(); i++){
            Node cur = lst.get(i);
            //약품에 있다면
            if(cur.x == 0 || cur.x == N-1 || cur.y == 0 || cur.y == N-1){
                cur.updateK();
                cur.changeDir();
            }
        }
    }

    static void checkIfMoreThanTwo(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] > 1){
                    //군집 합치기
                    //위치가 i, j에 해당하는 것이 있다면 모두 remove
                    int sum = 0;
                    int maximum = -1;
                    int newDir = 0;
                    for(int k=lst.size() - 1; k>=0; k--){
                        Node cur = lst.get(k);
                        if(cur.x == i && cur.y == j) {
                            lst.remove(k);
                            sum += cur.k;
                            if(maximum < cur.k){
                                maximum = cur.k;
                                newDir = cur.dir;
                            }
                            arr[i][j] --;
                        }
                    }

                    //새롭게 구한 미생물 add
                    lst.add(new Node(i, j, sum, newDir));
                    arr[i][j] ++;
                }
            }
        }
    }

    static int calcSum(){
        int ans = 0;
        for(int i=0; i<lst.size(); i++){
            Node cur = lst.get(i);
            ans += cur.k;
        }
        return ans;
    }
}
