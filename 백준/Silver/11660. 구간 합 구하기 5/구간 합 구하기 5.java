

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] sum;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        sum = new int[n][n];
        arr = new int[n][n];
        ans = new int[m];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        //누적 합 구하기
        for (int i = 0; i < n; i++) {
            int summation = 0;
            for (int j = 0; j < n; j++) {
                summation += arr[i][j];
                sum[i][j] = summation;
            }
        }

        int index = 0; //ans 배열에 넣을 index값
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);

            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);

            int sub = 0;
            int sumRows = 0;
            //두 좌표가 모두 같을 경우 해당 좌표에 있는 값 반환
            if (x1 == x2 && y1 == y2) {
                ans[index] = arr[x1 - 1][y1 - 1];
            }
            //뺄 값과 더할 값 구하기
            for (int j = x1; j < x2 + 1; j++) {
                //y1이 1일 경우 뺄 값은 없기 때문에 분기처리
                if (y1 != 1) {
                    sub += sum[j - 1][y1 - 2];
                }
                sumRows += sum[j - 1][y2 - 1];

            }
            ans[index] = sumRows - sub;
            index++;
        }
        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }
    }
}
