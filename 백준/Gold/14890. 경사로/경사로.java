
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, L;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        int result = rowCheck() + colCheck();
        System.out.println(result);
    }

    static int rowCheck() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (canPass(i, true)) {
                cnt++;
            }
        }
        return cnt;
    }

    static int colCheck() {
        int cnt = 0;
        for (int j = 0; j < N; j++) {
            if (canPass(j, false)) {
                cnt++;
            }
        }
        return cnt;
    }


    static boolean canPass(int idx, boolean isRow) {
        boolean[] installed = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int current = isRow ? arr[idx][i] : arr[i][idx];
            int next = isRow ? arr[idx][i + 1] : arr[i + 1][idx];

            if (current == next) {
                continue;
            }

            if (Math.abs(current - next) > 1) {
                return false;
            }

            if (current - next == 1) {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N) {
                        return false;
                    }
                    int target = isRow ? arr[idx][i + j] : arr[i + j][idx];
                    if (target != next || installed[i + j]) {
                        return false;
                    }
                    installed[i + j] = true;
                }
            } else if (current - next == -1) {
                for (int j = 0; j < L; j++) {
                    if (i - j < 0) {
                        return false;
                    }

                    int target = isRow ? arr[idx][i - j] : arr[i - j][idx];
                    if (target != current || installed[i - j]) {
                        return false;
                    }
                    installed[i - j] = true;

                }
            }
        }
        return true;
    }



}