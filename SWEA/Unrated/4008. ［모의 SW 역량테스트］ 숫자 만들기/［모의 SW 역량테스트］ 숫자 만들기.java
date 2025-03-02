

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int T, N;
    static int[] arr;
    static int[] opCnt;  // {+, -, *, /} 연산자 개수
    static int maximum, minimum;

    static void dfs(int depth, int value) {
        if (depth == N - 1) { // 연산자가 모두 사용된 경우
            maximum = Math.max(maximum, value);
            minimum = Math.min(minimum, value);
            return;
        }

        // 연산자 사용하면서 DFS 탐색
        for (int i = 0; i < 4; i++) {
            if (opCnt[i] > 0) {
                opCnt[i]--;  // 연산자 사용

                int newValue = value;
                switch (i) {
                    case 0: newValue += arr[depth + 1]; break;
                    case 1: newValue -= arr[depth + 1]; break;
                    case 2: newValue *= arr[depth + 1]; break;
                    case 3: newValue /= arr[depth + 1]; break;
                }

                dfs(depth + 1, newValue);
                opCnt[i]++;  // 연산자 복구
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            opCnt = new int[4]; // {+, -, *, /} 개수 저장
            String[] s = br.readLine().split(" ");

            for (int i = 0; i < 4; i++) {
                opCnt[i] = Integer.parseInt(s[i]);
            }

            s = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            // 초기화
            maximum = Integer.MIN_VALUE;
            minimum = Integer.MAX_VALUE;

            // 백트래킹 시작 (첫 번째 숫자는 그대로 사용)
            dfs(0, arr[0]);

            System.out.println("#" + tc + " " + (maximum - minimum));
        }
    }
}
