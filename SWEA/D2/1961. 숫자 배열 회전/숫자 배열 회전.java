
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();

            String[][] A = new String[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = scanner.next();
                }
            }

            System.out.println("#" + (t+1) + " ");
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    System.out.print(A[N-j-1][i]);
                }
                System.out.print(" ");
                for(int j = 0; j < N; j++) {
                    System.out.print(A[N-i-1][N-j-1]);
                }
                System.out.print(" ");
                for(int j = 0; j < N; j++) {
                    System.out.print(A[j][N-1-i]);
                }
                System.out.println();
            }

        }
    }
}
