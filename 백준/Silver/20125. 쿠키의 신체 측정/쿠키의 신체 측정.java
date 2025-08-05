
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int headx = 0, heady = 0;
        A:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '*') {
                    headx = i;
                    heady = j;
                    break A;
                }
            }
        }

        int heartx = headx + 1;
        int hearty = heady;
        int leftArm = 0;
        for (int i = 0; i < hearty; i++) {
            if (arr[heartx][i] == '*') {
                leftArm++;
            }
        }

        int rightArm = 0;
        for (int i = hearty+1; i < N; i++) {
            if (arr[heartx][i] == '*') {
                rightArm++;
            }
        }

        int wrist = 0;
        int wristx = 0, wristy = 0;
        for (int i = heartx + 1; i < N; i++) {
            if (arr[i][hearty] == '*') {
                wrist++;
                wristx = i;
                wristy = hearty;
            }
        }

        int leftLeg = 0;
        for (int i = wristx; i < N; i++) {
            if (arr[i][wristy -1] == '*') {
                leftLeg++;
            }
        }

        int rightLeg = 0;
        for (int i = wristx; i < N; i++) {
            if (arr[i][wristy +1] == '*') {
                rightLeg++;
            }
        }

        System.out.println((heartx+1) + " " + (hearty+1));
        System.out.println(leftArm + " " + rightArm + " " + wrist + " " + leftLeg + " " + rightLeg);

    }
}
