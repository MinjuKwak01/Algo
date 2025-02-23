
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            for(int i = 0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            int max = Integer.MIN_VALUE;

            //파리가 있는 영역
            for(int i = 0; i<=N-M; i++) {
                for(int j = 0; j<=N-M; j++) {
                    int sum = 0;
                    //파리채
                    for(int k = 0; k<M; k++) {
                        for(int l = 0; l<M; l++) {
                            sum += arr[i+k][j+l];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.println(sb);

    }
}
