//package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static int[][] arr;
    static boolean[] dessert;
    //(0->1) (1->2) (2->3) (3->4) (현재위치를 기준으로)
    static int[] dx = {1, 1, -1, -1, 1};
    static int[] dy = {-1, 1, 1, -1, -1};
    static int curx, cury;
    static int result;
    static int maximum;

    static void dfs(int n, int x, int y) {
//        maximum = -1;
        //탈출 조건
        //n : 꺾는 횟수

        //1. n이 3보다 커지면 무조건 종료
        if (n > 3) {
            return;
        }
        //2. 3번 꺾고 시작지점에 다시 복귀하면 (현재지점 == 이동한지점)
            //dessert에 true값 몇개인지 개수세기
        if (n == 3 && (curx == x) && (cury == y)) {
            result = 0;
            for (int i = 0; i < 101; i++) {
                if (dessert[i]) {
                    result++;
                }
            }
            if(result > maximum)
                maximum = result;
        }

        //유지하거나 꺾거나 둘 중 하나
        for (int i = n; i < n + 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (dessert[arr[nx][ny]]) {
                continue;
            }
            dessert[arr[nx][ny]] = true;
            dfs(i, nx, ny);
            dessert[arr[nx][ny]] = false;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }

            //////압력끝

            //모든 좌표 순회하면서
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //매번 초기화
                    dessert = new boolean[101];
                    curx = i;
                    cury = j;
                    dfs(0, i, j);
                }
            }

            System.out.println("#" + (T + 1) + " " + maximum);
            //다음 테스트케이스에 영향주지 않기 위해 maximum 값 초기화
            maximum = -1;
        }


    }
}
