
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }

            int max = 0;
            for (int i = 0; i <= Math.abs(N - M); i++) {
                int sum = 0;
                for (int j = 0; j < Math.min(N, M); j++) {
                    if (N > M){
                        sum += A[j+i] * B[j];
                    }else{
                        sum += A[j] * B[i+j];
                    }
                }
                //System.out.println(sum);
                if (max < sum) {
                    max = sum;
                }
            }

            System.out.println("#" + (t + 1) + " " + max);
            //012
            //123
            //234
            // 5/(3-1) + 1
            //7/(6-1)+1
        }
    }
}
